import java.util.Comparator;


public class QuickSort<T> {
	
	private T[] array;
	private Comparator<T> comparator;
	
	public QuickSort(T[] initialArray, Comparator<T> initialComparator)
	{
		array = initialArray;
		comparator = initialComparator;
	}
	
	public void QuickSortArray(int p, int r)
	{
		
		if ( p < r )
		{
			System.out.print(" P Value: " + p + " R Value: " + r);
			int q = Partition(p, r);
			System.out.println(" Q Value: " + q);
			PrintArray();
			QuickSortArray(p, q - 1);
			QuickSortArray(q + 1, r);
		}
		else 
		{
			System.out.println("\nSkipping - P Value: " + p + " R Value: " + r);
		}
	}
	
	public void PrintArray()
	{
		for(T x: array)
			System.out.print(" " + x + " ");
		System.out.println();
	}
	
	public int Partition(int p, int r)
	{
		T x = array[r];
		int i = p - 1;
		for (int j = p; j < r; j++)
		{
			if ( comparator.compare(array[j],  x) < 0 )
			{
				i++;
				Swap(i, j);
			}
		}
		Swap(i + 1, r);
		return i + 1;
	}
	
	private void Swap(int to, int from)
	{
		T temp = array[to];
		array[to] = array[from];
		array[from] = temp;
	}

}
