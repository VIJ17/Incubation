package logiclayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import datacarier.TicketDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import trainreservationframe.TrainTicketBooking;

public class TicketBookingFiles implements TrainTicketBooking
{

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails userLogin(long userID, String password) throws WrongEntryException
	{
		ObjectInputStream objStream = null;
		try
		{
			FileInputStream fileStream = new FileInputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/UserDetails.txt");
			objStream = new ObjectInputStream(fileStream);
			
			Map<Long,UserDetails> userMap = (Map<Long, UserDetails>) objStream.readObject();
			UserDetails userDetails = userMap.get(userID);
			
			if(userDetails == null)
			{
				throw new WrongEntryException("UserID or Password is Invalid.");
			}
			else
			{
				if(!userDetails.getPassword().equals(password))
				{
					throw new WrongEntryException("UserID or Password is Invalid.");
				}
			}
			
			return userDetails;
		}
		catch (IOException | ClassNotFoundException e)
		{
			throw new WrongEntryException("Error!", e);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> reservation() throws WrongEntryException
	{
		ObjectInputStream objStream = null;
		try
		{
			FileInputStream fileStream = new FileInputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/Available_Seats.txt");
			objStream = new ObjectInputStream(fileStream);
			
			List<Integer> seatsArray = (List<Integer>) objStream.readObject();
			
			if(seatsArray == null)
			{
				throw new WrongEntryException("Something went wrong!");
			}
			
			return seatsArray;
		}
		catch (IOException | ClassNotFoundException e)
		{
			throw new WrongEntryException("Error!", e);
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Long,TicketDetails> waitingList() throws WrongEntryException
	{
		ObjectInputStream objStream = null;
		try
		{
			FileInputStream fileStream = new FileInputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/WaitingList.txt");
			objStream = new ObjectInputStream(fileStream);
			
			Map<Long,TicketDetails> waitingList = (Map<Long,TicketDetails>) objStream.readObject();
			
			if(waitingList == null)
			{
				throw new WrongEntryException("Something went wrong!");
			}
			
			return waitingList;
		}
		catch (IOException | ClassNotFoundException e)
		{
			throw new WrongEntryException("Error!", e);
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Long,List<TicketDetails>> bookedTickets() throws WrongEntryException
	{
		ObjectInputStream objStream = null;
		try
		{
			FileInputStream fileStream = new FileInputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/BookedTickets.txt");
			objStream = new ObjectInputStream(fileStream);
			
			Map<Long,List<TicketDetails>> bookedTickets = (Map<Long,List<TicketDetails>>) objStream.readObject();
			
			if(bookedTickets == null)
			{
				throw new WrongEntryException("Something went wrong!");
			}
			
			return bookedTickets;
		}
		catch (IOException | ClassNotFoundException e)
		{
			throw new WrongEntryException("Error!", e);
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
	
	@Override
	public List<TicketDetails> cancellation(long pnrNo, long aadharNo) throws WrongEntryException
	{
		Map<Long,List<TicketDetails>> bookedTickets = bookedTickets();
		List<TicketDetails> passengersList = bookedTickets.get(pnrNo);
		long bookedByAadharNo = passengersList.get(0).getBookedByAadharNo();
		
		if(bookedByAadharNo != aadharNo)
		{
			throw new WrongEntryException("You don't have access to this PNR number");
		}
		
		return passengersList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateCancellation(long pnrNo, List<TicketDetails> passengersList) throws WrongEntryException
	{
		ObjectInputStream objInStream = null;
		ObjectOutputStream objOutStream = null;
		
		try
		{
			FileInputStream fileInStream = new FileInputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/BookedTickets.txt");
			objInStream = new ObjectInputStream(fileInStream);
			
			Map<Long,List<TicketDetails>> bookedTickets = (Map<Long,List<TicketDetails>>) objInStream.readObject();
			
			if(bookedTickets == null)
			{
				throw new WrongEntryException("Something went wrong!");
			}
			
			bookedTickets.remove(pnrNo, bookedTickets);
			
			FileOutputStream fileOutStream = new FileOutputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/BookedTickets.txt");
			objOutStream = new ObjectOutputStream(fileOutStream);
			
			objOutStream.writeObject(bookedTickets);
		}
		catch (IOException | ClassNotFoundException e)
		{
			throw new WrongEntryException("Error!", e);
		}
		finally
		{
			try
			{
				objInStream.close();
			}
			catch(Exception e) {}
			try
			{
				objOutStream.close();
			}
			catch(Exception e) {}
		}
	}

}
