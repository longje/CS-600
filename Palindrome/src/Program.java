public class Program {

    //static char[] y = new char[]{ 's', 'p', 'a', 'n', 'k', 'i', 'n', 'g' };
    //static char[] y = new char[]{ 'c', 'h', 'a', 'r', 'a', 'c', 't', 'e', 'r', 's', 'a' };
    
    //Failed on MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM
    // Real solution is MHYMRORMYHM
    //Only came up with HARORAH
    
    //static char[] y = "MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM".toCharArray();
    static char[] y = "character".toCharArray();
    static int[][] repeat = new int[y.length][y.length];
    static int[] track = new int[y.length];
    static String[] subseqs = new String[y.length];
    static String res = "";
    public static void main(String[] args) {
        
        for (int i = 0; i < y.length ; i++)
        {
            repeat[i][i] = 1;
        }
        
        for (int i = 0; i < y.length - 1 ; i++)
        {
        	if (y[i] == y[i + 1])
        		repeat[i][i + 1] = 2;
        	else
        		repeat[i][i+1] = 1;
        }
        
        for (int i = y.length - 1; i >= 0; i--)
        {
        	String temp = y[i] + "";
        	System.out.print("Set: " + y[i]);
        	for (int j = i + 1; j < y.length; j++)
        	{
        		System.out.print(y[j]);
        		if (y[i] == y[j]) {
        			repeat[i][j] = repeat[i + 1][j - 1] + 2;
        			temp += y[j];
					temp = y[j] + temp;
					subseqs[i] += temp + subseqs[j - 1];
        		}
        		else
        		{
        			repeat[i][j] = (repeat[i + 1][j] > repeat[i][j-1])
                    					? repeat[i+1][j]
                    					: repeat[i][j-1];
                    subseqs[i] = y[i] + "";
        		}
        	}
        	System.out.println();
        	System.out.println(subseqs[i]);
        	if (temp.length() > res.length())
				res = temp;
        }
        
        /*
        for (int i = repeat[0].length - 2; i > 0; i--)
        	if (repeat[0][i] > repeat[0][i-1])
        		res += y[i];
        	else if (repeat[0][i] > repeat[0][i+1])
        	{
        		String temp = "";
        		for(char x : res.toCharArray())
        		{
        			temp = x + temp;
        		}
        		res += y[i];
        		res += temp;
        	}
*/
        //int runningVal = 1;
        
        /*
        for (int i = 1; i < y.length - 1; i++)
        {
            String palindrome = y[i] + "";
            
            for (int j = 1; j < y.length - i; j++)
            {
                int s = j+i;
                repeat[j][s] = computecost(repeat, y, j, s);
                repeat[s][j] = computecost(repeat, y, j, s);
                
            }
            //if (palindrome.length() > palindrome.length())
                //result = palindrome;
        }
        */
        System.out.println("Longest palindrome subsequence is: " + res);
        printArray(repeat);

    }
    
    private static int computecost(int[][] result, char[] seq, int i, int j)
    {
        if (i == j)
            return result[i][j];
        else if (seq[i] == seq[j])
        {
        	res += seq[i];
            if (i + 1 < j - 1)
                return result[i+1][j-1] + 2;
            else
                return 2;
        }
        else
            return (result[i+1][j] > result[i][j-1])
                        ? result[i+1][j]
                        : result[i][j-1];
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
        Boolean printHead = false;
        for (int i = 0; i < repeat.length; i++)
        {
            
            if (!printHead) {
                System.out.print("  ");
                for (int x = 0; x < y.length; x++)
                    System.out.print(y[x] + " ");
                System.out.println();
                printHead = true;
            }
            
            System.out.print(y[i] + " ");
            
            for (int j = 0; j < repeat[i].length; j++)
            {
                System.out.print(repeat[i][j] + " ");
            }
            System.out.println();
        }
        
    }

}



/*
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
*/