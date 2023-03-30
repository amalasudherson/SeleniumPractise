import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class H2 
{
	public static void main (String[] args)
	{
        Set s = new HashSet();
        s.add(34);
        s.add(23);
        s.add("Virat");
        s.add("hardik");
        s.add('m');
        s.add('k');
        s.add(null);
        s.add(34);
        System.out.println(s);
        
        

        System.out.println("*****Accessing with the help of iterator******");
        //Creat an insantance of Iterator
        Iterator i = s.iterator();
        //using iterator reference call the methods
        while(i.hasNext() == true)
        {
            System.out.println(i.next());
        }
        
        
       
    }


}
