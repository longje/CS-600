import java.util.*;

public class program {
	
	public static void main(String[] args) {
		char[] y = new char[]{ 's', 'p', 'a', 'n', 'k', 'i', 'n', 'g' };
		char[] x = new char[]{ 'a', 'm', 'p', 'u', 't', 'a', 't', 'i', 'o', 'n' };
		
		//char[] y = "GCGACAACGACGCACCT".toCharArray();
		//char[] x = "TTATGACGTTATTCTAC".toCharArray();
		
		long startTime = System.currentTimeMillis();
		lcs.lcsLength(y, x);
		long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time for Dynamic Method: " + (endTime - startTime));
		
		
		lcs.printLCS(y.length, x.length);
		System.out.println();
		
		startTime = System.currentTimeMillis();
		System.out.println("Recursive Method: " + lcs.lcsRecursive(x, y, x.length - 1, y.length - 1, ""));
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed time for Recursive Method: " + (endTime - startTime));
		
		String[][] memo = new String[x.length][y.length];
		
		for(int i = 0; i < memo.length; i++)
			for(int j = 0; j < memo[i].length; j++)
				memo[i][j] = null;
		
		startTime = System.currentTimeMillis();
		System.out.println("Memoize Recursive Method: " + lcs.memoizedLCS(x, y, x.length - 1, y.length - 1, "", memo));
		endTime = System.currentTimeMillis();
		System.out.println("Elapsed time for Memoized Recursive Method: " + (endTime - startTime));
		
    }
}
