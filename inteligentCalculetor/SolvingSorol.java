package inteligentCalculetor;

import java.util.*;

public class SolvingSorol {
	static void  math(){
		int c, i,a[] = new int[10000];
		String expr = "(2*4)*3 -( 4/5)*7 +(2+6)- 3+2";
		String delims = "[+\\-*/\\^(.*\\) ]+"; 
		//String delims = "+\\-*/\\^ ]\\(.*\\)";
		//String delims = "[+\\-*/\\^ ]+"; // so the delimiters are:  + - * / ^ space
		String[] tokens = expr.split(delims);
		c=tokens.length;
		for ( i = 1; i < c; i++){			
			a[i]= Integer.parseInt(tokens[i]);
			System.out.println(a[i]);
			//System.out.println(tokens[i]);
		}		
	}
	public static void main(String[] args) {
			math();		
	}
}


//public class SolvingSorol {
//	static void  math(){
//		int c, i;
//		char cd=' ';
//		int a[]=new int[100];
//		String expr = "(2*x)^3 - 4/5*y + z^2";
//		String delims = "[+\\-*/\\^(.*\\) ]+"; // so the delimiters are:  + - * / ^ space
//		//String delims = "+\\-*/\\^ ]\\(.*\\)";
//		String[] tokens = expr.split(delims);
//		c=tokens.length;
//		for ( i = 0; i < c; i++){
//			//    System.out.println(tokens[i]);
//			if(!tokens[i].equals("")){
//				cd= tokens[i].charAt(0);
//			}
//			//    System.out.println(cd);
//			if(Character.isDigit(cd)){
//				a[i]= Integer.parseInt(tokens[i]);
//				System.out.println(a[i]);
//			}
//		}
//	}
//	public static void main(String[] args) {
//		math();
//	}
//
//}