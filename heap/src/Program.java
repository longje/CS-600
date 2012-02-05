import java.util.ArrayList;
import java.util.Comparator;


public class Program {

	private final static int NODELIMIT = 3;
	
	public static void main(String[] args) {
		
		Comparator<Integer> comp = new IntComparable();	
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 1; i < 11; i++)
		{
			array.add(i);
		}
		
		Heap<Integer> heap = new Heap<Integer>(array, comp, NODELIMIT);
		System.out.print("Max Heap Array: ");
		heap.PrintHeap();
		
		System.out.print("Sorted Array: ");
		heap.HeapSort();
		heap.PrintHeap();
		
		heap.HeapifyArray();
		
		try {
			heap.Insert(34);  //Test queue insertion
			//Extract max values from queue
			for(int i = heap.HeapSize; i > -1; i--)
			{
				Integer max = (Integer)heap.ExtractMax();
				System.out.println("Max: " + max);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		

	}
}
