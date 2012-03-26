
public class Change {
	
	private int amt;
	
	public int pennies;
	public int nickels;
	public int dimes;
	public int quarters;
	
	public Change(int amt)
	{
		this.amt = amt;
	}
	
	public void ChangeIt()
	{
		pennies = amt;
		nickels = pennies / Denominations.Nickel.getValue();
		pennies %= Denominations.Nickel.getValue();
		dimes = (nickels * Denominations.Nickel.getValue()) / Denominations.Dime.getValue();
		nickels = ((nickels * Denominations.Nickel.getValue()) % Denominations.Dime.getValue()) / Denominations.Nickel.getValue();
		
		quarters = ((nickels * Denominations.Nickel.getValue()) + (dimes * Denominations.Dime.getValue())) / Denominations.Quarter.getValue();
		
		dimes = (((nickels * Denominations.Nickel.getValue()) + (dimes * Denominations.Dime.getValue())) % Denominations.Quarter.getValue()) / Denominations.Dime.getValue();
		nickels = (((nickels * Denominations.Nickel.getValue()) + (dimes * Denominations.Dime.getValue())) % Denominations.Quarter.getValue()) / Denominations.Nickel.getValue();
		
		System.out.println("Change for: " + amt + " Pennies: " + pennies + " Nickels: " + nickels + " Dimes: " + dimes + " Quarters " + quarters);
	}
}
