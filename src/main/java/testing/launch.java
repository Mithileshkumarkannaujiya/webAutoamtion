package testing;

import java.util.Date;

import com.vtiger.utility.Utility;

public class launch {
public static void main(String[] args) {
	  Utility mk=new Utility();
	 mk.Launchbrowser("IE");

		
	
	Date date=new Date();
	String currentdate=date.toString().replace(" ", "-").replace(":", "");
	System.out.println(currentdate);
			

}
}
