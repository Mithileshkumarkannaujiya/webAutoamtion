import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.Innovationm.vtiger.marketing.leads.pages.CreateLead;
import com.Innvationm.vtiger.home.page.HomePage;
import com.vtiger.utility.BaseClass;

public class TestCases extends BaseClass {

	@Test
	public void validate() {
		HomePage home_Pg =new HomePage(webUtil);
		home_Pg.goToMarketinglead();
	Map<String, String> excelDataMap = null;
	try {
		excelDataMap = excelData.getTestcase("src\\test\\resources\\data\\VtigerTestCase.xlsx", "TCID_002ValidateCreatenewMarketingLead");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		CreateLead lead =new CreateLead(webUtil,excelDataMap);
		lead.CreateNewMarketingLead();
    
	}
}
