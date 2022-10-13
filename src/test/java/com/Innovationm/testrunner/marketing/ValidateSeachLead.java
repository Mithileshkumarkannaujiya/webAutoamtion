package com.Innovationm.testrunner.marketing;

import com.Innovationm.login.page.LoginPage;
import com.Innovationm.vtiger.marketing.leads.pages.SearchLeadByName;
import com.Innvationm.vtiger.home.page.HomePage;
import com.vtiger.utility.Utility;

public class ValidateSeachLead {

public static void main(String[] args) {
Utility webUtil =new Utility();
webUtil.Launchbrowser("Chrome");
webUtil.openURL("http://localhost:8888/");	
LoginPage loginPage =new LoginPage(webUtil);
loginPage.validLogin();
searchLeadByName(webUtil);	
	
}

public static void searchLeadByName(Utility webUtil) {
	HomePage  home_Page =new HomePage(webUtil);
	home_Page.goToMarketinglead();
	SearchLeadByName searchLead =new SearchLeadByName(webUtil);
	searchLead.searchLead();
	
}
	
	
	
}
