package com.Innvationm.vtiger.home.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.Innovationm.vtiger.or.home.OR_Home;
import com.vtiger.utility.Utility;

public class HomePage extends OR_Home{
private Utility webUtil;

public HomePage(Utility webUtil) {
	this.webUtil=webUtil;
	PageFactory.initElements(webUtil.getDriver(), this);

}

public void mouseOverOnMarketing() {
	
webUtil.selectedElementWait(marketing, 50);
	webUtil.ActionsMouseOver(marketing);
	
}
	
public void goToMarketinglead() {
	mouseOverOnMarketing();
	webUtil.click(marketingLeads);
	
}
	public void gotoMarketingAccounting(){
		mouseOverOnMarketing();
		webUtil.click(marketingAccount);
	}
	public void gotoMarkettingcompaign() {
		mouseOverOnMarketing();
		webUtil.click(marketingCompaign);
		
	}
	
	public void mouserhoveronSales() {
		webUtil.ActionsMouseOver(sales);
	}
	
	public void gotoSalesInvoice() {
		mouserhoveronSales();
		webUtil.click(saleInvoice);
		
	}

	public void GotoMarketiingDocument() {
		mouseOverOnMarketing();
		webUtil.click(marketingDocuments);
		
	}
	
	
}
