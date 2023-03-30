import java.util.HashMap;
import java.util.Map;

public class Pack1 {
	public static void main(String[] args)
	{
		Map m1=new HashMap();
		m1.put(1,"Virat");
		m1.put(2,"Anushka");
		m1.put(3,"Anushka");
		//System.out.println(m1);
		m1.put(3,"Rahul");
		m1.put(4, '@');
		m1.put(5, 23);
		m1.put(6, null);
		m1.put(null, "Sow");
		//m1.put(null, 10);
;		System.out.println(m1);
		
	}
}
