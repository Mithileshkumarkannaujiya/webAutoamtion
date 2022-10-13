package com.Innovationm.vtige.testRuner.sales;

import com.Innovationm.login.page.LoginPage;
import com.Innovationm.vtiger.sales.pages.CreateSalesInvoice;
import com.Innvationm.vtiger.home.page.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vtiger.utility.Utility;

public class ValidateInvoice {
private static Utility webUtil;
public static void main(String[] args) {
	
	
	ValidateInvoice invoicePg=new ValidateInvoice();
	webUtil=new  Utility();
webUtil.initHtmlReprots();
webUtil.setExtentLogger("test Case Id_001");
	
		invoicePg.loginWithvalidData();
		invoicePg.CreateInvoice();
webUtil.flushReport();
}

public void loginWithvalidData() {
	webUtil=new  Utility();
	
	webUtil.Launchbrowser("Chrome");
	webUtil.openURL("http://localhost:8888/");
	
}
public  void CreateInvoice(){
	LoginPage loginPg = new LoginPage(webUtil);
	loginPg.validLogin();
	HomePage home_Pg = new HomePage(webUtil);
	home_Pg.gotoSalesInvoice();
	CreateSalesInvoice invoice=new CreateSalesInvoice(webUtil);
	invoice.createInvoiceLead();
	loginPg.signOut();
	}

}
