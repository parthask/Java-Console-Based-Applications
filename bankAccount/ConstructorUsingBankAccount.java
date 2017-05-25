
//question no: 2//

package bankAccount;

import java.util.Scanner;

public class ConstructorUsingBankAccount {

		int test;
		String name;
		int account_number;
		String account_type;
		int current_amount= 5000;

		public Scanner scanit = new Scanner(System.in);
		ConstructorUsingBankAccount( String name, int acc_num, String acc_type){			
			System.out.println("Name of the depositor: "+ name);
			 
			System.out.println("Enter your account number: "+acc_num);
			this.account_number= acc_num;

			System.out.println("type of account: "+acc_type);
			account_type=acc_type;
			System.out.print("What do you want to know??? ");
			System.out.println("1. Account balance | 2. Deposite an amount | 3. Whitdraw an amount |");
			System.out.print("Choice option: ");
			test= scanit.nextInt();
			switch(test){
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
			int withdrawmoney= scanit.nextInt();
			if (money>=withdrawmoney){
				System.out.println("You can withdraw this amount...  :)");
				System.out.println("Your current balance is: "+( money-withdrawmoney)+"\nThank you.");
			}else{
				System.out.println("Your demand does not exists in your account!!! ");
			System.out.println("Please try again!!!");
			}
		}

		void deposite(){
			System.out.println("How much do you want to deposite???");
			//@SuppressWarnings("unused")
			//int deposite_money= scanit.nextInt();
			System.out.println("you will get information about your deposite lattar.\nThank you.");

		}

		public static void main(String[] args) {

			try {
				 new ConstructorUsingBankAccount("PARTHA SARATHI", 26040,"SAVINGS");
				
			} catch (Exception e) {
				System.out.println("exception found!!!\nWrong input!!!");
			}
	}

}
