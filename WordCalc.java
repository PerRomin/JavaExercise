import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.HashMap;


public class WordCalc {
	public static String string1= new String(""),string2=new String(""),string3=new String("");
	public String[] var;
	
	public static int calculateMinus(int num1, int num2, String name, HashMap<String, Integer> variables){
		int sum, num3;
		String[] variable  = name.split(" ", 3);
		sum = num1 - num2;
		//string1 = (string1 + string2);
		if (name.startsWith("=")==false){
			try {
				num3 = variables.get(variable[1]);
			} catch (Exception e) {
		 		num3 = 0xffff;
			}

			if(variable[0].contains("-")){
				sum = calculateMinus(sum, num3, variable[2], variables);
			}
			if(variable[0].contains("+")){
				sum = calculatePlus(sum, num3, variable[2], variables);
			}
		}
		return sum;
	}

	public static int calculatePlus(int num1, int num2, String name, HashMap<String, Integer> variables){
    	int sum, num3;
		String[] variable  = name.split(" ", 3);
		sum = num1 + num2;
		//string1 = (string1 + string2);
		if (name.startsWith("=")==false){
			try {
				num3 = (int) variables.get(variable[1]);
			} catch (Exception e) {
		 		num3 = 0xffff;
			}

			if(variable[0].contains("-")){
				sum = calculateMinus(sum, num3,  variable[2], variables);
			}
			if(variable[0].contains("+")){
				sum = calculatePlus(sum, num3, variable[2], variables);
			}
		}
		//System.out.println(string1 + string2);
		return sum;
	}

	public static int calc(String name, HashMap<String, Integer> variables){
    	String[] variable  = name.split(" ", 4);
		int sum = 0;
		int num1 = 0,num2 = 0;
		try {
			num1 = variables.get(variable[0]);
		} catch (Exception e) {
		 	num1 = 0xf;
		}
		try {
			num2 = variables.get(variable[2]);
		} catch (Exception e) {
			num2 = 0xf;
		}
		//System.out.println("nummer1:" + num1);
		//System.out.println("nummer2:" + num2);
		
		if (variable[1].contains("+")){
			sum = calculatePlus(num1, num2, variable[3], variables);
		}
		if (variable[1].contains("-")){
			sum = calculateMinus(num1, num2, variable[3], variables);
		}
		if (variable[1].contains("=")){
			sum = num1;
		}
		return sum;
	}

	public static String[] def(String name){
		String[] variable = name.split(" ", 2);
		//int var = (int) variable[1].charAt(0);
		//System.out.println(variable[0]);
		//System.out.println(variable[1]);
		return variable;
    }

    public static void main(String[] args) throws FileNotFoundException{
		Scanner myObj = new Scanner(System.in);
		//Scanner myObj = new Scanner(new File( "sample.in"));

		String sentence2;
		int sentence3;
		String[] var;
		int i=1;
		HashMap<String, Integer> variables = new HashMap<String, Integer>();
		HashMap<Integer, String> backvariables = new HashMap<Integer, String>();

		//System.out.println("Enter the string:");

	    // String input
    	String sentence;
		
		while(myObj.hasNext())
		{
			sentence = myObj.next();
			//if (sentence.matches("^.*[^+-=a-z0-9 ].*$") == true){break;}
	   		//System.out.println("only small letters and numbers are allowed")			}

			if (i++>=2000){break;}
			if(sentence.contains("clear")){
				variables = new HashMap<String, Integer>();
				backvariables = new HashMap<Integer, String>();

			}
			if(sentence.contains("def")) {
				sentence2 = myObj.next();
				int value = myObj.nextInt();
				if (value < -1000 || value > 1000){}
				else{
					if (sentence2.matches("^.*[^a-z ].*$")) {}
					else{
					//if(sentence3[1].length()>=30){myObj.close();return;}
					if (sentence2.matches("unknown")) {}
					else {
					if (variables.size() == 0) {
						variables.put(sentence2, value);
						backvariables.put(value, sentence2);
					} else {
						backvariables.remove(variables.get(sentence2));
						variables.remove(sentence2);
						variables.put(sentence2, value);
						backvariables.put(value, sentence2);
						}
						}
					}
				}
			}
			if(sentence.contains("calc")){
				string1 = myObj.nextLine() ;
				string1 = string1.trim() + " ";
				//string1 = sentence2[1] + " ";
				String[] ar= string1.split(" ");
				//System.out.println(ar.length / 2);
				if((ar.length / 2) > 15 ){}
				else {
				if(variables.size()!=0) {
					int sum = calc(string1, variables);
					if(backvariables.get(sum) == null){
						string3 = "unknown";
					}else {
						string3 = backvariables.get(sum);

					}
				} else {
					string3 = ("unknown");
				}
				System.out.println(string1 + string3);
				string1 = "";
				string2 = "";
				string3	= "";		
			}
			}

    	}
		myObj.close();
		//for (String a : sentence2){
	    //	System.out.println(a);	
		//}			
	}
	
}
