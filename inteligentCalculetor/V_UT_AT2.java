package inteligentCalculetor;

import java.util.Scanner;

public class V_UT_AT2 {
	private static final Scanner scan = new Scanner(System.in);

	public static void v_ut_at2(){
		System.out.println("Which variable do you want as output: "
				+ "\n1. s = ?\n2. U = ?\n3. a = ?\n4. t = ?");
		int n= scan.nextInt();
		double s1=0,u1=0,a1=0,t1=0;

		switch(n){
		case 1: 
			System.out.print("U = ");
			u1= scan.nextDouble();
			System.out.print("t = ");
			t1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			s1= (u1*t1)+((0.5*1.0)*(a1*(t1*t1)));
			System.out.println("RESULT: "+"s = "+s1);
			break;
			
		case 2:
			System.out.print("s = ");
			s1= scan.nextDouble();
			System.out.print("t = ");
			t1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			u1= (s1/t1)-((0.5*1.0)*(a1*(t1*t1)));
			System.out.println("RESULT: "+"U = "+u1);
			break;
			
		case 3:
			System.out.print("s = ");
			s1= scan.nextDouble();
			System.out.print("t = ");
			t1= scan.nextDouble();
			System.out.print("U = ");
			u1= scan.nextDouble();
			a1= (2*(s1-(u1*t1)))/(t1*t1);
			System.out.println("RESULT: "+"a = "+a1);
			break;
			
		case 4:
			System.out.print("s = ");
			s1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			System.out.print("U = ");
			u1= scan.nextDouble();
			t1= (s1-u1)/a1;
			System.out.println("RESULT: "+"t = "+t1);
			break;
			
		}
	}
}
