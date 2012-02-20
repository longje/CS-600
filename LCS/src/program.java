
public class program {
	
	public static void main(String[] args) {
		char[] y = new char[]{ 'B', 'D', 'C', 'A', 'B', 'A' };
		char[] x = new char[]{ 'A', 'B', 'C', 'B', 'D', 'A', 'B' };
		lcs.lcsLength(y, x);
		lcs.printLCS(y.length, x.length);
    }
}
