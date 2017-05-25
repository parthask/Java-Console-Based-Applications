package javaapp;


public class ClassOfAllBook {
	public String year;
	public String semister;
	private int Coursecode=102;
	protected int NumberOfBook;
	public String courseName;
	protected String extrabook;
	//without making the default object default constructor will not be called.
	ClassOfAllBook(){
		System.out.println("CSE all informations: ");
	}

	//constructor for all informations initialising...
	ClassOfAllBook(String yr, String sem, int NumOfBook, String C_Name ){
		year=yr;
		semister=sem;
		//private int Coursecode=102;
		NumberOfBook= NumOfBook;
		courseName= C_Name;
		printinfo( year, semister, NumberOfBook, courseName );
	}

	//constructor for all books name...
	ClassOfAllBook(String book1, String book2, String book3,String book4, String book5){
		System.out.print("Books name:\n"+book1 +"\n" + book2 +"\n" + book3+"\n"+ book4 +"\n" + book5+".");
	}
	
	public void totalclassinfo(String year, String semister, int NumberOfBook, String CourseName ){
		printinfo( year, semister, NumberOfBook, CourseName );

	}

	////method for all informations printing...

	public void printinfo(String year, String semister, int NumberOfBook, String CourseName ){
		System.out.println("YEAR: " +year);
		System.out.println("SEMISTER: "+semister);
		System.out.println("COURSE NAME & CODE: "+CourseName);
		System.out.println("NUMBER OF BOOKS: "+NumberOfBook);

	}

	/**
	 * @return the coursecode
	 */
	public int getCoursecode() {
		return Coursecode;
	}

	/**
	 * @param coursecode the coursecode to set
	 */
	public void setCoursecode(int coursecode) {
		Coursecode = coursecode;
	}

}
