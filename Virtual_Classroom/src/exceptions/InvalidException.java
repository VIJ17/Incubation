package exceptions;

public class InvalidException extends Exception
{
	private static final long serialVersionUID = 8534828620117145737L;

	public InvalidException(String str)
	{
		super(str);
	}
	
	public InvalidException(String str, Throwable e)
	{
		super(str, e);
	}
	
	public InvalidException(Throwable e)
	{
		super(e);
	}
	
}
