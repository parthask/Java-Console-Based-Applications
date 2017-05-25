package bankAccount;
import java.util.Scanner;

public class BankAccountUsingConstructor {

	String name;
	int account_number;
	String account_type;
	int current_amount= 500000;

	public Scanner scanit = new Scanner(System.in);

	BankAccountUsingConstructor( String name, int acc_num, String acc_type){

		System.out.println("name: "+name);
		System.out.println("your account number: "+acc_num);
		System.out.println("type of account: "+acc_type);

		System.out.print("Balance exists in account: ");
		System.out.println(current_amount);

	}

	BankAccountUsingConstructor(int money, int  withdraw_value) {
		System.out.println("How much do you want to withdraw???");
		int withdrawmoney= withdraw_value;
		if (money>=withdrawmoney){
			System.out.println("You can withdraw this amount...  :)");
			System.out.println("Your current balance is: "+( money-withdrawmoney)+"\nThank you.");
		}else{
			System.out.println("Your demand does not exists in your account!!! ");
		}
	}

	BankAccountUsingConstructor(int  deposit_value){
		System.out.println("How much do you want to deposite???");
		//int deposite_money= deposit_value;
		System.out.println("you will get information about your deposite lattar.\nThank you.");

	}

	public static void main(String[] args) {

		//BankAccountUsingConstructor ob2 = new BankAccountUsingConstructor();
		new BankAccountUsingConstructor("PARTHA SARATHI",26040,"savings");
		new BankAccountUsingConstructor(2);
		new BankAccountUsingConstructor(5000, 3);

		//				try {
		//					ob2.initialisation();
		//					ob3.initialisation();
		//					
		//				} catch (Exception e) {
		//					System.out.println("exception found!!!\nWrong input!!!");
		//				}

	}
}






