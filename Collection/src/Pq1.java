
import java.util.PriorityQueue;
import java.util.Queue;


public class Pq1 
{
	public static void main(String[] args)
    {
	    Queue q= new  PriorityQueue();
	    q.add("Amala");
	    q.add("YYY Book");
	    q.add("Tamil");
	    q.add("ss plan");
      System.out.println(q);
      System.out.println(q.remove());
      System.out.println(q);
      System.out.println(q.peek());
      System.out.println(q.element());
       
      
    }
}

