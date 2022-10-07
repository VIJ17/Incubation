package beginnersTask;

public class UsingEnum
{
	public enum RainbowColors
	{
		VIOLET(1),INDIGO(2),BLUE(3),GREEN(4),YELLOW(5),ORANGE(6),RED(7);
		
		private final int value;
		
		private RainbowColors(int value)				//By default Enum constructors are private...
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}
		
	}
}
