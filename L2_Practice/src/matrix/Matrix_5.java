package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matrix_5
{
	public static void main(String[] args)
	{
		int[][] arr = { {0, 1, 1, 1},
						{0, 0, 1, 1},
						{1, 1, 1, 1},
						{0, 0, 0, 0} };
		
		firstRowWithMaxOnes(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("\n");
			for(int j = 0; j < arr.length; j++)
			{
				System.out.print(arr[i][j]);
			}
		}
	}
	
	public static void firstRowWithMaxOnes(int[][] arr)
	{
		int n1 = arr.length;			//no of rows...
		int n2 = arr[0].length;			//no of columns...
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n1; i++)
		{
			int count = 0;
			
			for(int j = 0; j < n2; j++)
			{
				int temp = arr[i][j];
				
				if(temp <2)
				{
					if(temp == 1)
					{
						count++;
					}
				}
				else
				{
					break;
				}
			}
			
			list.add(count);
		}
		
		int maxCount = Collections.max(list);
		int index = list.indexOf(maxCount);
		
		for(int i = 0; i < n2; i++)
		{
			arr[index][i] = 0;
		}
	}

}
