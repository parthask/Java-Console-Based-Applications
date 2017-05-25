
//question no: 3 savings class

package bankAccount;

import java.util.Scanner;

public class Savings_account {
	Scanner scanit= new Scanner(System.in);

	final double interest_rate= 0.05;
	public int deposit_balance=50000;
	int current_balance= deposit_balance;


	void accept_deposit(){
		System.out.println("How much amount for deposit???");
		this.deposit_balance=scanit.nextInt();
		current_balance= this.deposit_balance;				
		System.out.println("Your current balanc is: "+ current_balance);
		deposit_interest( deposit_balance );
	}
	void deposit_interest(int deposit_balance ){
		double deposite_interest= (double) (this.interest_rate*this.deposit_balance);
		System.out.println("your total deposit interest is: "+deposite_interest);

	}
	void withdrawalpermit(int deposit_balance){
		System.out.println("Your current balance is: "+this.deposit_balance);
		double withdraw;
		System.out.println("How much do you want to withdraw???");
		withdraw= scanit.nextInt();
		if (withdraw<=this.deposit_balance){
			System.out.println("You can withdraw this amount...  :)");
			System.out.println("Your current balance is: "+(this.deposit_balance-withdraw)+"\nThank you.");
		}else{
			System.out.println("Your demand does not exists in your account!!! ");
			System.out.println("Please try again!!!");	

		}

	}
}


