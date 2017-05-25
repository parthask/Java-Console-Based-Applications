
//question no: 4//

package bankAccount;

import java.util.Scanner;

public class AccountUsingConstructor {

		static String customer_name;
		static int account_number;
		static int typeOfAccount;    //={ "Savings account","current account"};
		static Scanner scanit= new Scanner(System.in);

		 AccountUsingConstructor(String name, int acc_num){
			 System.out.print("Name of the customer: "+name);
				customer_name= name;
				System.out.print("Enter your account number: "+acc_num);
				account_number= acc_num;

		 }
		public static void main(String[] args) {

			System.out.println("Type of account???\n1. Savings account | 2. Current account");
			System.out.print("Enter your choice: ");
			typeOfAccount=scanit.nextInt();
			
			if(typeOfAccount==1){
				System.out.println("Your savings account does not permit you to issue any cheque!!!");
				System.out.println("What do you want to do??? ");
				System.out.println("1. Deposit an amount | 2. Deposite interest  | 3. Whitdrawal information  | 4. Minimum balance & Imposed panalty");
				System.out.print("Enter your choice: ");

				Savings_account ob1= new Savings_account();  // object of savings class

				int test= scanit.nextInt();
				switch(test){
				case 1:
					ob1.accept_deposit();
					break;
				case 2:
					ob1.deposit_interest(ob1.deposit_balance);
					break;
				case 3:
					ob1. withdrawalpermit(ob1.deposit_balance);
					break;
				default :
					System.out.println("Wrong choice!!!\nTry again...");
				}
			}else{

				Current_account ob2= new Current_account();  // object of current  class

				System.out.println("Your current account contains these facilities...");
				System.out.println("1. Current balance | 2. issue cheque | 3. Imposed panalty");
				System.out.print("Enter you choice: ");
				int test= scanit.nextInt();
				switch(test){
				case 1:
					ob2.current_balance();
					break;
				case 2:
					ob2.issue_cheque();
					break;
				case 3:
					ob2. imposed_panalty();
					break;
				default :
					System.out.println("Wrong choice!!!\nPlease try again...");

				}
			}
		}

	}


