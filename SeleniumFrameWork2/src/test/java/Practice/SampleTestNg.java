package Practice;

import org.testng.annotations.Test;

public class SampleTestNg {

	// @Test(dependsOnMethods = "ContactCreated" )
	@Test(invocationCount = 3)
	public void createContact() {
		// int[] arr= {0,1,2,3};
		// System.out.println(arr[5]);
		System.out.println("Contact Created");
	}

	// @Test(dependsOnMethods = "ContactCreated" )
	public void modifyCondact() {
		System.out.println("modified Contact");
	}

//@Test(dependsOnMethods = "ContactCreated" )
	public void deleteContact() {
		System.out.println("delete Contact");
	}

}
