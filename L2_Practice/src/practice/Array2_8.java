package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2_8
{
	public static void main(String[] args)
	{
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 5, 3, 8, 9));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 7, 5, 8, 8));
		
		System.out.println(listUnion(list1, list2));
		System.out.println(listExcept(list1, list2));
		System.out.println(listIntersect(list1, list2));
	}
	
	public static List<Integer> listUnion(List<Integer> list1, List<Integer> list2)
	{
		List<Integer> unionList = new ArrayList<>();
		
		for(int i = 0; i < list1.size(); i++)
		{
			if(!unionList.contains(list1.get(i)))
			{
				unionList.add(list1.get(i));
			}
		}
		for(int i = 0; i < list2.size(); i++)
		{
			if(!unionList.contains(list2.get(i)))
			{
				unionList.add(list2.get(i));
			}
		}
		
		return unionList;
	}
	
	public static List<Integer> listExcept(List<Integer> list1, List<Integer> list2)
	{
		List<Integer> exceptList = new ArrayList<>();
		
		for(int i = 0; i < list1.size(); i++)
		{
			if(list1.get(i) % 2 == 0)
			{
				exceptList.add(list1.get(i));
			}
		}
		for(int i = 0; i < list2.size(); i++)
		{
			if(list2.get(i) % 2 == 1)
			{
				exceptList.add(list2.get(i));
			}
		}
		
		return exceptList;
	}
	
	public static List<Integer> listIntersect(List<Integer> list1, List<Integer> list2)
	{
		List<Integer> intersectList = new ArrayList<>();
		
		for(int i = 0; i < list1.size(); i++)
		{
			for(int k = 0; k < list2.size(); k++)
			{
				if(list1.get(i) == list2.get(k))
				{
					intersectList.add(list1.get(i));
					break;
				}
			}
		}
		
		return intersectList;
	}

}
