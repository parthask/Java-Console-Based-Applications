package javaapp;



public class SubClassOfAllBooks  extends ClassOfAllBook {
	SubClassOfAllBooks(String year, String semister, int NumberOfBook, String CourseName) {
		super(year, semister, NumberOfBook, CourseName);
		setCoursecode(101);
		//System.out.println("changed private coursecode:"+getCoursecode());

	}
	
	//to use the superclass default constructor we need to build subclass default constructor
	
	SubClassOfAllBooks(String book1, String book2, String book3,String book4, String book5){

		super( book1, book2, book3, book4, book5);
	}
	
	//
//	@Override
//	public void setCoursecode(int coursecode) {
//		super.setCoursecode(coursecode);
//	}

}
