import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Innovationm.login.page.LoginPage;
import com.aventstack.extentreports.Status;
import com.vtiger.utility.Utility;

public class checkingtestng {
protected Utility webUtil;
@BeforeSuite
public void tearUp() {
	webUtil = new Utility();
	webUtil.initHtmlReprots();
}


@BeforeMethod(alwaysRun = true)
public void beforeTestCase(Method tm) throws IOException {
	String tmName = tm.getName();

	webUtil.setExtentLogger(tmName);

	String brName =webUtil.getProObj().getProperty("BrowserName");

	webUtil.Launchbrowser(brName);
	
	LoginPage loginPage = new LoginPage(webUtil);
	loginPage.validLogin();
}



@AfterSuite
public void tearDown() {
	webUtil.flushReport();
}
}

	

