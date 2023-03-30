import java.util.HashMap;
import java.util.Map;

public class Hm2 {
	public static void main(String[] args)
	{
		Map m=new HashMap();
		m.put("mala", 89);
		m.put("Avi", 56);
		
		Map m1=new HashMap();
		m1.put("Rahul", 34);
		m1.put("Ramesh", 75);
		m1.putAll(m);
		System.out.println(m1);
		System.out.println(m.containsKey("mala"));
		System.out.println(m1.containsValue(90));
		System.out.println(m1.remove("Ramesh"));
		System.out.println(m1);
	}

}
