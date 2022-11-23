package beginnersTask;

import exceptions.WrongEntryException;

public class Strings
{
	public void nullCheck(String str) throws WrongEntryException
	  {
	    if(str == null)
	    {
	      throw new WrongEntryException("Input String is null.");
	    }
	  }
	public void rangeCheck(int length, int n) throws WrongEntryException
	  {
	    if(n < 0)
	    {
	      throw new WrongEntryException("Please enter a positive value.");
	    }
	    else if(n > length)
	    {
	      throw new WrongEntryException("Entered value is more than length of the given string.");
	    }
	  }
	public void stringCheck(int length, int repLength) throws WrongEntryException
	  {
	    if(length < repLength)
	    {
	      throw new WrongEntryException("Length of replacement string is more than the actual string.");
	    }
	  }
	public int strLength(String str) throws WrongEntryException
	  {
	    nullCheck(str);
	    int len = str.length();
	    return len;
	  }
	public char[] convToCharArray(String str) throws WrongEntryException
	  {
	    char[] arr = new char[strLength(str)];
	    arr = str.toCharArray();
	    return arr;
	  }
	public char findLastCharacter(String str) throws WrongEntryException
	  {
	    nullCheck(str);
	    int fnlIndex = str.length()-1;
	    return str.charAt(fnlIndex);
	  }
	public char findCharacter(String str,int n) throws WrongEntryException
	  {
	    int length = strLength(str);
	    rangeCheck(length, n);
	    nullCheck(str);
	    return str.charAt(n); 
	  }
	public int counting(String str, char ch) throws WrongEntryException
	  {
	    nullCheck(str);
	    int count = 0, length = str.length();
	    for(int i=0; i<length; i++)
	    {
	      if(findCharacter(str,i) == ch)
	      {
	        count++;
	      }
	    }
	    return count;
	  }
	public int greatestPosition(String str, char ch) throws WrongEntryException
	  {
	    int index = 0;
	    nullCheck(str);
	    index = str.lastIndexOf(ch);
	    return index;
	  }
	public String lastNCharacters(String str, int n) throws WrongEntryException
	  {
	    int length = strLength(str);
	    rangeCheck(length, n);
	    int startIndex = length - n;
	    return str.substring(startIndex);
	  }
	public String firstNCharacters(String str, int n) throws WrongEntryException
	  {
	    int length = strLength(str);
	    rangeCheck(length, n);
	    int startIndex = 0;
	    return str.substring(startIndex, n);
	  }
	public String replaceString(String str, String replaceStr) throws WrongEntryException
	  {
	    int length = strLength(str);
	    int repLength = strLength(replaceStr);
	    stringCheck(length, repLength);
	    String str1 = firstNCharacters(str, repLength);
	    return str.replace(str1, replaceStr);
	  }
	public boolean strStartsWith(String str, String prefix) throws WrongEntryException
	  {
	    nullCheck(str);
	    return str.startsWith(prefix);
	  }
	public boolean strEndsWith(String str, String suffix) throws WrongEntryException
	  {
	    nullCheck(str);
	    return str.endsWith(suffix);
	  }
	public String convToUpperCase(String str) throws WrongEntryException
	  {
	    nullCheck(str);
	    return str.toUpperCase();
	  }
	public String convToLowerCase(String str) throws WrongEntryException
	  {
	    nullCheck(str);
	    return str.toLowerCase();
	  }
	public String reverseString(String str) throws WrongEntryException
	  {
	    String reverse = "";
	    int length = strLength(str);
	    for(int i=length-1; i>=0; i--)
	      reverse += str.charAt(i);
	    return reverse;
	  }
	public String concatenateStrings(String str) throws WrongEntryException
	  {
	    nullCheck(str);
	    String target = " ";
	    String replacement = "";
	    return str.replace(target, replacement);
	  }
	public String[] stringToStringArray(String str) throws WrongEntryException
	  {
	    nullCheck(str);
	    String[] strArray = str.split(" ");
	    return strArray;
	  }
	public String mergeStrings(String[] strArray) throws WrongEntryException
	  {
	    String str = "";
	    int length = strArray.length;
	    for(int i = 0; i<length; i++)
	    {
	      str += strArray[i];
	      str += "-";
	    }  
	    int endIndex = strLength(str)-1;
	    return str.substring(0,endIndex);
	  }
	public boolean compareStringsCaseSensitive(String str, String str1) throws WrongEntryException
	  {
	    nullCheck(str);
	    return str.equals(str1);
	  }
	public boolean compareStringsWithoutCaseSensitive(String str, String str1) throws WrongEntryException
	  {
	    nullCheck(str);
	    return str.equalsIgnoreCase(str1);
	  }
	public String removeSpace(String str) throws WrongEntryException
	  {
	    nullCheck(str);
	    return str.trim();
	  }
}
