import java.util.Comparator;


public class IntComparable implements Comparator<Integer> {

	public int compare(Integer o1, Integer o2) {
		if (o1 == null || o2 == null)
			return 0;
		return o1.compareTo(o2);
	}
}
