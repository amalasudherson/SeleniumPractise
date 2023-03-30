package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	
	public int getRandomnum()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}

}
