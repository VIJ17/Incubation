package trainreservationframe;

import java.util.List;
import java.util.Map;

import datacarier.TicketDetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;

public interface TrainTicketBooking
{
	UserDetails userLogin(long userID, String password) throws WrongEntryException;
	
	List<Integer> reservation() throws WrongEntryException;
	
	Map<Long,TicketDetails> waitingList() throws WrongEntryException;
	
	Map<Long,List<TicketDetails>> bookedTickets() throws WrongEntryException;
	
	List<TicketDetails> cancellation(long pnrNo, long aadharNo) throws WrongEntryException;
	
	void updateCancellation(long pnrNo, List<TicketDetails> passengersList) throws WrongEntryException;
}
