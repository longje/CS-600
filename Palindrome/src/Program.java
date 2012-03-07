
public class Program {

	//static char[] y = new char[]{ 's', 'p', 'a', 'n', 'k', 'i', 'n', 'g' };
	//static char[] y = new char[]{ 'c', 'h', 'a', 'r', 'a', 'c', 't', 'e', 'r', 's', 'a' };
	
	//Failed on MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM 
	// Real solution is MHYMRORMYHM
	//Only came up with HARORAH
	
	static char[] y = "MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM".toCharArray();
	static int[][] repeat = new int[8][8];
	static int[] track = new int[y.length];
	
	public static void main(String[] args) {
		
		
		for (int i = 0; i < y.length; i++)
		{
			for (int j = i + 1; j < y.length; j++)
			{
				if (Character.valueOf(y[i]).compareTo(y[j]) == 0)
				{
					track[j] = i + 1;
				}
			}
		}
		
		String result = "";
		
		for (int i = 0; i < track.length; i++)
		{
			
			String temp = y[i] + "";
			int lastAdd = 10000000;
			
			for (int j = i + 1; j < track.length; j++)
			{
				if (track[j] == 0)
					continue;
				
				if (track[j] - 1 < i && track[j] < lastAdd)
				{
					lastAdd = track[j];
					temp += y[track[j] - 1];
					temp = y[track[j] - 1] + temp;
				}
			}
			
			if (temp.length() > result.length())
				result = temp;
			
			System.out.println("Longest palindrome subsequence is: " + result);
			
		}
		System.out.println("Longest palindrome subsequence is: " + result);
		printSingleArray(track);

	}
	
	private static void printSingleArray(int[] array)
	{
		for(int x: track)
		{
			System.out.print(x + " ");
		}
	}
	
	private static void printArray(int[][] array)
	{
		for (int i = 0; i < repeat.length; i++)
		{
			//System.out.print(repeat[i] + " ");
			for (int j = 0; j < repeat[i].length; j++)
			{
				System.out.print(repeat[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
