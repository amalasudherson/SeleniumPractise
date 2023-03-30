import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class H1 
{
	 public static void main (String[] args)
	    {
	        Scanner s=new Scanner(System.in);
	        Set sn=new HashSet();

	        System.out.println("Enter 3 Integer values:");
	        sn.add(s.nextInt());
	        sn.add(s.nextInt());
	        sn.add(s.nextInt());
	        System.out.println(sn);
	    }
}
