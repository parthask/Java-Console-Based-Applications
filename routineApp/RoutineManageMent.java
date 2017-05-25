package routineApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RoutineManageMent {

	private static ArrayList <String> semester = new ArrayList ();
	private static ArrayList <String> batch = new ArrayList ();
	private static ArrayList <String> dayName = new ArrayList ();
	private static ArrayList <String> timeOfClass = new ArrayList ();
	private static ArrayList <String> courseCode = new ArrayList ();
	private static ArrayList <String> roomNo = new ArrayList ();
	private static ArrayList <String> teacherName = new ArrayList ();

	private final static Scanner scan = new Scanner (System.in);
	public static void main(String[] args) {
		Boolean first= true;
		while(true){
			Date date = new Date();
			String todayDate = date.toString();
			System.out.println(todayDate);
			
			String answer = "";
			Boolean flag= true;
			System.out.println("WHAT TO DO???\n     1) DATA INPUT.\n     2) DATA OUTPUT!!!");
			answer = scan.nextLine();
			if(answer.equals("1")){
				while( flag){
					System.out.print("NAME OF YOUR SEMESTER: ");
					semester.add(scan.nextLine());						
					System.out.print("NAME OF YOUR BATCH: ");
					batch.add(scan.nextLine());					
					System.out.print("NAME OF THE DAY: ");
					String nameOfDay= scan.nextLine();
					dayName.add(nameOfDay);
					System.out.print("TOTAL NUMBER OF CLASS ON "+ nameOfDay.toUpperCase() + ": ");
					int n= scan.nextInt();
					scan.nextLine();
					System.out.println("PUT THE DATA REQUIERED...");
					while(n>0){
						System.out.print("CLASS TIME: ");
						timeOfClass.add(scan.nextLine());
						System.out.print("COURSE CODE: ");
						courseCode.add(scan.nextLine());
						System.out.print("ROOM NO: ");
						roomNo.add(scan.nextLine());
						System.out.print("NAME OF THE TEACHER: ");
						teacherName.add(scan.nextLine());
						System.out.println();
						n--;
						first = false;
					}
					flag = false;
					
				}
			}else{
				if(first){
				System.out.println("         RUN THE PROGRAM AGAIN!!!");
				System.out.println("GOOD BYE...");
				System.exit(0);
				}else{
					System.out.println(semester + "   "+batch + "   "+ dayName );
					System.out.println("TIME OF CLASS" + "    " + "COURSE CODE" +"    "+ " ROOM NO " +" TEACHER NAME " );
					for(int i=0;i<timeOfClass.size();i++){
						System.out.println(timeOfClass.get(i) +"    "+ courseCode.get(i) + "    "+ roomNo.get(i) +"   "+ teacherName.get(i));
					}
					System.out.println();
				}
			}

		}
	}


}
