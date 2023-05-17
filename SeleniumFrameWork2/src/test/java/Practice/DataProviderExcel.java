package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;

public class DataProviderExcel {
	
	

	private int j;
	@Test(dataProvider = "getData")
	public void readData(String from,String to) {
		System.out.println(from+"------"+to);
	}
@DataProvider
	public Object[][] getData() throws Throwable
	{
		Object[][] objarr=new Object[3][2];
		Excel_Utility elib=new Excel_Utility();
		
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<2;j++);
			{
				objarr[i][j] =elib.getExcelData("DataProvider", i,j);
			}
		}
		return objarr;
	}
}
