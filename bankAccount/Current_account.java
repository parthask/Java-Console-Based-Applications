
//question no: 3 current class//

package bankAccount;

import java.util.Scanner;

public class Current_account {
	Scanner scanit= new Scanner(System.in);

	int current_balance= 50000;	
	void current_balance(){
		System.out.println("Your current balanc is: "+ this.current_balance);
		System.out.println("Thank you.");
	}
	void issue_cheque(){
		System.out.println("How much do you want to issue for cheque???");
		int issued_value= scanit.nextInt();

		if(issued_value>current_balance-1000){
			System.out.println("This amount will impose panalty!!!\nDo you want to issue this amount???\n1. Yes | 2. No\nChoice option: ");
			int option=scanit.nextInt();

			if(option==1){
				System.out.println("Successfully issued :)\nYour imposed panalty is: 100 per month.\nThank you.");
			}else{
				System.out.println("Thank you.");
			}
		}else{
		
				System.out.println("Successfully issued :)\nYour current balance is: "+(current_balance-issued_value));
		}
	}

	void imposed_panalty(){
		System.out.println("You can't access it without issue a cheque!!!\nPlease choise option 2.\nThank you.");
	}

static void prln(Object myobject) {
	System.out.println(myobject);
}
}
