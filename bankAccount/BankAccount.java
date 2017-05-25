
//question no: 1//

package bankAccount;

import java.util.Scanner;

public class BankAccount {
	int test;
	String name;
	String account_number;
	String account_type;
	int current_amount = 5000;

	public Scanner scanit = new Scanner(System.in);

	void initialisation() {

		System.out.print("Name of the depositor: ");
		this.name = scanit.nextLine();
		System.out.print("Enter your account number: ");
		this.account_number = scanit.nextLine();

		System.out.print("type of account: ");
		account_type = scanit.next();
		System.out.println("What do you want to know??? ");
		System.out.println("1. Account balance | 2. Deposite an amount | 3. Whitdraw an amount |");

		test = scanit.nextInt();
		switch (test) {
		case 1:
			System.out.print("Balance exists in account: ");
			System.out.println(current_amount);
			break;
		case 2:
			deposite();
			break;
		case 3:
			withdraw(current_amount);
			break;
		}
	}

	void withdraw(int money) {
		System.out.println("How much do you want to withdraw???");
		int withdrawmoney = scanit.nextInt();
		if (money >= withdrawmoney) {
			System.out.println("You can withdraw this amount...  :)");
			System.out.println("Your current balance is: " + (money - withdrawmoney) + "\nThank you.");
		} else {
			System.out.println("Your demand does not exists in your account!!! ");
			System.out.println("Please try again!!!");
		}
	}

	void deposite() {
		System.out.println("How much do you want to deposite???");
		// @SuppressWarnings("unused")
		 int deposite_money= scanit.nextInt();
		System.out.println("you will get information about your deposite latter.\nThank you.");

	}

	public static void main(String[] args) {

		BankAccount ob = new BankAccount();
		 try {
		 ob.initialisation();
		 } catch (Exception e) {
		 System.out.println("exception found!!!\nWrong input!!!"+ e);
		 }
		//ob.initialisation();

	}

}