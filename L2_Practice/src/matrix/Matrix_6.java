package matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix_6
{
	public static void main(String[] args)
	{
		int[][] arr = {{0, 1}};
		
		setZeroes(arr);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("\n");
			for(int j = 0; j < arr.length; j++)
			{
				System.out.print(arr[i][j]);
			}
		}
	}
	
	public static void setZeroes(int[][] matrix)
    {
        int n1 = matrix.length;
        int n2 = matrix[0].length;
        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> columnIndex = new ArrayList<>();
        
        for(int i = 0; i < n1; i++)
        {
            for(int j = 0; j < n2; j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(!rowIndex.contains(i))
                    {
                        rowIndex.add(i);
                    }
                    if(!columnIndex.contains(j))
                    {
                        columnIndex.add(j);
                    }
                }
            }
        }
        
        for(int i = 0; i < rowIndex.size(); i++)
        {
            int k = rowIndex.get(i);
            
            for(int j = 0; j < n2; j++)
            {
                matrix[k][j] = 0;
            }
        }
        
        for(int i = 0; i < columnIndex.size(); i++)
        {
            int k = columnIndex.get(i);
            
            for(int j = 0; j < n1; j++)
            {
                matrix[j][k] = 0;
            }
        }
        
    }

}
