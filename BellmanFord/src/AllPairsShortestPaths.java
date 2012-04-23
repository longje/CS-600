import java.util.ArrayList;


public class AllPairsShortestPaths {
	private static int[][] extendShortestPaths(int[][] L, int[][] W)
	{
		int n = L.length;
		int[][] lPrime = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				lPrime[i][j] = 10000;
				for (int k = 0; k < n; k++)
					if (lPrime[i][j] > L[i][k] + W[k][j])
						lPrime[i][j] =  L[i][k] + W[k][j];
			}
		return lPrime;
	}
	
	public static int[][] slowAllPairsShortestPaths(int[][] W)
	{
		System.out.println("INITIAL MATRIX - L(1)");
		printMatrix(W);
		int n = W.length - 1;
		ArrayList<int[][]> results = new ArrayList<int[][]>();
		int[][] L = W;
		results.add(L);
		for (int m = 1; m < n; m++)
			results.add(extendShortestPaths(results.get(m-1), W));
		
		for (int m = 1; m < results.size(); m++) {
			System.out.println("RESULT FOR L(" + (m+1) + ")");
			printMatrix(results.get(m));
		}
		
		return results.get(n - 1);
	}
	
	public static int[][] fasterAllPairsShortestPaths(int[][] W)
	{
		System.out.println("INITIAL MATRIX - L(1)");
		printMatrix(W);
		int n = W.length - 1;
		ArrayList<int[][]> results = new ArrayList<int[][]>();
		
		int[][] L = W;
		int m = 1;
		int k = 1;
		results.add(L);
		while (m < n)
		{
			results.add(extendShortestPaths(results.get(k-1), results.get(k-1)));
			m = 2 * m;
			System.out.println("RESULT FOR L(" + (m) + ")");
			printMatrix(results.get(k));
			k++;
		}
		
		return results.get(k - 1);
	}
	
	public static int[][] floyedWarshall(int[][] W)
	{
		System.out.println("INITIAL MATRIX - D(0)");
		printMatrix(W);
		
		int n = W.length;
		int[][] D = W;
		ArrayList<int[][]> results = new ArrayList<int[][]>();
		results.add(D);
		for (int k = 1; k <= n; k++)
		{
			int[][] Dk = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					Dk[i][j] = (results.get(k-1)[i][j] > results.get(k-1)[i][k-1] + results.get(k-1)[k-1][j])
								 ? results.get(k-1)[i][k-1] + results.get(k-1)[k-1][j]
								 : results.get(k-1)[i][j];
					
			results.add(Dk);
			System.out.println("D(" + (k) + ")");
			printMatrix(results.get(k));
		}
		
		return results.get(results.size() - 1);
	}
	
	private static void printMatrix(int[][] L)
	{
		for (int i = 0; i < L.length; i++) {
			for (int j = 0; j < L.length; j++)
				System.out.print(L[i][j] + "\t");
			System.out.println();
		}
	}
}
