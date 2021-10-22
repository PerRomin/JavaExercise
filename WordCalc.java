import java.util.Scanner;
import java.util.HashMap;


public class WordCalc {
	public static String string1= new String(""),string2=new String(""),string3=new String("");

	public static int calculateMinus(int num1, int num2, String name, HashMap<String, Integer> variables){
		int sum, num3;
		String[] variable  = name.split(" ", 3);
		sum = num1 - num2;
		//string1 = (string1 + string2);
		if (name.startsWith("=")==false){
			try {
				num3 = (int) variables.get(variable[1]);

				if(variable[0].contains("-")){
					sum = calculateMinus(sum, num3, variable[2], variables);
				}
				if(variable[0].contains("+")){
					sum = calculatePlus(sum, num3, variable[2], variables);
				}
			} catch (Exception e) {
				sum = 0xffff;
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

				if(variable[0].contains("-")){
					sum = calculateMinus(sum, num3,  variable[2], variables);
				}
				if(variable[0].contains("+")){
					sum = calculatePlus(sum, num3, variable[2], variables);
				}
			} catch (Exception e) {
				sum = 0xffff;
			}
		}
		//System.err.println(string1 + string2);
		return sum;
	}

	public static int calc(String name, HashMap<String, Integer> variables){
    	String[] variable  = name.split(" ", 4);
		int sum = 0;
		int num1,num2;
		try {
			num1 = variables.get(variable[0]);
			try {
				num2 = variables.get(variable[2]);
			//System.err.println("nummer1:" + num1);
			//System.err.println("nummer2:" + num2);

				if (variable[1].contains("+")){
					sum = calculatePlus(num1, num2, variable[3], variables);
				}
				if (variable[1].contains("-")){
					sum = calculateMinus(num1, num2, variable[3], variables);
				}
				if (variable[1].contains("=")){
				sum = num1;
				}
			} catch (Exception e) {
				sum = 0xffff;
			}
		} catch (Exception e) {
			sum = 0xffff;
		}
		return sum;
	}

    public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);

		String sentence2;
		HashMap<String, Integer> variables = new HashMap<String, Integer>();
		HashMap<Integer, String> backvariables = new HashMap<Integer, String>();

    	String sentence;

		while(myObj.hasNext())
		{
			sentence = myObj.next();
			if(sentence.contains("clear")){
				variables = new HashMap<String, Integer>();
				backvariables = new HashMap<Integer, String>();

			}
			if(sentence.contains("def")) {
				sentence2 = myObj.next();
				try {
					int value = myObj.nextInt();
					if (variables.size() == 0) {
						variables.put(sentence2, value);
						backvariables.put(value, sentence2);
					} else {
						backvariables.remove(variables.get(sentence2));
						variables.remove(sentence2);
						variables.put(sentence2, value);
						backvariables.put(value, sentence2);
					}
				} catch (Exception e) {
					;
				}

			}

			if(sentence.contains("calc")){
				string1 = myObj.nextLine() ;
				string1 = string1.trim();
				if (string1.startsWith("=")){
					System.out.println("unknown");
				} else {
				if(variables.size()!=0) {
					int sum = calc(string1, variables);
						if(backvariables.get(sum) == null){
							if(string1.isEmpty()){
								System.out.println("unknown");
							}else {
								System.out.println(string1 + " " + "unknown");
							}
						}else {
							string3 = backvariables.get(sum);
							System.out.println(string1 + " " + string3);
						}
					} else {
					System.out.println("unknown");
					}

				}
				string1 = "";
				string2 = "";
				string3	= "";
			}
    	}
		myObj.close();
	}
}
