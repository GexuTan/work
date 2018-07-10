
public class BankAccount{
	private double balance;

	public BankAccount(double openingBalance) {
		balance = openingBalance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}
	
	public void display() {
		//account balance
		//constructor
		//makes deposit
		//makes withdrawal
		//displays balance

System.out.println("balance=" + balance);
	
}
}

// end class BankAccount


/*





}*/