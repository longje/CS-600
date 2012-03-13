
public class lcs {

	//Dynamic Programming related variables
	public static int[][] c;
	public static Position[][] b;
	public static char[] xholder;
	private static char[] yholder;
	public static String dynVal = "";
	
	//Recursive version of LCS
	public static String lcsRecursive(char[] x, char[] y, int i, int j, String sub)
	{
        if (i < 0 || j < 0)
            return sub + "";
        
        if (i >= 0 && j >= 0 && x[i] == y[j])
        	return lcsRecursive(x, y, i-1, j-1, x[i] + sub);
        else
        {
        	String j1 = lcsRecursive(x, y, i, j-1, sub);
        	String i1 = lcsRecursive(x, y, i-1, j, sub);
        	return (j1.length() > i1.length())
        				? j1
        				: i1;
        }
	}
	
	//Memoization version of LCS
	public static String memoizedLCS(char[] x, char[] y, int i, int j, String sub, String[][] memo)
	{

        if (i < 0 || j < 0)
            return sub;
        
		if (i >= 0 && j >=0 && memo[i][j] != null)
            return memo[i][j];

        String result = null;
        
        if (i >= 0 && j >= 0 && x[i] == y[j])
        {
        	result = memoizedLCS(x, y, i-1, j-1, sub, memo) + x[i];
        }
        else
        {
        	String j1 = memoizedLCS(x, y, i, j-1, sub, memo);
        	String i1 = memoizedLCS(x, y, i-1, j, sub, memo);
        	result = (j1.length() > i1.length())
        					? j1
        					: i1;
        }
        memo[i][j] = result;
        return result;
	}
	
	//Dynamic Programming version of LCS
	public static String lcsLength(char[] x, char[] y)
	{
		dynVal = "";
		int m = x.length + 1;
		int n = y.length + 1;
		
		xholder = x;
		yholder = y;
		c = new int[m][n];
		b = new Position[m][n];
		
		for(int i = 0; i < m; i++)
			c[i][0] = 0;
		
		for(int i = 0; i < n; i++)
			c[0][i] = 0;
		
		for (int i = 1; i < m; i++) 
		{
			for (int j = 1; j < n; j++)
			{
				if (x[i - 1] == y[j - 1]) 
				{
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = Position.UPDIAG;
				}
				else if (c[i][j - 1] >= c[i - 1][j])
				{
					c[i][j] = c[i][j - 1];
					b[i][j] = Position.UP;
				}
				else if (c[i - 1][j] >= c[i][j - 1])
				{
					c[i][j] = c[i- 1][j];
					b[i][j] = Position.LEFT;
				}
			}
		}
		
		printLCS(m-1,n-1);
		return dynVal;
	}
	
	//Helper method for dynamic programming to print solution
	public static void printLCS(int i, int j)
	{
		if (i == -1 || j == -1)
			return;
		if (b[i][j] == Position.UPDIAG)
		{
			printLCS(i - 1, j - 1);
			dynVal += xholder[i - 1];
		}
		else if (b[i][j] == Position.LEFT)
			printLCS(i - 1, j);
		else if (b[i][j] == Position.UP)
			printLCS(i, j - 1);
	}
}
