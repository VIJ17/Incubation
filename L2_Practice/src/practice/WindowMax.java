package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WindowMax
{
	public static void main(String[] args)
	{
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		System.out.println(maxSlidingWindow(nums, k));
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k)
    {
        int length = nums.length;
        int[] max = new int[length-k+1];
        List<Integer> windowList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int index = 0;

        while(i <= ((length-k+1)*k))
        {
            if(windowList.size() == k)
            {
                max[j] = Collections.max(windowList);
                windowList.clear();
                index = index-k+1;
                j++;
            }
            if(i < ((length-k+1)*k))
            {
                windowList.add(nums[index]);
                index++;
            }
            i++;
        }

        return max;
    }

}
