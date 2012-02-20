
public class lcs {
	
	public static int[][] c;
	public static Position[][] b;
	private static char[] xholder;
	private static char[] yholder;
	
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
		printArray(c);
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
		System.out.println("J: " + j + " I: " + i + "Position: " + b[i][j]);
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
