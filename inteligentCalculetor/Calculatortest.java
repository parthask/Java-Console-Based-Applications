package inteligentCalculetor;

import java.util.ArrayList;
import java.util.Scanner; 
import java.io.*;
import java.io.FileNotFoundException;

public class Calculatortest {
private static Scanner input;
public static int invalidlines = 0;
public static int validlines = 0;
public static ArrayList<String> validList = new ArrayList<String>(); 

public void FileNotFoundException(){
System.out.println("Please enter a  valid expression!");

}

public static boolean isInt(String userinput) { 
    try {
        Integer.parseInt(userinput); // Try to parse. Makes sure that the values entered are actual numbers
        return true; // Boolean value to show if the equation entered is valid or not
    } 
    catch (NumberFormatException e) { 
        System.out.println("Please enter a  valid expression!");
        return false; 
    }
}
    public static boolean isValidLine(String line) {
        line = line.trim();
    if (line.length() <= 4) { // Trims the lines down to 4 and ensures there is no spaces being included
            return false; 
        } 
    else 
        {
        String[] calcarray = new String[3];
        calcarray = line.split(" ");
        String operators = new String("[+\\-\\*\\/]"); // Validator using regular expressions to check the operator used

    if (isInt(calcarray[0].toString()) && isInt(calcarray[1].toString()) && calcarray[2].matches(operators)) { // Checks that the operator in the string matches the ones in the regular expression 
        return true; 
}
    else 
{
        return false;
}
}
}
public static void main(String[] args) throws IOException {
input = new Scanner(System.in);
String keyboardInput = new String();
String currentLine = new String();
Scanner kbScan = new Scanner(System.in);
System.out.println("Please press the letter F for file input or K for keyboard input");
        String inputString = new String(input.nextLine());
    int answer = 0;
    while (true){
    if (inputString.equals("K") || inputString.equals("k")) { 
        System.out.println("Please enter an equation");
        keyboardInput = kbScan.nextLine();
    }
    if (isValidLine(keyboardInput)) {
        String[] equation = new String[3];  // We know that this is only going to contain 3 to be valid
        equation = keyboardInput.split(" "); // split this up, as it's stored with the spaces.
    if (inputString.equals("") || inputString.equals(""));
    {
        System.exit(0);
    }
    int num1 = Integer.parseInt(equation[0]); 
    int num2 = Integer.parseInt(equation[1]);
    switch(equation[2]) { // This case switch checks the third position of the string to decide which operator is being used. It then works out the answer and breaks to the next instruction

    case("+"):
        answer = num1 + num2;
    break;
    case("-"):
        answer = num1 - num2; 
    break; 
    case("/"):
        answer = num1 / num2;
    break;
    case("*"):
        answer = num1 * num2;
    break;
}
        System.out.println("Your post fix expression: " + equation[0] + " " + equation[1] + " " + equation[2]);
        System.out.println("Your calculation: " + equation[0] + " " + equation[2] + " " + equation[1] + " = " + answer);
}
    else{ 
        System.out.println("The equation you entered is invalid");
 }
    if (inputString.equals("f") || inputString.equals("F")) { 
        try{
        //Open the file
            System.out.println("Enter File Name: ");
            FileInputStream fstream = new FileInputStream(input.nextLine()); // make a input stream
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream)); // pass input stream to a buffered reader for manipulation
            String strLine; // create string vars
        //loop to read the file line by line
        while ((strLine = br.readLine()) != null)   { // Whilst the buffered readers read line method is not null, read and validate it.
            currentLine = strLine; 
        if(isValidLine(currentLine)) 
        { 
            validList.add(currentLine); 
            validlines++;
            String[] filearray = new String[3];
            filearray = currentLine.split(" ");             
        int val1 = Integer.parseInt(filearray[0]);
        int val2 = Integer.parseInt(filearray[1]);
            System.out.println("Your expression is: " + filearray[0] + " " + filearray[1] + " " + filearray[2]);
        switch(filearray[2]) { 
        case("+"):
                answer = val1 + val2;
            break;
        case("-"):
                answer = val1 - val2; 
            break; 
        case("/"):
                answer = val1 / val2;
            break;
        case("*"):
                answer = val1 * val2;
            break;
            }
            System.out.println("Your calculation is " + filearray[0] + " " + filearray[2] + " " + filearray[1] + " = " + answer);
            } 
        }
        }
            catch (FileNotFoundException e) 
            {
                System.out.println("Please Enter a valid file name");
            }
        }
}
}
}