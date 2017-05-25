package inteligentCalculetor;

import java.util.Scanner;

public class MainClassForAllPostulate  {
	private static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\n*** WELCOME TO INTELLIGENCY! ***\n");

		boolean flag = true;
		while(flag){
			int choice=firstPrint();
			if(choice==0) flag= false;
			switch (choice){
			case 1: 
				//P_UI ob1= new P_UI();
				P_UI.p_ui();
				break;
			case 2:
				//V_UT_AT2 ob2= new V_UT_AT2();
				V_UT_AT2.v_ut_at2();
				break;
			case 3: 
				V_U_at ob3= new V_U_at ();
				ob3.v_u_at();
				break;
			case 4: 
				F_ma ob4= new F_ma ();
				ob4.f_ma();
				break;
			}
		}
	}
	public static int firstPrint(){
		System.out.println("Choice your decipline: ");
		System.out.println("1. P = U*I.\n2. s = Ut+1/2at^2.\n3. V = U+at.\n4. F = ma.\n5. V^2 = U^2+2as.\n\nPress '0' to EXIT!!!");
		int c =scan.nextInt(); 
		return c;
	}
}
