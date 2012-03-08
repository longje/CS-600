public class Program {

    //Test on MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM
    //Solution is MHYMRORMYHM
    
    static char[] y = "MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM".toCharArray();
    //static char[] y = "character".toCharArray();
    static int[][] repeat = new int[y.length][y.length];
    static String[][] solution = new String[y.length][y.length];
    
    static int[] track = new int[y.length];
    static String[] subseqs = new String[y.length];
    static String res = "";
    public static void main(String[] args) {
        
        for (int i = 0; i < y.length ; i++)
        {
            //repeat[i][i] = 1;
        	solution[i][i] = y[i] + "";
        }
        
        for (int i = 0; i < y.length - 1 ; i++)
        {
        	if (y[i] == y[i + 1])
        	{
        		//repeat[i][i + 1] = 2;
        		solution[i][i+1] = solution[i][i] + y[i]; 
        	}
        	else
        	{
        		//repeat[i][i+1] = 1;
        		solution[i][i+1] = y[i] + "";
        	}
        }
        
        for (int i = y.length - 1; i >= 0; i--)
        {
        	String temp = y[i] + "";
        	System.out.print("Set: " + y[i]);
        	for (int j = i + 1; j < y.length; j++)
        	{
        		System.out.print(y[j]);
        		if (y[i] == y[j]) {
        			//repeat[i][j] = repeat[i + 1][j - 1] + 2;
        			solution[i][j] = y[i] + solution[i + 1][j - 1] + y[i];
        		}
        		else
        		{
        			//repeat[i][j] = (repeat[i + 1][j] > repeat[i][j-1])
                    	//				? repeat[i+1][j]
                    		//			: repeat[i][j-1];
                    solution[i][j] = (solution[i + 1][j].length() > solution[i][j-1].length())
										? solution[i+1][j]
										: solution[i][j-1];
                    
        		}
        	}
        }
        
        System.out.println("Longest palindrome subsequence is: " + res);
        printArray(solution);

    }
    
    private static void printSingleArray(int[] array)
    {
        for(int x: track)
        {
            System.out.print(x + " ");
        }
    }
    
    private static void printArray(String[][] array)
    {
        Boolean printHead = false;
        for (int i = 0; i < array.length; i++)
        {
            
            if (!printHead) {
                System.out.print("  ");
                for (int x = 0; x < y.length; x++)
                    System.out.print(y[x] + "\t");
                System.out.println();
                printHead = true;
            }
            
            System.out.print(y[i] + " ");
            
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        
    }

}