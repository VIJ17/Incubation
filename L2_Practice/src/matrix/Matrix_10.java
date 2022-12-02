package matrix;

public class Matrix_10
{
	public static void main(String[] args)
	{
		int[][] mat = {{1, 2, 1, 2}, 
						{2, 1, 2, 1}};
		isSuperSimilar(2, 4, mat, 1);
		
		for(int i = 0; i < mat.length; i++)
		{
			if(i != 0)
			{
				System.out.println("\n");
			}
			for(int j = 0; j < mat[0].length; j++)
			{
				System.out.print(mat[i][j] + " ");
			}
		}
	}
	
	public static void isSuperSimilar(int n, int m, int mat[][], int x)
    {
        for(int i = 0; i < n; i = i + 2)
        {
            int[] temp = new int[x];
            
            for(int k = 0; k < x; k++)
            {
                temp[k] = mat[i][k];
            }
            
            for(int k = 0, l = x; k < x; k++, l++)
            {
                mat[i][k] = mat[i][l];
            }
            
            for(int k = m-x, j = 0; k < m; k++, j++)
            {
                mat[i][k] = temp[j];
            }
        }
        
        for(int i = 1; i < n; i = i + 2)
        {
            int[] temp = new int[x];
            
            for(int k = m-1, j = 0; k >= m-x; k--, j++)
            {
                temp[j] = mat[i][k];
            }
            
            for(int k = m-x, l = 0; k < m; k++, l++)
            {
                mat[i][k] = mat[i][l];
            }
            
            for(int k = 0; k < x; k++)
            {
                mat[i][k] = temp[k];
            }
        }
    }

}
