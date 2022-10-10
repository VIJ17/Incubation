package runner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import beginnersTask.RegularExpressions;
import exceptions.WrongEntryException;

public class RegExRunner
{
	
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	Scanner sc = new Scanner(System.in);

	public int getInteger()
	{
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}
	public String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	public List<String> getStringArray(int n)
	{
		List<String> stringArray = new ArrayList<String>();
		logger.info("Enter the List of strings one by one");
		
		for(int i = 0; i<n; i++)
		{
			stringArray.add(sc.nextLine());
		}
		return stringArray;
	}
	public void printResultList(List<Boolean> resultArray, List<String> stringArray, int n)
	{
		for(int i = 0; i<n; i++)
		{
			logger.info(stringArray.get(i) + " - " + resultArray.get(i));
		}
	}
	
	public static void main(String[] args)
	{
		RegExRunner runner = new RegExRunner();
		RegularExpressions regEx = new RegularExpressions();
		
		try
		{
			logger.info("Enter the case number to execute...");
			int caseValue = runner.getInteger();
			
			switch(caseValue)
			{
				case 1:
				{
					logger.info("Enter the mobile number.");
					String mobileNumber = runner.getString();
					logger.info("THe given mobile number is : " +regEx.validateMobileNumber(mobileNumber));
					break;
				}
				case 2:
				{
					logger.info("Enter the String.");
					String str = runner.getString();
					logger.info("The given String is : " +regEx.validateString(str));
					break;
				}
				case 3:
				{
					logger.info("Enter the matching String.");
					String matchingStr = runner.getString();
					logger.info("Enter the string to be matched.");
					String str = runner.getString();
					logger.info("Enter 's' to check the given string starts with the matching string\nor\n"
							+ "Enter 'e' to check the given string ends with the matching string\nor\n"
							+ "Enter 'c' to check the given string contains the matching string\nor\n"
							+ "Enter 'm' to check the given string is an exact match");
					String c = runner.getString();
					switch(c)
					{
						case "s":
						{
							logger.info("The given string starts with the matching string : "
									+ regEx.checkStartStrings(matchingStr, str));
							break;
						}
						case "e":
						{
							logger.info("The given string ends with the matching string : "
									+ regEx.checkEndString(matchingStr, str));
							break;
						}
						case "c":
						{
							logger.info("The given string contains the matching string : "
											+ regEx.checkContainsStrings(matchingStr, str));
							break;
						}
						case "m":
						{
							logger.info("The given string ecaxtly matches with the matching string : "
									+ regEx.checkEntireString(matchingStr, str));
							break;
						}
						default :
						{
							logger.info("Invalid Input.");
							break;
						}
					}
					break;
				}
				case 4:
				{
					logger.info("Enter the matching String.");
					String matchingStr = runner.getString();
					logger.info("Enter the number of strings to be matched.");
					int n = runner.getInteger();
					List<String> stringArray = runner.getStringArray(n);
					
					List<Boolean> resultArray = regEx.checkWithOutCaseSensitive(matchingStr, stringArray);
					
					runner.printResultList(resultArray, stringArray, n);
					break;
				}
				case 5:
				{
					logger.info("Enter the Email to check.");
					String str = runner.getString();
					logger.info("The given String is : " +regEx.validateEmail(str));
					break;
				}
				case 6:
				{
					logger.info("Enter the minimum string length range.");
					int minRange = runner.getInteger();
					logger.info("Enter the maximum string length range.");
					int maxRange = runner.getInteger();
					logger.info("Enter the number of strings to be matched.");
					int n = runner.getInteger();
					List<String> stringArray = runner.getStringArray(n);
					
					List<Boolean> resultArray = regEx.checkStringswithRange(stringArray, minRange, maxRange);
					
					runner.printResultList(resultArray, stringArray, n);
					break;
				}
				case 7:
				{
					logger.info("Enter the number of matching strings.");
					int n = runner.getInteger();
					List<String> matchingStrings = runner.getStringArray(n);
					logger.info("Enter the number of given strings.");
					n = runner.getInteger();
					List<String> givenStrings = runner.getStringArray(n);
					
					Map<String, Integer> map = regEx.createMapDetails(matchingStrings, givenStrings);
					
					logger.info("Required map : " + map);
					
					break;
				}
				case 8:
				{
					logger.info("Enter a raw HTML string.");
					String htmlString = runner.getString();
					
					List<String> resultList = regEx.getHTMLTags(htmlString);
					
					for(String result : resultList)
					{
						logger.info(result);
					}
					break;
				}
				default:
				{
					logger.info("XXX...Invalid case number...XXX");
					break;
				}
			}
		}
		catch(WrongEntryException e)
		{
			logger.info(e.getMessage());
		}
		catch(InputMismatchException e)
		{
			logger.info("Data type mismatch...");
	    	e.printStackTrace();
		}
	}

}
