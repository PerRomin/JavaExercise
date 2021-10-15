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
		try {
			num3 = (int) variables.get(variable[1]);
		} catch (Exception e) {
		 	num3 = 0xffff;
		}
		//string1 = (string1 + string2);
		if (name.startsWith("=")==false){
			
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
		try {
			num3 = (int) variables.get(variable[1]);
		} catch (Exception e) {
		 	num3 = 0xffff;
		}
		//string1 = (string1 + string2);
		if (name.startsWith("=")==false){
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
			num1 = (int) variables.get(variable[0]);
		} catch (Exception e) {
		 	num1 = 0xf;
		}
		try {
			num2 = (int) variables.get(variable[2]);			
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
		return sum;
	}

	public static String[] def(String name){
		String[] variable = name.split(" ", 2);
		//int var = (int) variable[1].charAt(0);
		//System.out.println(variable[0]);
		//System.out.println(variable[1]);
		return variable;
    }

    public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		String[] sentence2;
		String[] sentence3;
		String[] var;
		int i=1;
		HashMap<String, Integer> variables = new HashMap<String, Integer>();
		
    	//System.out.println("Enter the string:");

	    // String input
    	String sentence = myObj.nextLine();
		
		if (sentence.matches("^.*[^+-=a-z0-9 ].*$") == true){
	   		//System.out.println("only space to tilde are allowed");
			return;
    	}
		if (sentence.length() > 400 || sentence.length() < 1){
			//System.out.println("wrong length");
			return;
		}
 	   // Output input by user
		sentence2 = sentence.split(" ", 2);
		while(myObj.hasNextLine())
		{
			sentence = myObj.nextLine();
			if (sentence.matches("^.*[^+-=a-z0-9 ].*$") == true){
	   		//System.out.println("only small letters and numbers are allowed");
				return;
			}
			sentence2 = sentence.split(" ", 2);
			//if(sentence2[1].length()>=300){return;}

			if (i++>=2000){return;}
			if(sentence2[0].contains("clear")){
				variables = new HashMap<String, Integer>();
			}
			if(sentence2[0].contains("def")){
				sentence3 = sentence.split(" ", 3);
				if (sentence3[1].matches("^.*[^a-z ].*$") == true){return;}
				if (sentence3[2].matches("^.*[^0-9 ].*$") == true){return;}
				if(sentence3[1].length()>=30){return;}
				if(sentence3[1].matches("unknown")){return;}
				var = def(sentence2[1]);
				int value = Integer.valueOf(var[1]);
				if (value < -1000 || value > 1000){return;}
				if(variables.size()==0) {
					variables.put(var[0], value );
				}else{
					boolean flag=false;
					for(Entry<String, Integer> entry: variables.entrySet()) {
		  			// if give value is equal to value from entry
      				// print the corresponding key
					if(entry.getValue() == value) {
						flag=true;
						break;
		  			}
				}
				if (flag==false){						
					variables.put(var[0], value );
				}
			}
			}
			if(sentence2[0].contains("calc")){
				string1 = sentence2[1] + " ";
				if(variables.size()!=0) {
					int sum = calc(sentence2[1], variables);
					for(Entry<String, Integer> entry: variables.entrySet()) {
		  			// if give value is equal to value from entry
      				// print the corresponding key
						if(entry.getValue() == sum) {
        					string3 = (entry.getKey());
    	   		 			break;
    		  			}else{
    						string3 = ("unknown");
						}
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
		//for (String a : sentence2){
	    //	System.out.println(a);	
		//}			
	}
	
}
