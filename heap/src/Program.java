import java.util.ArrayList;
import java.util.Comparator;


public class Program {

	private final static int NODELIMIT = 3;
	
	public static void main(String[] args) {
		Comparator comp = new IntComparable();
		
		ArrayList<Integer> array = new ArrayList();
		for(int i = 1; i < 11; i++)
		{
			array.add(i);
		}
		
		Heap<Integer> heap = new Heap<Integer>(array, comp, NODELIMIT);
		heap.PrintHeap();
		
		try {
			heap.Insert(34);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		for(int i = heap.HeapSize; i > -1; i--)
		{
			try
			{
				Integer max = (Integer)heap.ExtractMax();
				System.out.println("Max: " + max);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}

	}

}
