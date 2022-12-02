package practice;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle
{
	public static List<Integer> getRow(int rowIndex)
    {
        List<Integer> currentRow = new ArrayList<Integer>();
        currentRow.add(1);
 
        if (rowIndex == 0)
        {
            return currentRow;
        }
        List<Integer> prev = getRow(rowIndex - 1);
 
        for (int i = 1; i < prev.size(); i++)
        {
            int curr = prev.get(i - 1) + prev.get(i);
            currentRow.add(curr);
        }
        currentRow.add(1);
 
        return currentRow;
    }
 
    public static void main(String[] args)
    {
        int n = 3;
        List<Integer> arr = getRow(n);
        
        for (int i = 0; i < arr.size(); i++)
        {
            if (i == arr.size() - 1)
                System.out.print(arr.get(i));
            else
                System.out.print(arr.get(i) + ", ");
        }
    }
}
