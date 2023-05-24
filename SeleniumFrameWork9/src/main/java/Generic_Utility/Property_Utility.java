package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility 
{
	/**
	 *  This method is used to launch the Application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author AmalaS
	 */
	public String getKeyValue(String Key) throws Throwable
	{
	
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String Value = pro.getProperty(Key);
		return Value;
	}
	

}
