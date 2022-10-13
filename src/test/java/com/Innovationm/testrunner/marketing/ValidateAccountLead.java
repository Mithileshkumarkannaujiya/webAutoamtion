package com.Innovationm.testrunner.marketing;

import com.Innovationm.login.page.LoginPage;
import com.Innovationm.vtiger.marketing.pages.CreateAccountLead;
import com.Innvationm.vtiger.home.page.HomePage;
import com.vtiger.utility.Utility;

public class ValidateAccountLead {
	private static Utility webUtil;
	public static void main(String[] args) {
		webUtil = new Utility();
		webUtil.initHtmlReprots();
		webUtil.setExtentLogger("test case id 001");
		loginWithValidData();
		createNewLead();
		webUtil.flushReport();
	}
	public static void loginWithValidData() {
		webUtil = new Utility();
		webUtil.Launchbrowser("Chrome");
		webUtil.openURL("http://localhost:8888/");
	}
	public static void createNewLead() {
		LoginPage loginPage = new LoginPage(webUtil);
		loginPage.validLogin();

		HomePage homeP_g = new HomePage(webUtil);
		homeP_g.gotoMarketingAccounting();
		CreateAccountLead accoutingLead = new CreateAccountLead(webUtil);
		accoutingLead.CreateAccountLead();
	}
}
