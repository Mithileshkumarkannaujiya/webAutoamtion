package com.vtiger.utility;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Innovationm.login.page.LoginPage;

import excelUtility.ExcelDataUtil;

public class BaseClass {
	protected Utility webUtil;
	protected ExcelDataUtil excelData;

	@BeforeClass
	public void openVtigerwithGeneric() {
		webUtil = new Utility();
		webUtil.initHtmlReprots();
		webUtil.setExtentLogger("Windows");
		
		String browserName = webUtil.getProObj().getProperty("BrowserName");
		webUtil.Launchbrowser(browserName);
		String url = webUtil.getProObj().getProperty("Url");
		webUtil.openURL(url);
		webUtil.maximizeWondow();

	}

	@BeforeMethod
	public void loginMethod(Method method) {
		excelData = new ExcelDataUtil();
		String tcName = method.getName();
		webUtil.setExtentLogger(tcName);

      LoginPage	loginPage = new LoginPage(webUtil);
		loginPage.validLogin();
	}


	@AfterMethod
	public void logOut() {

  LoginPage loginPage = new LoginPage(webUtil);
	//	loginPage.signOut();

		webUtil.flushReport();

	}

	@AfterSuite
	public void flush() {
		webUtil.flushReport();
	}

}
