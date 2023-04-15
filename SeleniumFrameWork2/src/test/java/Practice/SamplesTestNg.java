package Practice;

import org.testng.annotations.Test;

//@Test
public class SamplesTestNg {

	//@Test
	@Test(priority = 2)
	public void createContact()
	
	{
		System.out.println("Contact create");
	}
	//@Test
	@Test(priority = 1)
	public void modifyContact()
	{
		System.out.println("modify Contact");
	}
	@Test(priority = 3)
	public void deleteContact()
	{
		System.out.println("deleteContact");
	}
}
