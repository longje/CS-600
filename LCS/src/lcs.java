
public class lcs {
	
	public static int[][] c;
	public static Position[][] b;
	private static char[] xholder;
	private static char[] yholder;
	
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
        	//return memo[i][j];
        }
        else
        {
        	String j1 = memoizedLCS(x, y, i, j-1, sub, memo);
        	String i1 = memoizedLCS(x, y, i-1, j, sub, memo);
        	result = (j1.length() > i1.length())
        					? j1
        					: i1;
        	//return memo[i][j];
        }
        memo[i][j] = result;
        return result;
	}
	
	
	
	public static void lcsLength(char[] x, char[] y)
	{
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
		//printArray(c);
		printArray(b);
	}
	
	private static void printArray(int[][] array)
	{
		System.out.print("    ");
		for (int i = 0; i < xholder.length; i++)
		{
			System.out.print(xholder[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < array[0].length; i++)
		{
			if (i > 0)
				System.out.print(yholder[i - 1] + " ");
			else 
				System.out.print("  ");
			for (int j = 0; j < array.length; j++)
			{
				System.out.print(array[j][i] + " ");
			}
			System.out.println();
		}
	}
	
	private static void printArray(Position[][] array)
	{
		System.out.print("\t");
		for (int i = 0; i < xholder.length; i++)
		{
			System.out.print(xholder[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i < array[0].length; i++)
		{
			if (i > 0)
				System.out.print(yholder[i - 1] + " ");
			else 
				System.out.print("  ");
			for (int j = 0; j < array.length; j++)
			{
				System.out.print(array[j][i] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void printLCS(int i, int j)
	{
		if (i == -1 || j == -1)
			return;
		//System.out.println("J: " + j + " I: " + i + "Position: " + b[i][j]);
		if (b[i][j] == Position.UPDIAG)
		{
			printLCS(i - 1, j - 1);
			System.out.print(xholder[i - 1]);
		}
		else if (b[i][j] == Position.LEFT)
			printLCS(i - 1, j);
		else if (b[i][j] == Position.UP)
			printLCS(i, j - 1);
	}
}
