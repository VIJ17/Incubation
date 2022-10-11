package beginnersTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.WrongEntryException;

public class RegularExpressions
{
	ArrayLists list = new ArrayLists();
	Strings word = new Strings();
	
	public boolean validateMobileNumber(String mobileNumber) throws WrongEntryException
	{
		word.nullCheck(mobileNumber);
		
		String pattern = "^[789]{1}[0-9]{9}$";				//	^[789]{1}//d{9}$
		boolean matcher = Pattern.matches(pattern, mobileNumber);
		return matcher;
	}
	
	public boolean validateString(String str) throws WrongEntryException
	{
		word.nullCheck(str);
		
		String pattern = "^[a-zA-Z0-9]+$";
		boolean matcher = Pattern.matches(pattern, str);
		return matcher;
	}
	
	public boolean validateEmail(String str) throws WrongEntryException
	{
		word.nullCheck(str);
		
		String pattern = "^[a-zA-Z0-9._-]+[@][a-zA-Z0-9-]+[.][a-zA-Z.]{2,18}$";		//"^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$"
		boolean matcher = Pattern.matches(pattern, str);
		return matcher;
	}
	
	public List<Boolean> checkStringswithRange(List<String> stringArray, int minRange, int maxRange) throws WrongEntryException
	{
		list.nullCheck(stringArray);
		
		List<Boolean> resultArray = new ArrayList<Boolean>();
		String pattern = "^[a-zA-z]{"+minRange+","+maxRange+"}$";
		for(String str : stringArray)
		{
			boolean result = Pattern.matches(pattern, str);
			resultArray.add(result);
		}
		return resultArray;
	}
	
	public boolean checkStartStrings(String matchingStr, String str) throws WrongEntryException
	{
		word.nullCheck(matchingStr);
		word.nullCheck(str);
		
		Pattern pattern = Pattern.compile(matchingStr);
		Matcher matcher = pattern.matcher(str);
		return matcher.lookingAt();
	}
	
	public boolean checkEndString(String matchingStr, String str) throws WrongEntryException
	{
		word.nullCheck(str);
		
		String pattern = "^.*"+matchingStr+"$";
		boolean matcher = Pattern.matches(pattern, str);
		return matcher;
	}
	
	public boolean checkContainsStrings(String matchingStr, String str) throws WrongEntryException
	{
		word.nullCheck(matchingStr);
		word.nullCheck(str);
		
		Pattern pattern = Pattern.compile(matchingStr);
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	public boolean checkEntireString(String matchingStr, String str) throws WrongEntryException
	{
		word.nullCheck(matchingStr);
		word.nullCheck(str);
		
		Pattern pattern = Pattern.compile(matchingStr);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public List<Boolean> checkWithOutCaseSensitive(String matchingStr, List<String> stringArray) throws WrongEntryException
	{
		word.nullCheck(matchingStr);
		list.nullCheck(stringArray);
		
		List<Boolean> resultArray = new ArrayList<Boolean>();
		for(String str : stringArray)
		{
			Pattern pattern = Pattern.compile(matchingStr, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(str);
			boolean result = matcher.matches();
			resultArray.add(result);
		}
		return resultArray;
	}
	
	public <T> int getLength(List<T> stringArray) throws WrongEntryException
	{
		list.nullCheck(stringArray);
		
		int length = stringArray.size();
		return length;
	}
	
	public Map<String,Integer> createMapDetails(List<String> matchingStrings, List<String> givenStrings) throws WrongEntryException
	{
		int n = getLength(matchingStrings);
		int m = getLength(givenStrings);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		List<Integer> valuesArray = new ArrayList<Integer>();
		String matchingStr;
		String str;
		
		for(int i = 0; i<n; i++)
		{
			matchingStr = matchingStrings.get(i);
			
			for(int j = 0; j<m; j++)
			{
				str = givenStrings.get(j);
				boolean result = checkEntireString(matchingStr, str);
				if(result)
				{
					valuesArray.add(j);
					break;
				}
			}
		}
		
		for(int i = 0; i<n; i++)
		{
			map.put(matchingStrings.get(i), valuesArray.get(i));
		}
		return map;
	}
	
	public List<String> getHTMLTags(String htmlString) throws WrongEntryException
	{
		word.nullCheck(htmlString);
		
		String patternStr = "</?[a-z]*>";					//"(</?[a-z]*>)"
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(htmlString);
		List<String> resultList = new ArrayList<String>();
		
		while(matcher.find())
		{
			resultList.add(matcher.group());
		}
		
		return resultList;
	}
}
