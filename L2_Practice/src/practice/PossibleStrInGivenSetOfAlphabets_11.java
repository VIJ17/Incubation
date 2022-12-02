package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PossibleStrInGivenSetOfAlphabets_11
{
	private static List<String> permutationList1 = new ArrayList<>();
	private static List<String> permutationList2 = new ArrayList<>();
	
	public static void main(String[] args)
	{
		char[] setOfAlphabets = {'a', 'b', 'c'};
		find_permutation(setOfAlphabets);
	}
	
	private static String swapString(String a, int i, int j)
    {
        char[] b =a.toCharArray();
        char ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        
        return String.valueOf(b);
    }
	
	private static void generatePermutation(String str, int start, int len)
    {
		if (start == len-1)
        {
            if(!permutationList1.contains(str))
            {
                permutationList1.add(str);
            }
        }
        else  
        {  
            for (int i = start; i < len; i++)
            {  
                str = swapString(str,start,i);
                
                generatePermutation(str,start+1,len);
                
                str = swapString(str,start,i);
            }  
        }
    }
	
	public static void find_permutation(char[] setOfAlphabets)
	{
		String str = String.valueOf(setOfAlphabets);
		int start = 0;
		int length = str.length();
		
		generatePermutation(str, start, length);
		
		permutationList2.addAll(permutationList1);
		String temp;
		
		for(String str1 : permutationList1)
		{
			temp = "";
			
			for(int i = 0; i < str1.length(); i++)
			{
				temp += String.valueOf(str1.charAt(i));
				
				if(!permutationList2.contains(temp))
				{
					permutationList2.add(temp);
				}
			}
		}
		
		Collections.sort(permutationList2);
		System.out.println(permutationList2);
	}

}
