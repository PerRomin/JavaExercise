import java.util.Scanner;

public class Smile {

    public static int[] FindSmile(String name){
        int[] Smile = new int[100] ;
		int i,j=0;
		Smile[0]=0xf;
		for (i=0;name.contains(":)");){
		    Smile[j++] = name.indexOf(":)");
			name=name.replaceFirst(":\\)", "  ");
		}
		for (i=0;name.contains(";)");i++){
	    	Smile[j++] = name.indexOf(";)");
			name=name.replaceFirst(";\\)", "  ");
		}
		for (i=0;name.contains(":-)");i++){
	    	Smile[j++] = name.indexOf(":-)");
			name=name.replaceFirst(":-\\)", "   ");
		}
		for (i=0;name.contains(";-)");i++){
	    	Smile[j++] = name.indexOf(";-)");
			name=name.replaceFirst(";-\\)", "   ");
		}
		Smile[j]=0xf;
		j=i;//removes warning
		return Smile;
    }

    public static void main(String[] args) {
    	Scanner myObj = new Scanner(System.in);

    	System.out.println("Enter the string which contains a smile:");

	    // String input
    	String name = myObj.nextLine();

	    if (name.matches("^.*[^ -~ ].*$") == true){
		System.out.println("space to tilde are allowed");
    	}
    	else{
			if (name.length() > 20 || name.length() < 1){
	    		System.out.println("wrong length");
			}
			else{
 	   // Output input by user
		    	int n[] = FindSmile(name);
				int i;
		    	for(i=0; n[i]!=0xf; i++ ){
					System.out.println("\nthe smile is at " + n[i]);
					}
    			}
			}
		myObj.close();
		}	
	}