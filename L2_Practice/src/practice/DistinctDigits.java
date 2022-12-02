package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistinctDigits
{
	public static void main(String[] args)
	{
		int[] nums = {131, 11, 2, 48};
		
		int[] answer = common_digits(nums);
		
		for(int i = 0; i < answer.length; i++)
        {
			System.out.println(answer[i]);
        }
	}
	
	public static int[] common_digits(int[] nums)
    {
        int length = nums.length;
        List<Integer> distinctDigits = new ArrayList<>();
        
        
        for(int i = 0; i < length; i++)
        {
            StringBuilder strBuil = new StringBuilder();
            strBuil.append(nums[i]);
            
            for(int k = 0; k < strBuil.length(); k++)
            {
                int digit = Integer.parseInt(String.valueOf(strBuil.charAt(k)));
                
                if(!distinctDigits.contains(digit))
                {
                    distinctDigits.add(digit);
                }
            }
        }
        
        Collections.sort(distinctDigits);
        int[] answer = new int[distinctDigits.size()];
        
        for(int i = 0; i < distinctDigits.size(); i++)
        {
            answer[i] = distinctDigits.get(i);
        }
        
        return answer;
    }
}
