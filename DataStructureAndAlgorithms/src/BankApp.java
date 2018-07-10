
class BankApp {
	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount(100.00); // create acct
		System.out.print("Before transactions, ");
		ba1.display();
		ba1.deposit(74.35);
		ba1.withdraw(20.00);
		// display balance
		// make deposit
		// make withdrawal
		System.out.print("After transactions, ");
		ba1.display();
	} // end main()
} // end class BankApp