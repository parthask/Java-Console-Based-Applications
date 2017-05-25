package inteligentCalculetor;

import java.util.Scanner;

public class P_UI {
	private static final Scanner scan = new Scanner(System.in);

	static public void p_ui(){
		System.out.println("Which variable do you want as output: "
				+ "\n1. P = ?\n2. U = ?\n3. I = ?");
		int a= scan.nextInt();
		double i1=0,p1=0,u1=0;
		switch(a){
		case 1:
			System.out.print("U = ");
			u1= scan.nextDouble();
			System.out.print("I = ");
			i1= scan.nextDouble();
			p1=u1*i1;
			System.out.println("RESULT: "+"P = "+p1);
			break;

		case 2:
			System.out.print("P = ");
			p1= scan.nextDouble();
			System.out.print("I = ");
			i1= scan.nextDouble();
			u1=p1/i1;
			System.out.println("RESULT: "+"U = "+u1);
			break;
			
		case 3:
			System.out.print("U = ");
			u1=scan.nextDouble();		
			System.out.print("P = ");
			p1= scan.nextDouble();
			i1=p1/u1;
			System.out.println("RESULT: "+"I = "+i1);
			break;
			
		}	
	}
}
