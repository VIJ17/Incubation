import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import datacarier.TicketDetails;

public class Testing
{
	public static void main(String[] args)
	{
//		List<Integer> seatsArray = new ArrayList<>(16);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
//		seatsArray.add(0);
		
		Map<Long,List<TicketDetails>> bookedTickets = new Hashtable<>();
		
		ObjectOutputStream objStream = null;
		
		try
		{
			FileOutputStream fileStream = new FileOutputStream("/home/zoho/eclipse-workspace/Train_Ticket_Booking/BookedTickets.txt");
			objStream = new ObjectOutputStream(fileStream);
			
			objStream.writeObject(bookedTickets);
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

}
