
public enum Denominations {
	Quarter(25), Dime(10), Nickel(5), Penny(1);
	 
	private int value;

	private Denominations(int value) {
	    this.value = value;
	}

	public int getValue() {
	    return this.value;
	}
}
