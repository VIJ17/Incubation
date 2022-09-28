package exceptions;

public class WrongEntryException extends Exception
{
	private static final long serialVersionUID = 8534828620117145737L;

	public WrongEntryException(String str)
	{
		super(str);
	}
}
