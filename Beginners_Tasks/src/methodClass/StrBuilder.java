package methodClass;

import exceptions.WrongEntryException;

public class StrBuilder
{
	public void nullCheck(StringBuilder str) throws WrongEntryException
	  {
	    if(str == null)
	    {
	      throw new WrongEntryException("Input String is null.");
	    }
	  }
	public void rangeCheck(int startIndex, int endIndex, int length) throws WrongEntryException
	{
		if(startIndex < 0)
		{
			throw new WrongEntryException("Please enter a positive value.");
		}
		else if(startIndex > length)
		{
			throw new WrongEntryException("Start index value is more than length of the given string.");
		}
		else if(startIndex > endIndex)
		{
			throw new WrongEntryException("Start index value is more than the end index value.");
		}
	}
	public StringBuilder getStringBuilder()
	{
		StringBuilder strBuil = new StringBuilder();
		return strBuil;
	}
		
	public StringBuilder createStringBuilder(String... str)
	{
		StringBuilder strBuil = getStringBuilder();
		int length = str.length;
		for(int i = 0; i<length; i++)
			strBuil = strBuil.append(str[i]);
		return strBuil;
	}
	public int strLength(StringBuilder strBuil) throws WrongEntryException
	{
		nullCheck(strBuil);
		int length = strBuil.length();
		return length;
	}
	public StringBuilder addString(StringBuilder strBuil, String symbol, String... strArray) throws WrongEntryException
	{
		nullCheck(strBuil);
		int length = strArray.length;
		for(int i = 0; i<length; i++)
		{
			strBuil.append(symbol);
			strBuil.append(strArray[i]);
		}
		return strBuil;
	}
	public StringBuilder insertString(StringBuilder strBuil, String insertStr) throws WrongEntryException
	{
		int length = strLength(strBuil);
		String str1 = strBuil.toString();
		String[] strArray = str1.split(" ");
		str1 = String.join(" ", strArray[0], insertStr, strArray[1]);
		strBuil.replace(0, length, str1);
		return strBuil;
	}
	public StringBuilder deleteString(StringBuilder strBuil) throws WrongEntryException
	{
		nullCheck(strBuil);
		int endIndex = strBuil.indexOf(" ");
		strBuil = strBuil.delete(0, endIndex);
		return strBuil;
	}
	public StringBuilder replaceSpaceInString(StringBuilder strBuil, String actualSymbol, String replSymbol) throws WrongEntryException
	{
		nullCheck(strBuil);
		int length = strLength(strBuil);
		for(int i = 0; i<length; i++)
		{
			if(strBuil.charAt(i) == actualSymbol.charAt(0))
			{
				strBuil.replace(i, i+1, replSymbol);
			}
		}
		return strBuil;
	}
	public StringBuilder reverseString(StringBuilder strBuil) throws WrongEntryException
	{
		nullCheck(strBuil);
		return strBuil.reverse();
	}
	public StringBuilder deleteNthCharactersInString(StringBuilder strBuil, int startIndex, int endIndex) throws WrongEntryException
	{
		int length = strLength(strBuil);
		rangeCheck(startIndex, endIndex, length);
		startIndex -= 1;
		strBuil = strBuil.delete(startIndex, endIndex);
		return strBuil;
	}
	public StringBuilder replaceNthCharactersInString(StringBuilder strBuil, String repString, int startIndex, int endIndex) throws WrongEntryException
	{
		int length = strLength(strBuil);
		rangeCheck(startIndex, endIndex, length);
		startIndex -= 1;
		strBuil = strBuil.replace(startIndex, endIndex, repString);
		return strBuil;
	}
	public int findFirstIndexOfSymbol(StringBuilder strBuil, String symbol) throws WrongEntryException
	{
		nullCheck(strBuil);
		int index = strBuil.indexOf(symbol);
		return index;
	}
	public int findLastIndexOfSymbol(StringBuilder strBuil, String symbol) throws WrongEntryException
	{
		nullCheck(strBuil);
		int index = strBuil.lastIndexOf(symbol);
		return index;
	}
}
