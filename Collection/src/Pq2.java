import java.util.PriorityQueue;
import java.util.Queue;

public class Pq2 
{
  public static void main (String[] args)
  {
	  Queue q= new  PriorityQueue();
      q.add("virat");
      q.add("Rahul");
      q.add("Hardik");
      System.out.println(q);
      System.out.println(q.isEmpty());
      System.out.println(q.size());
      System.out.println(q.remove());
      System.out.println("After removing head"+q);
      System.out.println("head of the element");
      System.out.println(q.peek());
      System.out.println(q.isEmpty());
      System.out.println(q.element());
      System.out.println(q.poll());
  }
}
