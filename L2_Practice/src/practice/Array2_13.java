package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2_13
{
	public static void main(String[] args)
	{
		List<List<Integer>> intervals = new ArrayList<>();
		intervals.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
		intervals.add(new ArrayList<Integer>(Arrays.asList(5, 8)));
		intervals.add(new ArrayList<Integer>(Arrays.asList(4, 10)));
		intervals.add(new ArrayList<Integer>(Arrays.asList(20, 25)));
		
		System.out.println(mergeOverLappingIntervals(intervals));
	}
	
	public static List<List<Integer>> mergeOverLappingIntervals(List<List<Integer>> intervals)
	{
		return intervals;
	}

}
