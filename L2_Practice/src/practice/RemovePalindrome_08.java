package practice;

public class RemovePalindrome_08
{
	public static void main(String[] args)
	{
		char[] charArray = {'N', 'a', 'i', 'r', ' ', 's', 'p', 'e', 'a', 'k', 's', ' ', 'm', 'a', 'l', 'a', 'y', 'a', 'l', 'a', 'm'};
		removePalindromeWords(charArray);
	}
	
	public static void removePalindromeWords(char[] charArray)
	{
		int length = charArray.length;
		String str = "";
		
		for(int i = 0; i < length; i++)
		{
			char ch = charArray[i];
			
			if(ch != ' ')
			{
				str += ch;
				
				if(i+1 == length)
				{
					String reverse = "";
					
					for(int j = (str.length()-1); j > -1; j--)
					{
						reverse += str.charAt(j);
					}
					
					if(str.equals(reverse))
					{
						for(int k = (i-(str.length()-1)); k <= i; k++)
						{
							charArray[k] = ' ';
						}
					}
				}
			}
			else
			{
				String reverse = "";
				
				for(int j = (str.length()-1); j > -1; j--)
				{
					reverse += str.charAt(j);
				}
				
				if(str.equals(reverse))
				{
					for(int k = (i-str.length()); k < i; k++)
					{
						charArray[k] = ' ';
					}
				}
				str = "";
			}
		}
		
		int index = 0;
		
		for(int i = 0; i < length; i++)
		{
			char ch = charArray[i];
			
			if(i != 0 && charArray[i-1] != ' ' && ch == ' ')
			{
				index++;
			}
			else if(ch != ' ')
			{
				if(i != index)
				{
					charArray[index] = ch;
					charArray[i] = ' ';
				}
				
				index++;
			}
		}
		
		System.out.println(charArray);
	}

}
