import java.util.*;

public class Heap<T> {
	
	private ArrayList<T> array;
	private Comparator<T> comparator;
	public Integer HeapSize;
	private int childNodeLimit;
	
	public Heap(ArrayList<T> initialArray, Comparator<T> comp, int childLimit)
	{
		array = initialArray;
		comparator = comp;
		HeapSize = array.size() - 1;
		childNodeLimit = 5;
		System.out.print("Received Array: ");
		PrintHeap();
		HeapifyArray();
	}
	
	public void PrintHeap()
	{
		for(T x: array)
			System.out.print(" " + x + " ");
		System.out.println();
	}
	
	private void HeapifyArray()
	{
		for(int i = HeapSize / 2; i > -1; i--)
		{
			//System.out.println(i);
			MaxHeapify(i);
		}
	}
	
	private void MaxHeapify(int index)
	{
		//int left = LeftChildIndex(index);
		//int right = RightChildIndex(index);
		int largest = index;
		int[] ChildNodes = ChildrenNodes(index);
		for(int x : ChildNodes)
		{
			if ( x <= HeapSize && (comparator.compare(array.get(x), array.get(largest)) > 0))
			{
				largest = x;
			}
		}
		
		/* 
		if (left <= HeapSize && (comparator.compare(array.get(left), array.get(largest)) > 0))
		{
			//System.out.println(" largest " + largest + " index " + index + " left " + left + " right " + right + " heap size " + HeapSize);
			largest = left;
		}
		
		//System.out.println(" largest " + largest + " index " + index + " right " + right + " heap size " + HeapSize);
		if (right <= HeapSize && (comparator.compare(array.get(right), array.get(largest)) > 0))
		{
			largest = right;
		}
		*/
		//System.out.println(" largest " + largest + " index " + index);
		if (largest != index)
		{
			Swap(index, largest);
			MaxHeapify(largest);
		}
	}
	
	public T Maximum()
	{
		return array.get(0);
	}
	
	public T ExtractMax() throws Exception
	{
		if (HeapSize < 0)
			throw new Exception("Heap underflow");
		T max = array.get(0);
		array.set(0, array.get(HeapSize));
		HeapSize--;
		MaxHeapify(0);
		return max;
	}
	
	public void IncreaseKey(T key) throws Exception
	{
		int i = HeapSize;
		
		if( comparator.compare(key, array.get(i)) < 0)
		{
			throw new Exception("New key is smaller than current key");
		}
		
		array.set(i, key);
		
		while ( i >= 0 && comparator.compare(array.get(ParentIndex(i)), array.get(i)) < 0)
		{
			Swap(i, ParentIndex(i));
			i = ParentIndex(i);
		}
	}
	
	public void Insert(T key) throws Exception
	{
		HeapSize++;
		array.add(null);
		IncreaseKey(key);
	}
	
	private void Swap(int to, int from)
	{
		T temp = array.get(to);
		array.set(to, array.get(from));
		array.set(from, temp);
	}
	
	private int ParentIndex(int nodeIndex)
	{
		return (nodeIndex + childNodeLimit - 3) / childNodeLimit;
	}
	
	private int[] ChildrenNodes(int nodeIndex)
	{
		int[] temp = new int[childNodeLimit];
		for (int i = 0; i < childNodeLimit; i++)
		{
			temp[i] = (childNodeLimit * nodeIndex) + 1 + i;
		}
		return temp;
	}
	
	private int RightChildIndex(int nodeIndex)
	{
		return 2 * nodeIndex + 2;
	}

	private int LeftChildIndex(int nodeIndex)
	{
		return 2 * nodeIndex + 1;
	}
}