import java.util.Scanner;
public class Backwards
{
 
    public static void Backwards(int a[])
    {
        int n=a.length,i,temp;
        for (i = 1;i <= n/2; i++)
        {
            temp = a[i - 1];
            a[i - 1] = a[n - i];
            a[n - i] = temp;

        }
    }
    public static void printarray(int a[])
    {
        for(int i=0; i < a.length; i++)
        {
        System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        int n,  i;
        Scanner s = new Scanner(System.in);
        System.out.print("Skriv in antal element i \"arrayen\":");

        n = s.nextInt();
        int a[] = new int[n];
        System.out.println("Skriv in "+n+" element ");
        for( i=0; i < n; i++)
        {
            a[i] = s.nextInt();
        }
        System.out.println( "elementen i \"arrayen\" ");
        printarray(a);
        Backwards(a);
        System.out.println( "\nelementen baklänges");
        printarray(a);
    }
}
