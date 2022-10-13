package com.Innovationm.testrunner.marketing;

import java.io.IOException;
import java.util.Map;

import com.Innovationm.login.page.LoginPage;
import com.Innovationm.vtiger.marketing.leads.pages.EditLead;
import com.Innvationm.vtiger.home.page.HomePage;
import com.vtiger.utility.Utility;

import excelUtility.ExcelDataUtil;

public class ValidateEditLead {
	private static Utility webUtil;
	private static ExcelDataUtil exceldata; 

	public static void main(String[] args) throws IOException {
		 webUtil=new Utility();
webUtil.initHtmlReprots();
webUtil.setExtentLogger("tccase 420 shamashnpur");
		loginwithvaliddata();
		editLead();
webUtil.flushReport();
	}

	public static void loginwithvaliddata() {
		 webUtil=new Utility();
		 exceldata=new  ExcelDataUtil();
		webUtil.Launchbrowser("Chrome");
		webUtil.openURL("http://localhost:8888/");
	}

	public static void editLead() throws IOException {
		LoginPage loginPage =new LoginPage(webUtil);
		loginPage.validLogin();
		HomePage home_Pg =new HomePage(webUtil);
			home_Pg.goToMarketinglead();
Map<String ,String >exceldatamap=exceldata.getTestcase("C:\\Users\\dell\\eclipse-workspace\\java workspace\\BetaBatch\\automation", "TCID_004To_validate_the EditingfunctionlaityofmarkettingLead"
) ;        
         EditLead editlead= new EditLead(webUtil,exceldatamap);
         editlead.editLead();
         
         
         
	}

}
//////// Date  ka generic method banakar date include karana hai
