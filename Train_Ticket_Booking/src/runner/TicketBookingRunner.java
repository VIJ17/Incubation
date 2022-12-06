package runner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import datacarier.TicketDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import logiclayer.UserLayer;

public class TicketBookingRunner
{
	private static Scanner sc = new Scanner(System.in);
	
	private long getLong()
	{
		long value = sc.nextLong();
		sc.nextLine();
		return value;
	}
	
	private int getInt()
	{
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}
	
	private String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	
	@SuppressWarnings("unused")
	private static void createUser(TicketBookingRunner run)
	{
		Map<Long,UserDetails> userMap = new Hashtable<>();
		
		System.out.println("Enter no of users.");
		int n = run.getInt();
		
		for(int i = 0; i < n; i++)
		{
			UserDetails userDetails = new UserDetails();
			System.out.println("Enter userID.");
			long userID = run.getLong();
			System.out.println("Enter password.");
			String password = run.getString();
			System.out.println("Enter name.");
			String name = run.getString();
			System.out.println("Enter age.");
			int age = run.getInt();
			System.out.println("Enter mobile number.");
			long mobile = run.getLong();
			System.out.println("Enter Aadhar number.");
			long aadharNo = run.getLong();
			
			userDetails.setUserID(userID);
			userDetails.setPassword(password);
			userDetails.setName(name);
			userDetails.setAge(age);
			userDetails.setMobileNo(mobile);
			userDetails.setAadharNo(aadharNo);
			
			userMap.put(userID, userDetails);
		}
		
		ObjectOutputStream objStream = null;
		
		try
		{
			FileOutputStream fileStream = new FileOutputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/UserDetails.txt");
			objStream = new ObjectOutputStream(fileStream);
			
			objStream.writeObject(userMap);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				objStream.close();
			}
			catch(Exception e) {}
		}
	}
	
	private void reservation(List<TicketDetails> passengersList, UserLayer userLyr, TicketBookingRunner run) throws WrongEntryException
	{
		List<Integer> seatsArray = userLyr.reservation();
		int noOfSeats = passengersList.size();
		long pnrNo = System.currentTimeMillis();
		Map<Long,List<TicketDetails>> bookedTickets = userLyr.bookedTickets();
		List<TicketDetails> confirmedList = new ArrayList<>();
		Map<Long,TicketDetails> waitingMap = userLyr.waitingList();
		List<Long> WaitingIDList = new ArrayList<>();
		
		for(int i = 0; i < noOfSeats; i++)
		{
			int index = seatsArray.indexOf(0);
			
			if(index != -1)
			{
				TicketDetails ticketDetails = passengersList.get(i);
				ticketDetails.setPnrNo(pnrNo);
				if((index+1) <= 6)
				{
					ticketDetails.setCoach("LOWER");
				}
				else if((index+1) > 11)
				{
					ticketDetails.setCoach("UPPER");
				}
				else
				{
					ticketDetails.setCoach("MIDDLE");
				}
				ticketDetails.setSeatNo(index+1);
				
				seatsArray.set(index, 1);
				confirmedList.add(ticketDetails);
			}
			else
			{
				TicketDetails ticketDetails = passengersList.get(i);
				long waitingID = System.currentTimeMillis() - pnrNo;
				WaitingIDList.add(waitingID);
				ticketDetails.setWaitingID(waitingID);
				waitingMap.put(waitingID, ticketDetails);
			}
		}
		bookedTickets.put(pnrNo, confirmedList);
		
		ObjectOutputStream objStream = null;
		
		try
		{
			FileOutputStream fileStream = new FileOutputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/BookedTickets.txt");
			objStream = new ObjectOutputStream(fileStream);
			objStream.writeObject(bookedTickets);
			try
			{
				objStream.close();
			}
			catch(Exception e) {}
			fileStream = new FileOutputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/WaitingList.txt");
			objStream = new ObjectOutputStream(fileStream);
			objStream.writeObject(waitingMap);
			System.out.println("_______________________________________________________________________");
			
			for(int i = 0; i < confirmedList.size(); i++)
			{
				TicketDetails ticketDetails = confirmedList.get(i);
				System.out.println("*----------------*");
				System.out.println("|TICKE CONFIRMED|");
				System.out.println("*----------------*");
				System.out.println("TRAIN NAME : PALLAVAN EXPRESS");
				System.out.println("PNR NO : " + ticketDetails.getPnrNo());
				System.out.println("PASSENGER NAME : " + ticketDetails.getPassengerName());
				System.out.println("GENDER : " + ticketDetails.getGender());
				System.out.println("AGE : " + ticketDetails.getAge());
				System.out.println("SEAT NO : " + ticketDetails.getSeatNo());
				System.out.println("COACH : " + ticketDetails.getCoach());
				System.out.println("FROM : " + ticketDetails.getFromPlace());
				System.out.println("TO : " + ticketDetails.getToPlace());
				System.out.println("_______________________________________________________________________");
			}
			
			for(long waitingID : WaitingIDList)
			{
				TicketDetails ticketDetails = waitingMap.get(waitingID);
				System.out.println("--------------");
				System.out.println("|WAITING LIST|");
				System.out.println("--------------");
				System.out.println(ticketDetails.getWaitingID());
				System.out.println(ticketDetails.getPassengerName());
				System.out.println(ticketDetails.getGender());
				System.out.println(ticketDetails.getAge());
				System.out.println("FROM : " + ticketDetails.getFromPlace());
				System.out.println("TO : " + ticketDetails.getToPlace());
				System.out.println("_______________________________________________________________________");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				objStream.close();
			}
			catch(Exception e) {}
		}
		
	}
	
	private void cancellation(long pnrNo, long aadharNo, UserLayer userLyr, TicketBookingRunner run) throws WrongEntryException
	{
		List<TicketDetails> passengersList = userLyr.cancellation(pnrNo, aadharNo);
		System.out.println("_______________________________________________________________________");
		
		for(int i = 0; i < passengersList.size(); i++)
		{
			TicketDetails ticketDetails = passengersList.get(i);
			System.out.println("TRAIN NAME : PALLAVAN EXPRESS");
			System.out.println("PNR NO : " + ticketDetails.getPnrNo());
			System.out.println("PASSENGER NAME : " + ticketDetails.getPassengerName());
			System.out.println("GENDER : " + ticketDetails.getGender());
			System.out.println("AGE : " + ticketDetails.getAge());
			System.out.println("SEAT NO : " + ticketDetails.getSeatNo());
			System.out.println("COACH : " + ticketDetails.getCoach());
			System.out.println("FROM : " + ticketDetails.getFromPlace());
			System.out.println("TO : " + ticketDetails.getToPlace());
			System.out.println("STATUS : CONFIRMED");
			System.out.println("_______________________________________________________________________");
		}
		
		boolean condition = true;
		do
		{
			System.out.println("Once Ticket cancelled your reservation will be lost.");
			System.out.println("Press : \n1 - Ok \n2 - Cancel");
			int value = run.getInt();
			
			switch(value)
			{
				case 1:
				{
					userLyr.updateCancellation(pnrNo, passengersList);
					System.out.println("Ticket cancelled successfully,");
					condition = false;
					break;
				}
				case 2:
				{
					condition = false;
					break;
				}
				default :
				{
					System.out.println("Please give valid input.");
					break;
				}
			}
		}while(condition);
		
	}
	
	private void pnrEnquiry(long pnrNo, UserLayer userLyr, TicketBookingRunner run) throws WrongEntryException
	{
		Map<Long,List<TicketDetails>> bookedTickets = userLyr.bookedTickets();
		List<TicketDetails> passengersList = bookedTickets.get(pnrNo);
		System.out.println("_______________________________________________________________________");
		
		for(int i = 0; i < passengersList.size(); i++)
		{
			TicketDetails ticketDetails = passengersList.get(i);
			System.out.println("TRAIN NAME : PALLAVAN EXPRESS");
			System.out.println("PNR NO : " + ticketDetails.getPnrNo());
			System.out.println("PASSENGER NAME : " + ticketDetails.getPassengerName());
			System.out.println("GENDER : " + ticketDetails.getGender());
			System.out.println("AGE : " + ticketDetails.getAge());
			System.out.println("SEAT NO : " + ticketDetails.getSeatNo());
			System.out.println("COACH : " + ticketDetails.getCoach());
			System.out.println("FROM : " + ticketDetails.getFromPlace());
			System.out.println("TO : " + ticketDetails.getToPlace());
			System.out.println("STATUS : CONFIRMED");
			System.out.println("_______________________________________________________________________");
		}
	}
	
	private void userLayer(UserDetails userDetails, UserLayer userLyr, TicketBookingRunner run) throws WrongEntryException
	{
		boolean condition = true;
		
		do
		{
			System.out.println("Enter the Case Number.");
			int caseNo = run.getInt();
			
			switch(caseNo)
			{
				case 1:														//Reservation...
				{
					System.out.println("Enter No of Passengers.");
					int n = run.getInt();
					List<TicketDetails> passengersList = new ArrayList<>();
					
					for(int i = 0; i < n; i++)
					{
						TicketDetails ticketDetails = new TicketDetails();
						System.out.println("Enter Passenger Name.");
						String passengerName = run.getString();
						
						String gender = null;
						boolean select = true;
						do
						{
							System.out.println("Press : \n1 - Male \n2 - Female");
							int value = run.getInt();
							switch(value)
							{
								case 1:
								{
									gender = "Male";
									select = false;
									break;
								}
								case 2:
								{
									gender = "Female";
									select = false;
									break;
								}
								default :
								{
									System.out.println("Please Enter valid input.");
									break;
								}
							}
						}while(select);
						
						System.out.println("Enter age.");
						int age = run.getInt();
						
//						String seatPreference = null;
//						select = true;
//						do
//						{
//							System.out.println("Press : \n1 - Lower Coach \n2 - Middle Coach \n3 - Upper Coach");
//							int value = run.getInt();
//							switch(value)
//							{
//								case 1:
//								{
//									seatPreference = "Lower";
//									select = false;
//									break;
//								}
//								case 2:
//								{
//									seatPreference = "Middle";
//									select = false;
//									break;
//								}
//								case 3:
//								{
//									seatPreference = "Upper";
//									select = false;
//									break;
//								}
//								default :
//								{
//									System.out.println("Please Enter valid input.");
//									break;
//								}
//							}
//						}while(select);
//						
//						String specialCase = null;
//						select = true;
//						do
//						{
//							System.out.println("Select any one of the below case.");
//							System.out.println("Press : \n1 - Handicapped \n2 - Pregnant Ladies \n3 - Patient \n4 - Normal");
//							int value = run.getInt();
//							switch(value)
//							{
//								case 1:
//								{
//									specialCase = "Handicapped";
//									select = false;
//									break;
//								}
//								case 2:
//								{
//									specialCase = "Pregnant";
//									select = false;
//									break;
//								}
//								case 3:
//								{
//									specialCase = "Patient";
//									select = false;
//									break;
//								}
//								case 4:
//								{
//									specialCase = "Normal";
//									select = false;
//									break;
//								}
//								default :
//								{
//									System.out.println("Please Enter valid input.");
//									break;
//								}
//							}
//						}while(select);
						
						long aadharNo = userDetails.getAadharNo();
						
						ticketDetails.setPassengerName(passengerName);
						ticketDetails.setGender(gender);
						ticketDetails.setAge(age);
						ticketDetails.setBookedByAadharNo(aadharNo);
						
						passengersList.add(ticketDetails);
					}
					run.reservation(passengersList, userLyr, run);
					
					break;
				}
				case 2:														//Cancellation...
				{
					System.out.println("Enter PNR number of your ticket.");
					long pnrNo = run.getLong();
					long aadharNo = userDetails.getAadharNo();
					run.cancellation(pnrNo, aadharNo, userLyr, run);
					
					break;
				}
				case 3:														//PNR Enquiry...
				{
					System.out.println("Enter PNR number to see details.");
					long pnrNo = run.getLong();
					run.pnrEnquiry(pnrNo, userLyr, run);
					
					break;
				}
				case 4:														//Logout...
				{
					System.out.println("Do you want to Logout? \nPress : \n1 - Logout \n2 - Cancel");
					int value = run.getInt();
					switch(value)
					{
						case 1:
						{
							condition = false;
							break;
						}
					}
					break;
				}
				default:
				{
					System.out.println("Please Enter valid case number.");
					break;
				}
			}
			
		}while(condition);
	}
	
	public static void main(String[] args)
	{
		TicketBookingRunner run = new TicketBookingRunner();
		UserLayer userLyr = new UserLayer();
		boolean condition = false;
		
		do
		{
			System.out.println("Enter userID.");
			long userID = run.getLong();
			System.out.println("Enter password.");
			String password = run.getString();
			
			try
			{
				UserDetails userDetails = userLyr.userLogin(userID, password);
				
				if(userDetails != null)
				{
					run.userLayer(userDetails, userLyr, run);
				}
				else
				{
					System.out.println("Something went Wrong.");
				}
				
				System.out.println("Press : \n1 - Continue \n2 - Exit");
				int value = run.getInt();
				
				switch(value)
				{
					case 1:
					{
						condition = true;
						break;
					}
					default:
					{
						condition = false;
						break;
					}
				}
			}
			catch (WrongEntryException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			catch(InputMismatchException ex)
			{
				sc.nextLine();
				System.out.println("Input DatsType Invalid!");
				ex.printStackTrace();
			}
		}while(condition);
	}

}
