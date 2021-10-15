import java.util.Scanner;

public class Echo {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);

    System.out.println("Enter what word to echo tree times:");

    // String input
    String name = myObj.nextLine();

    if (name.matches("^.*[^a-zA-Z ].*$") == true){
	    System.out.println("Only letters are allowed");
    }
    else{
	  if (name.length() > 15 || name.length() < 1){
	    System.out.println("wrong length");
	  }
	  else{
    // Output input by user
	    System.out.println(name + " " + name + " " + name);
	  } 
    }
	myObj.close();
  }
}
