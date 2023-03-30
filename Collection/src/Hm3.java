

import java.util.HashMap;
import java.util.Map;

public class Hm3
{
	public static void main (String[] args) 
	{
		Map<String> m=new HashMap();
		m.put(1, "Sushma");
		m.put(2, "Soujanya");
		System.out.println(m.get(2));
		System.out.println(m.values());
		System.out.println(m.KeySet());
		System.out.println(m.entrySet());
	}
}
