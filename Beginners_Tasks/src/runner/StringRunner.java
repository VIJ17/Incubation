package runner;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import beginnersTask.Strings;
import exceptions.WrongEntryException;

public class StringRunner
{
	Scanner sc = new Scanner(System.in);
	  public String getString()
	  {
	    System.out.println("Please enter a string...");
	    String str = sc.nextLine();
	    return str;
	  }
	  public String getLine()
	  {
	    System.out.println("Enter a line with multiple strings...");
	    String str = sc.nextLine();
	    return str;
	  }
	  public static void main(String[] args) throws WrongEntryException
	  {
	    StringRunner test = new StringRunner();
	    Strings word = new Strings();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the case to execute...");
	    int choice = sc.nextInt();
	    sc.nextLine();
	try
	{
	    switch(choice)
	    {
	      case 1:
	      {
	        int len = args.length;
	        if(len == 0)
	        {
	          String str = test.getString();
	          int l = word.strLength(str);
	          System.out.println("Length of the string is " +l);
	        }
	        else
	        {
	          String str = args[0];
	          int l = word.strLength(str);
	          System.out.println("Length of the string is " +l);
	        }
	        break;
	      }
	      case 2:
	      {
	        String str = test.getString();
	        char[] arr = new char[str.length()];
	        arr = word.convToCharArray(str);
	        System.out.println(Arrays.toString(arr));
	        break;
	      }
	      case 3:
	      {
	        String str = test.getString();
	        System.out.println("Enter 1 to find last character of the string\n(or)\nEnter 2 to find nth character of the string");
	        int caseVariable;
	        do{
	        caseVariable = sc.nextInt();
	        switch(caseVariable)
	        {
	          case 1:
	          {
	            char ch = word.findLastCharacter(str);
	            System.out.println("Last character of the string is '"+ch+"'");
	            break;
	          }
	          case 2:
	          {
	            int nthElement;
	            System.out.println("Please specify the position of the Element...");
	            nthElement = sc.nextInt();
	            char ch = word.findCharacter(str, nthElement-1);
	            System.out.println("The required character from the string is '"+ch+"'");
	            break;
	          }
	          default:
	          {
	            System.out.println("Please enter a valid input...");
	            break;
	          }
	        }
	          }while(caseVariable!=1 && caseVariable!=2);
	        break;
	      }
	      case 4:
	      {
	         String str = test.getString();
	         System.out.println("Enter a character to know it's count...");
	         char ch = sc.nextLine().charAt(0);
	         int count = word.counting(str, ch);
	         System.out.println("The '"+ch+"' letter exist "+count+" times in the given string.");
	         break;
	      }
	      case 5:
	      {
	        String str = test.getString();
	        System.out.println("Entee the character/letter to find it's greatest position in the string");
	        char ch = sc.nextLine().charAt(0);
	        int greatestIndex = word.greatestPosition(str, ch);
	        if(greatestIndex != -1)
	        {
	          int greatestPosition = greatestIndex + 1;
	          System.out.println("Greatest position of '"+ch+"' is "+greatestPosition);
	        }
	        else 
	        {
	          System.out.println("'"+ch+"' is not found in the given string.");
	        }
	        break;
	      }
	      case 6:
	      {
	        String str = test.getString();
	        System.out.println("Enter the value for last number of characters to print");
	        int n = sc.nextInt();
	        String str1 = word.lastNCharacters(str, n);
	        System.out.println("The last "+n+" characters of a given string is '"+str1+"'");
	        break;
	      }
	      case 7:
	      {
	        String str = test.getString();
	        System.out.println("Enter the value for first number of characters to print");
	        int n = sc.nextInt();
	        String str1 = word.firstNCharacters(str, n);
	        System.out.println("The first "+n+" characters of a given string is '"+str1+"'");
	        break;
	      }
	      case 8:
	      {
	        String str = test.getString();
	        System.out.println("Enter the replacement string...");
	        String str1 = sc.nextLine();
	        String resultString = word.replaceString(str, str1);
	        System.out.println("The modified string is '"+resultString+"'");
	        break;
	      }
	      case 9:
	      {
	        String str = test.getString();
	        System.out.println("Enter a prefix string to check...");
	        String prefix = sc.nextLine();
	        boolean result = word.strStartsWith(str, prefix);
	        System.out.println(result);
	        break;
	      }
	      case 10:
	      {
	        String str = test.getString();
	        System.out.println("Enter a suffix string to check...");
	        String suffix = sc.nextLine();
	        boolean result = word.strEndsWith(str, suffix);
	        System.out.println(result);
	        break;
	      }
	      case 11:
	      {
	        String str = test.getString();
	        str = word.convToUpperCase(str);
	        System.out.println("The string is converted to Uppercase is '"+str+"'");
	        break;
	      }
	      case 12:
	      {
	        String str = test.getString();
	        str = word.convToLowerCase(str);
	        System.out.println("The string is converted to Lowercase is '"+str+"'");
	        break;
	      }
	      case 13:
	      {
	        String str = test.getString();
	        String reverse = word.reverseString(str);
	        System.out.println("Reversed string is '"+reverse+"'");
	        break;
	      }
	      case 14:
	      {
	        String str = test.getLine();
	        System.out.println("A line with multiple strings : "+str);
	        break;
	      }
	      case 15:
	      {
	        String str = test.getLine();
	        System.out.println("Strings in the given line are concatenated as follows : "+word.concatenateStrings(str));
	        break;
	      }
	      case 16:
	      {
	        String str = test.getLine();
	        String[] strArray = word.stringToStringArray(str);
	        System.out.println("Strings of a line is converted into Strings of an Array :\n"+Arrays.toString(strArray));
	        break;
	      }
	      case 17:
	      {
	        System.out.println("Enter the value for no. of strings...");
	        int n = sc.nextInt();
	        sc.nextLine();
	        String[] strArray = new String[n];
	        System.out.println("Enter the strings to merge them...");
	        for(int i = 0; i<n; i++)
	          strArray[i] = sc.nextLine();
	        String str = word.mergeStrings(strArray);
	        System.out.println("The given strings are merged as : "+str);
	        break;
	      }
	      case 18:
	      {
	        String str = test.getString();
	        String str1 = test.getString();
	        boolean result = word.compareStringsCaseSensitive(str, str1);
	        System.out.println(result);
	        break;
	      }
	      case 19:
	      {
	        String str = test.getString();
	        String str1 = test.getString();
	        boolean result = word.compareStringsWithoutCaseSensitive(str, str1);
	        System.out.println(result);
	        break;
	      }
	      case 20:
	      {
	        String str = test.getString();
	        System.out.println("Space at beginning/end is removed from the string : "+word.removeSpace(str));
	        break;
	      }
	      default:
	      {
	        System.out.println("XXX...Invalid case number...XXX");
	        break;
	      }
	    }
	}
	     catch(WrongEntryException ex)
	    {
	    	 System.out.print(ex.getMessage());
	    }
	    catch(InputMismatchException e)
	    {
	    	System.out.println("Data type mismatch...");
	    	e.printStackTrace();
	    }
	    finally
	    {
	      sc.close();
	    }
	  }
}
