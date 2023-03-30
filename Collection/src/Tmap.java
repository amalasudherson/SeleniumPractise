import java.util.Map;
import java.util.TreeMap;

public class Tmap
{
	public static void main (String[] args)
	{
		Map m=new TreeMap();
				m.put("1m", "Kavith");
				m.put("3m", "Anitha");
			//	m.put(null,"Renuka");
				m.put("4s", null);
				m.put("5s", "Kavith");
				System.out.println(m);
	}
}
