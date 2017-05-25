/*
If the voltage is U=200V and the current is I=4.5A, which power is generated?
A light-bulb yields P=100W and the voltage is U=220V. Compute the current, please.
bla bla bla lightning strike I=2A bla bla bla P=2.5MW bla bla voltage?
U=12V, P=2.5MW then find I?

*/

package inteligentCalculetor;

import java.util.Scanner;

public class ArtificialIntelligence {
	private static Scanner input;
	static void stringToint(String str)
	{
		int u=0,i=0,p=0,j ,k,t=0,c=0;
		double d1=0,d2=0,d3=0,p1=0,i1 = 0,u1=0;
		String ch = null;

		u= str.indexOf("U=")+2;		
		i= str.indexOf("I=")+2;
		p= str.indexOf("P=")+2;

		char []arr = str.toCharArray();
		k=arr.length;
		if((u-2)!=-1){
			t=0;
			for( j=u; j<k; j++)
			{
				if(arr[j]=='V' || arr[j]=='m' || arr[j]=='k' || arr[j]=='M')
				{
					if(arr[j]=='V' ){
						ch=null;
						break;
					}else if(arr[j]=='m'){
						ch="m";
						break;
					}else if(arr[j]=='M'){
						ch="M";
						break;
					}else if(arr[j]=='k' ){
						ch="k";
						break;
					}

				}else
				{
					t=j+1;
				}
			}

			if(ch==null){
				d1= Double.parseDouble(str.substring(u, t));
			}else if(ch=="m"){
				d1= Double.parseDouble(str.substring(u, t))/100;
			}else if(ch=="k"){
				d1= Double.parseDouble(str.substring(u, t))*1000;
			}else if(ch== "M"){
				d1= Double.parseDouble(str.substring(u, t))*1000000;
			}
			u1=d1;
		}
		if((i-2)!=-1){
			t=0;
			for( j=i; j<k;j++)
			{
				if(arr[j]=='A' || arr[j]=='m' || arr[j]=='k' || arr[j]=='M')
				{
					if(arr[j]=='A' ){
						ch=null;
						break;
					}else if(arr[j]=='m'){
						ch="m";
						break;
					}else if(arr[j]=='M'){
						ch="M";
						break;
					}else if(arr[j]=='k' ){
						ch="k";
						break;
					}
				}else
				{
					t=j+1;
				}
			}

			if(ch==null){
				d2= Double.parseDouble(str.substring(i, t));
			}else if(ch=="m"){
				d2= Double.parseDouble(str.substring(i, t))/100;
			}else if(ch=="k"){
				d2= Double.parseDouble(str.substring(i, t))*1000;
			}else if(ch== "M"){
				d2= Double.parseDouble(str.substring(i, t))*1000000;
			}
			i1=d2;
		}
		if((p-2)!=-1){
			t=0;
			for( j=p; j<k;j++)
			{
				if(arr[j]=='W' || arr[j]=='m' || arr[j]=='k' || arr[j]=='M')
				{
					if(arr[j]=='W' ){
						ch=null;
						break;
					}else if(arr[j]=='m'){
						ch="m";
						break;
					}else if(arr[j]=='M'){
						ch="M";
						break;
					}else if(arr[j]=='k' ){
						ch="k";
						break;
					}
				}else
				{
					t=j+1;
				}
			}

			if(ch==null){
				d3= Double.parseDouble(str.substring(p, t));
			}else if(ch=="m"){
				d3= Double.parseDouble(str.substring(p, t))/100;			
			}else if(ch=="k"){
				d3= Double.parseDouble(str.substring(p, t))*1000;				
			}else if(ch== "M"){
				d3= Double.parseDouble(str.substring(p, t))*1000000;				
			}
			p1=d3;
		}
		
		
		if(p1>0 && i1>0){
			System.out.printf("\nU= %.2fV\n", (p1/i1));
		}else if(p1>0 && u1>0){
			System.out.printf("\nI= %.2fA\n",(p1/u1));
		}else if(u1>0 && i1>0){
			System.out.printf("\nP= %.2fW\n",(u1*i1));
		}
	}



	public static void main(String[] args) {
		input = new Scanner(System.in);
		int t =0;
		try {
			t = Integer.parseInt(input.next());
			input.nextLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
			while(t>0){
			try {
				String str= input.nextLine();
				stringToint(str);
			} catch (Exception e) {

			}
			t--;
		}

	}

}
