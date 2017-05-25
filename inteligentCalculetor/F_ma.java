package inteligentCalculetor;

import java.util.Scanner;

public class F_ma {
	private static final Scanner scan = new Scanner(System.in);

	public static void f_ma() {
		System.out.println("Which variable do you want as output: "
				+ "\n1. F = ?\n2. m = ?\n3. a = ?");
		int a= scan.nextInt();
		double f1=0,m1=0,a1=0;
		switch(a)
		{
		case 1:
			System.out.print("m = ");
			m1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			f1=m1*a1;
			System.out.println("RESULT: "+"F = "+f1);
			break;

		case 2:
			System.out.print("F = ");
			f1= scan.nextDouble();
			System.out.print("a = ");
			a1= scan.nextDouble();
			m1=f1/a1;
			System.out.println("RESULT: "+"m = "+m1);
			break;

		case 3:
			System.out.print("F = ");
			f1=scan.nextDouble();		
			System.out.print("m = ");
			m1= scan.nextDouble();
			a1=f1/m1;
			System.out.println("RESULT: "+"a = "+a1);
			break;

		}
		
	}

}
