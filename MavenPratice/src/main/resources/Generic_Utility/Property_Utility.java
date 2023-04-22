package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {

	/**
	 * This method is used to Launch the Application
	 * 
	 * @paramkey
	 * @return
	 * @throws Throwable
	 * @author Amala
	 */
	public String getKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\AmalaS\\Documents\\SeleniumRepo\\SeleniumFrameWork2\\src\\test\\resources\\propertyFileData.properties");
	
		Properties pro = new Properties();
		pro.load(fis);
		String Value = pro.getProperty(key);
		return Value;

	}
}
