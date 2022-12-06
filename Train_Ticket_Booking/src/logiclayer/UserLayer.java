package logiclayer;

import java.util.List;
import java.util.Map;

import datacarier.TicketDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public class UserLayer
{
	TicketBookingFiles tickBook = new TicketBookingFiles();
	
	public UserDetails userLogin(long userID, String password) throws WrongEntryException
	{
		UserDetails userDetails = tickBook.userLogin(userID, password);
		
		return userDetails;
	}

	public List<Integer> reservation() throws WrongEntryException
	{
		List<Integer> seatsArray = tickBook.reservation();
		
		return seatsArray;
	}
	
	public Map<Long,TicketDetails> waitingList() throws WrongEntryException
	{
		Map<Long,TicketDetails> waitingList = tickBook.waitingList();
		
		return waitingList;
	}
	
	public Map<Long,List<TicketDetails>> bookedTickets() throws WrongEntryException
	{
		Map<Long,List<TicketDetails>> bookedTickets = tickBook.bookedTickets();
		
		return bookedTickets;
	}
	
	public List<TicketDetails> cancellation(long pnrNo, long aadharNo) throws WrongEntryException
	{
		List<TicketDetails> passengersList = tickBook.cancellation(pnrNo, aadharNo);
		
		return passengersList;
	}

	public void updateCancellation(long pnrNo, List<TicketDetails> passengersList) throws WrongEntryException
	{
		tickBook.updateCancellation(pnrNo, passengersList);
	}

}
