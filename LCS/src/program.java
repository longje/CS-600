/*
 * Jason Long
 * CS600
 * I have left the "recursive" method commented out below, as it is unable to compute any sequences of any great size.
 * The sequence starts at sequence 2 and continues to sequence 6 using the dynamic and memoization methods.
 */

import java.util.ArrayList;

public class program {
	
	public static void main(String[] args) {
		ArrayList<Results> results = new ArrayList<Results>();
		
		for (int i = 1; i < Sequences.sequences.length; i++)
		{
			for (int j = i + 1; j < Sequences.sequences.length; j++)
			{
				char[] x = Sequences.sequences[i];
				char[] y = Sequences.sequences[j];
				long startTime;
				long endTime;

				results.add(new Results(i+1, j+1));
				int index = results.size() - 1;
				
				//Dynamic
				try {
					startTime = System.currentTimeMillis();
					String temp = lcs.lcsLength(y, x);
					endTime = System.currentTimeMillis();
					results.get(index).dynlcs = temp;
					results.get(index).dyntime = (endTime - startTime);
					
				}
				catch (Exception ex)
				{
					results.get(index).dyntime = 1000000;
					results.get(index).dynlcs = "n/a";
				}
				
				/*
				//Recursive - Commented out for time purposes
				try {
					startTime = System.currentTimeMillis();
					String temp = lcs.lcsRecursive(x, y, x.length - 1, y.length - 1, "");
					endTime = System.currentTimeMillis();
					results.get(index).rectime = (endTime - startTime);
					results.get(index).reclcs = temp;
				}
				catch (Exception ex)
				{
					System.out.println("Recursive Exception: " + ex.getMessage());
					results.get(index).rectime = 1000000;
					results.get(index).reclcs = "n/a";
				}
				*/
				
				//Memoization
				String[][] memo = new String[x.length][y.length];
				
				for(int a = 0; a < memo.length; a++)
					for(int b = 0; b < memo[a].length; b++)
						memo[a][b] = null;
				
				
				try {
					startTime = System.currentTimeMillis();
					String temp = lcs.memoizedLCS(x, y, x.length - 1, y.length - 1, "", memo);
					endTime = System.currentTimeMillis();
					results.get(index).memotime = (endTime - startTime);
					results.get(index).memolcs = temp;
				}
				catch (Exception ex)
				{
					results.get(index).memotime = 1000000;
					results.get(index).memolcs = "n/a";
				}
			}
		}
		
		for(Results x: results)
		{
			printResults(x);
		}
    }
	
	public static void printResults(Results x)
	{
		System.out.println();
		String seqa = "Sequence: " + x.SeqA;
		String seqb = "Sequence: " + x.SeqB;
		String dyntime = "Dynamic Programming: " + x.dyntime;
		String dynlcs = "Dynamic LCS: " + x.dynlcs;
		
		String rectime = "Recursive Meth: " + x.rectime;
		String reclcs = "Recursive LCS: " + x.reclcs;
		
		String memotime = "Memoize Method: " + x.memotime;
		String memolcs = "Memo LCS: " + x.memolcs;
		
		System.out.println(seqa + " compared with " + seqb);
		System.out.println(dyntime);
		System.out.println(dynlcs);
		System.out.println(rectime);
		System.out.println(reclcs);
		System.out.println(memotime);
		System.out.println(memolcs);
	}
}
