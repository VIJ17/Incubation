package practice;

import java.util.ArrayList;
import java.util.List;

public class MappingOfDigits_07
{
	public static void main(String[] args)
	{
		String str1 = "abcddefgikom";
		String str2 = "abdcdeffgklm";
		System.out.println(missMatchPairs(str1, str2));
	}
	
	public static List<List<String>> missMatchPairs(String str1, String str2)
	{
		int length1 = str1.length();
		int length2 = str2.length();
		List<List<String>> list = new ArrayList<>();
		
		if(length1 != length2)
		{
			return list;
		}
		
		String temp1 = "";
		String temp2 = "";
		
		for(int i = 0; i < length1; i++)
		{
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);
			
			if(ch1 != ch2)
			{
				temp1 += ch1;
				temp2 += ch2;
			}
			else
			{
				if(temp1 != "")
				{
					List<String> innerList = new ArrayList<>();
					innerList.add(temp1);
					innerList.add(temp2);
					list.add(innerList);
					temp1 = "";
					temp2 = "";
					innerList = new ArrayList<>();
				}
			}
		}
		
		return list;
	}
}
