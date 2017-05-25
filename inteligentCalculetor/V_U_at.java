package inteligentCalculetor;

import java.util.Scanner;

public class V_U_at {
	private static final Scanner scan = new Scanner(System.in);

	public void v_u_at() {
		System.out.println("Which variable do you want as output: "
				+ "\n1. V = ?\n2. U = ?\n3. a = ?\n4. t = ?");
		int n= scan.nextInt();
		double v1=0,u1=0,a1=0,t1=0;

		switch(n){
		case 1: 
			System.out.print("U = ");
			u1= scan.nextDouble();
			System.out.print("t = ");
			t1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			v1= u1+(a1*t1);
			System.out.println("RESULT: "+"V = "+v1);
			break;
			
		case 2:
			System.out.print("V = ");
			v1= scan.nextDouble();
			System.out.print("t = ");
			t1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			u1= v1-(a1*t1);
			System.out.println("RESULT: "+"U = "+u1);
			break;
			
		case 3:
			System.out.print("V = ");
			v1= scan.nextDouble();
			System.out.print("t = ");
			t1= scan.nextDouble();
			System.out.print("U = ");
			u1= scan.nextDouble();
			a1= (v1-u1)/t1;
			System.out.println("RESULT: "+"a = "+a1);
			break;
			
		case 4:
			System.out.print("V = ");
			v1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			System.out.print("U = ");
			u1= scan.nextDouble();
			t1= (v1-u1)/a1;
			System.out.println("RESULT: "+"t = "+t1);
			break;
			
		}		
	}
}
