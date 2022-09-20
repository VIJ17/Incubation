package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.WrongEntryException;
import methodClass.StrBuilder;

public class StringBuilderRunner
{
public static Scanner sc = new Scanner(System.in);
	
	public String getString()
	{
		System.out.println("Enter a string...");
		String str = sc.nextLine();
		return str;
	}
	public String getReplacementString()
	{
		System.out.println("Enter the replacement string...");
		String str = sc.nextLine();
		return str;
	}
	public int getIndex()
	{
		int index = sc.nextInt();
		return index;
	}
	public String get2StringWithSpace()
	{
		System.out.println("Enter two strings with space inbetween...");
		String str = sc.nextLine();
		return str;
	}
	public String get3StringWithSpace()
	{
		System.out.println("Enter three strings with space inbetween...");
		String str = sc.nextLine();
		return str;
	}
	public String get3StringWithHashtag()
	{
		System.out.println("Enter three strings with hashtag inbetween...");
		String str = sc.nextLine();
		return str;
	}
	public String getSymbol()
	{
		System.out.println("Enter the symbol...");
		String symbol = sc.nextLine();
		return symbol;
	}
	public String getStringWithMinimum10Char()
	{
		System.out.println("Enter a string with minimum 10 characters...");
		String str = sc.nextLine();
		return str;
	}
	public static void main(String args[])
    {
try
{
		StringBuilderRunner test = new StringBuilderRunner();
		StrBuilder build = new StrBuilder();
	    String str = new String();
	    System.out.println("Enter a case number to execute...");
	    int c = sc.nextInt();
	    sc.nextLine();
	    switch(c)
	    {
	    	case 1:
	    	{
	    	    StringBuilder strBuil = build.getStringBuilder();
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		str = test.getString();
	    		strBuil = build.createStringBuilder(str);
	    		length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		break;
	    	}
	    	case 2:
	    	{
	    		str = test.getString();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		sc.nextLine();
	    		System.out.println("Enter the line of strings to be added...");
	    		str = sc.nextLine();
	    		String[] strArray = str.split(" ");
	    		String symbol = test.getSymbol();
	    		strBuil = build.addString(strBuil, symbol, strArray);
	    		length = build.strLength(strBuil);
	    		System.out.println("Given strings are added as required : "+strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		break;
	    	}
	    	case 3:
	    	{
	    		str = test.get2StringWithSpace();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		str = test.getReplacementString();
	    		strBuil = build.insertString(strBuil, str);
	    		System.out.println("Final string is : "+strBuil);
	    		System.out.println("Length of the final string is :"+build.strLength(strBuil));
	    		break;
	    	}
	    	case 4:
	    	{
	    		str = test.get2StringWithSpace();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		strBuil = build.deleteString(strBuil);
	    		length = build.strLength(strBuil);
	    		System.out.println("After deleting the first string : "+strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		break;
	    	}
	    	case 5:
	    	{
	    		str = test.get3StringWithSpace();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		String actualSymbol = test.getSymbol();
	    		String replSymbol = test.getSymbol();
	    		strBuil = build.replaceSpaceInString(strBuil, actualSymbol, replSymbol);
	    		length = build.strLength(strBuil);
	    		System.out.println("After replacing '"+actualSymbol+"'with '"+replSymbol+"' : "+strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		break;
	    	}
	    	case 6:
	    	{
	    		str= test.get3StringWithSpace();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		strBuil = build.reverseString(strBuil);
	    		length = build.strLength(strBuil);
	    		System.out.println("After reversing the string : "+strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		break;
	    	}
	    	case 7:
	    	{
	    		str = test.getStringWithMinimum10Char();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		System.out.println("Enter start index of the string to delete...");
	    		int startIndex = test.getIndex();
	    		System.out.println("Enter end index of the string to delete...");
	    		int endIndex = test.getIndex();
	    		strBuil = build.deleteNthCharactersInString(strBuil, startIndex, endIndex);
	    		length = build.strLength(strBuil);
	    		System.out.println("After deleting specified substring from the string : "+strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		break;
	    	}
	    	case 8:
	    	{
	    		str = test.getStringWithMinimum10Char();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		String repString = test.getReplacementString();
	    		System.out.println("Enter start index of the string to replace...");
	    		int startIndex = test.getIndex();
	    		System.out.println("Enter end index of the string to replace...");
	    		int endIndex = test.getIndex();
	    		strBuil = build.replaceNthCharactersInString(strBuil, repString, startIndex, endIndex);
	    		length = build.strLength(strBuil);
	    		System.out.println("After reversing the string : "+strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		break;
	    	}
	    	case 9:
	    	{
	    		str = test.get3StringWithHashtag();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		String symbol = test.getSymbol();
	    		int index = build.findFirstIndexOfSymbol(strBuil, symbol);
	    		System.out.println("Index of first "+symbol+" in the string is : "+(index+1));
	    	}
	    	case 10:
	    	{
	    		str = test.get3StringWithHashtag();
	    		StringBuilder strBuil = build.createStringBuilder(str);
	    		int length = build.strLength(strBuil);
	    		System.out.println("Length of the string is : "+length);
	    		String symbol = test.getSymbol();
	    		int index = build.findLastIndexOfSymbol(strBuil, symbol);
	    		System.out.println("Index of last "+symbol+" in the string is : "+(index+1));
	    		break;
	    	}
	    	default:
	    	{
	    		System.out.println("XXX...Invalid case number...XXX");
	    	}
	    }
      }
      catch(WrongEntryException ex)
      {
    	  System.out.println(ex.getMessage());
      }
	  catch(InputMismatchException e)
	  {
		  System.out.println("Data type mismatch...");
	  }
  	
    }
}
