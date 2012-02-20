public class rod {
    
    static int[] PriceTable = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    static int[] s;
    
    public static void main(String[] args) {
        int lengthofrod = Integer.parseInt(args[0]);
        int result = cutrod(PriceTable, lengthofrod);
        int resultdyn = MemoizedCutRod(PriceTable, lengthofrod);
        int resultdynBot = BottomUpCutRod(PriceTable, lengthofrod);
        System.out.println("Result w/o Dynamic Proc is: " + result);
        
        System.out.println("Result w/ Dynamic Proc (Memoized) is: " + resultdyn);
        System.out.println("Result w/ Dynamic Proc (Bottom Up) is: " + resultdynBot);
        PrintCutRodSolution(PriceTable, lengthofrod);
        
    }
    
    public static int BottomUpCutRod(int[] p, int n)
    {
        int[] r = new int[p.length];
        s = new int[p.length];
        r[0] = 0;
        for (int j = 1; j <= n; j++)
        {
            int result = -1;
            for (int i = 1; i <= j; i++)
            {
                if (result < PriceTable[i] + r[j - i]) {
                    result = max(result, PriceTable[i] + r[j - i]);
                    s[j] = i;
                }
            }
            r[j] = result;
        }
        return r[n];
    }
    
    public static void PrintCutRodSolution(int[] p, int n)
    {
        while (n > 0) {
            System.out.println(s[n]);
            n = n - s[n];
        }
    }
    
    
    public static int MemoizedCutRod(int[] p, int n)
    {
        int[] r = new int[p.length];
        for (int i = 1; i <= n; i++)
        {
            r[i] = -1;
        }
        return MemoizedCutRodAux(p, n, r);
    }
    
    public static int MemoizedCutRodAux(int[] p, int n, int[] r)
    {
        if (r[n] >= 0)
            return r[n];
            
        if (n == 0)
            return 0;
        
        int result = -1;
        for (int i = 1; i <= n; i++)
        {
            result = max(result, PriceTable[i] + MemoizedCutRodAux(PriceTable, n - i, r));
        }
        r[n] = result;
        return result;
    }
    
    public static int cutrod(int[] p, int n)
    {
        if (n == 0)
            return 0;
        
        int result = -1;
        for (int i = 1; i <= n; i++)
        {
            result = max(result, PriceTable[i] + cutrod(PriceTable, n - i));
        }
        return result;
    }
    
    public static int max(int q, int o)
    {
        return (q > o) ? q : o;
    }

}