package Practice;

import org.testng.annotations.Test;

public class SampleTestNG {

	@Test(invocationCount = 3)
	// (dependsOnMethods = "condactCreated ")
	// (priority = 3)
	public void createCondact() {
		// int[] arr = { 0, 1, 2, 3 };
		// System.out.println(arr[5]);
		System.out.println("condact created");

	}

	@Test
	// (dependsOnMethods = "condactCreated ")
	// (priority = 1)
	public void modifyconact() {
		System.out.println("modified conact");

	}

	@Test
	// (dependsOnMethods = "condactCreated ")
	// (priority = 2)
	public void deleteCondact() {
		System.out.println("delete Condact");
	}
}
