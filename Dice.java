import java.util.Scanner;
public class Dice
{
 
    public static void Dice(int a[])
    {
        int n=a.length,i, medelv, skillnad,from;
	    medelv = (2 + a[0] + a[1])/2;
	    skillnad = Math.abs(a[0]-a[1]);
        from=medelv - skillnad/2;
	    for (i=0;i<=skillnad;i++){
	        a[i]=from + i;
            a[i+1] = 0;
	    }
    }
    public static void printarray(int a[])
    {
        for(int i=0; (i < a.length ) && !(a[i] == 0); i++)
        {
        System.out.print(a[i]+"\n");
        }
    }
    public static void main(String[] args)
    {
        int n,  i;
        Scanner s = new Scanner(System.in);
        System.out.print("Skriv in antal �gon p� f�rsta t�rningen:\n");

        int a[] = new int[200];
        a[0] = s.nextInt();
        System.out.println("f�rsta t�rningen "+a[0]+ ":");
        System.out.println("\nSkriv in antal �gon p� andra t�rningen:");
        a[1] = s.nextInt();
        System.out.println("andra t�rningen "+a[1]+ ":");
        Dice(a);
        //ISort(a);
        System.out.println( "\nsumman som �r mest sannolik ");
        printarray(a);
    }
}
