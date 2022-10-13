package com.Innovationm.testrunner.marketing;

import java.io.IOException;
import java.util.Map;

import com.Innovationm.login.page.LoginPage;
import com.Innovationm.vtiger.marketing.leads.pages.CreateLead;
import com.Innvationm.vtiger.home.page.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vtiger.utility.Utility;

import excelUtility.ExcelDataUtil;

public class ValidateCreateNewLead {
	private static Utility webUtil;
	private static ExcelDataUtil excelData;

	public static void main(String[] args) throws IOException {

	 
		loginwithValidData();
		createNewLead();
	}
	
	public static void loginwithValidData() {
		webUtil	=	new Utility();
		excelData=new ExcelDataUtil();
		String browserName=webUtil.getProObj().getProperty("BrowserName");
		webUtil.Launchbrowser(browserName);
		String url=webUtil.getProObj().getProperty("Url");
		webUtil.openURL(url);
	}
	
	public static void createNewLead() throws IOException {
	
	LoginPage loginPage =new LoginPage(webUtil);
	loginPage.validLogin();
	HomePage home_Pg =new HomePage(webUtil);
		home_Pg.goToMarketinglead();
	Map<String, String> excelDataMap=	excelData.getTestcase("src\\test\\resources\\data\\VtigerTestCase.xlsx", "TCID_002ValidateCreatenewMarketingLead");
		CreateLead lead =new CreateLead(webUtil,excelDataMap);
		lead.CreateNewMarketingLead();
         	
		}
	           
   
}
