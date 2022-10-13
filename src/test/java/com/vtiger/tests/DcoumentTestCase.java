package com.vtiger.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.Innovatoin.Vtiger.Marketting.Document.Pages.CreateMarkettingdocuments;
import com.Innvationm.vtiger.home.page.HomePage;
import com.vtiger.utility.BaseClass;

public class DcoumentTestCase extends BaseClass {

	@Test
	public void validateTestCase() throws IOException {
	
	HomePage home_pg=new HomePage(webUtil);
	home_pg.GotoMarketiingDocument();
	
	
	Map<String ,String > excelDataMap=excelData.getTestcase("src\\test\\resources\\data\\VtigerTestCase.xlsx", "TCID_007 Validate_the_functionality_of_Creating_marketting_Documents");
	CreateMarkettingdocuments documentsLeads=new CreateMarkettingdocuments(webUtil, excelDataMap);
	documentsLeads.createNewDocument();
	
	
	
}
	
	
}
