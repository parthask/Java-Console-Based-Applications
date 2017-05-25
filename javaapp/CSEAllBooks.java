package javaapp;

import java.util.Scanner;

public class CSEAllBooks {

	public static void main(String[] args) {
		String studentName;
		int studentID;
		Scanner scanner= new Scanner(System.in);
		
		System.out.print("* * * Welcome to 'SIUAPP' * * *"+"\n"+"\n"+"Your name: ");
		 studentName= scanner.nextLine();
		System.out.print("Your ID: ");
		studentID=scanner.nextInt();
		
		System.out.println("Your options to choice..."+"\n"+"1. Payment status"+"2. Semi");
		ClassOfAllBook supperob1 = new ClassOfAllBook(); //super class object
		
		SubClassOfAllBooks sub1ob = new SubClassOfAllBooks("Ist","Ist", 5, "CSE-101,"
				+ " PHY-101, MTH-101, HUM-101, ECN-101" );
	
		//using sub class constructor
		 new SubClassOfAllBooks("Computer fundamental.",
				"Math fandamental.","Physics fundamental.","Economics.","Humanities");
		
		//setup a value for the private variable
		sub1ob.setCoursecode(101);

		//print the changed private value
		System.out.println("\n\nChanged private coursecode:"+sub1ob.getCoursecode());
		System.out.println("\n");

		//use super class method
		new ClassOfAllBook("Ist","2nd",5 ,"CSE-103, PHY-103, MTH-102, ECE-101.");
		
		//only use new keyword and calling subclass constructor
		new ClassOfAllBook("Computer programming with C.","Differential & Integral Calculas.",
				"Electricity & magnetism with modern Physics.","Basic Eletrical Engineering.","English");
		System.out.println("\n");

		//access super class method using sub class object
		sub1ob. totalclassinfo("2nd","Ist",6 ,"CSE-201, CSE-205, MTH-203, ECE-203, ACN-201.");
		new SubClassOfAllBooks("Data stracture.","Object Oriented programming.",
				"Discreate Mathematics.","Differential Equations & linear algabra.","Electronic devices & circuits");
		System.out.println(sub1ob.extrabook="\n"+"Principals of Accountings.");

		System.out.println("\n");
		
		//use supper class constructor
		supperob1.totalclassinfo("2nd","2nd",5 ,"CSE-203, CSE-207, MTH-205, ECE-205.");
		//only use new keyword and calling subclass constructor
		new ClassOfAllBook("Algorithm.","Numarical Mathods.","Digital Logic Disign.","vactor annalysis.",
				"Principles of Managements");
	
	}

}
