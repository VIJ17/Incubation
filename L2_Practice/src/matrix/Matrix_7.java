package matrix;

public class Matrix_7
{
	public static void main(String[] args)
	{
		int[][] arr = { {5, 2, 0, 7, 1 }, { 3, 4, 2, 9, 14 },
		                { 5, 1, 3, 5, 2 }, { 4, 2, 6, 2, 1 },
		                { 0, 6, 3, 5, 1 } };
		
		sortLeftDiagonal(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			if(i != 0)
			{
				System.out.println("\n");
			}
			for(int j = 0; j < arr.length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
		}
	}
	
	public static void sortLeftDiagonal(int[][] arr)
	{
		int n = arr.length;
		int i = 0;
		int j = 0;
		
		while(i < n-1 && j < n-1)
		{
			int minimumRowIndex = i;
			int minimumColumnIndex = j;
			
			for(int l = i+1,m = j+1; l < n && m < n; l++,m++)
			{
				if(arr[l][m] < arr[minimumRowIndex][minimumColumnIndex])
				{
					minimumRowIndex = l;
					minimumColumnIndex = m;
				}
			}
			
			int temp = arr[minimumRowIndex][minimumColumnIndex];
			arr[minimumRowIndex][minimumColumnIndex] = arr[i][j];
			arr[i][j] = temp;
			
			i += 1;
			j += 1;
		}
	}

}
