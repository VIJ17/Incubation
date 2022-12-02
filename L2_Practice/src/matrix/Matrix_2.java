package matrix;

public class Matrix_2
{
	public static void main(String[] args)
	{
		int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		rotate(matrix);
		
		for(int i = 0; i < matrix.length; i++)
		{
			System.out.println("\n");
			for(int j = 0; j < matrix.length; j++)
			{
				System.out.print(matrix[i][j]);
			}
		}
	}
	
	public static void rotate(int matrix[][]) 
    {
        int n = matrix.length;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        int j = 0;
        
        while(j < n)
        {
        	int k = n-1;
            int i = 0;
            
            while(i < k)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[k][j];
                matrix[k][j] = temp;
                i++;
                k--;
            }
            
            j++;
        }
    }

}
