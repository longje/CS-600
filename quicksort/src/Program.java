import java.util.Comparator;

public class Program {

	final static int SIZE = 5;
	
	public static void main(String[] args) {
		Integer[] array = new Integer[SIZE + 1];
		
		for(int i = SIZE; i > -1; i--)
		{
			int index = SIZE - i;
			array[index] = i + 1; 
		}
		
		Comparator<Integer> comp = new IntComparable();	
		QuickSort<Integer> quick = new QuickSort<Integer>(array, comp);
		
		System.out.print("Initial Array: ");
		quick.PrintArray();
		
		
		quick.QuickSortArray(0, SIZE);
		System.out.print("Sorted Array: ");
		quick.PrintArray();
	}
}


