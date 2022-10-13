package com.Innovationm.testrunner.marketing;

import com.Innovationm.login.page.LoginPage;
import com.Innovationm.vtiger.marketing.pages.CreateCompaign;
import com.Innvationm.vtiger.home.page.HomePage;
import com.vtiger.utility.Utility;

public class ValidateCompaignLead {
	private static Utility webUtil;

	public static void main(String[] args) {


		
		loginwithValidData();
		CreatenewCmpgnLead();
      
		//webUtil.flushReport();
	}

	public static void loginwithValidData() {
		webUtil = new Utility();
		webUtil.Launchbrowser("Chrome");
		webUtil.openURL("http://localhost:8888/");
	}

	public static void CreatenewCmpgnLead() {
		LoginPage loginPg = new LoginPage(webUtil);
		loginPg.validLogin();
		HomePage home_Pg = new HomePage(webUtil);
		home_Pg.gotoMarkettingcompaign();
		CreateCompaign createcompaign = new CreateCompaign(webUtil);
		createcompaign.createCompaignLead();

	}

}
