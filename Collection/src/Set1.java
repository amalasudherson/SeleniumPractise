import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set1 {
    public static void main (String[] args)
    {
        Set s=new HashSet();
        s.add("Apple");
        s.add("Mango");
        s.add("Cherry");
        System.out.println(s);
        Iterator i=s.iterator();
        while(i.hasNext()==true)
        {
        	System.out.println(i.next());
        }
      
		}
}
   



	


