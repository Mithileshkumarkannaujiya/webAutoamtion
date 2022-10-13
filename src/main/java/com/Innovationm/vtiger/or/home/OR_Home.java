package com.Innovationm.vtiger.or.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Innovationm.vtiger.or.common.ORCommon;

public class OR_Home extends ORCommon {

	@FindBy(xpath = "//div[@id='Marketing_sub']//descendant::td//a[text()='Campaigns']")
	protected WebElement marketingCompaign;

	@FindBy(xpath = "//div[@id='Marketing_sub']//descendant::td//a[text()='Accounts']")
	protected WebElement marketingAccount;

	@FindBy(xpath = "//div[@id='Marketing_sub']//descendant::td//a[text()='Contacts']")
	protected WebElement marketingContacts;

	@FindBy(xpath = "//div[@id='Marketing_sub']//descendant::td//a[text()='Webmail']")
	protected WebElement marketingWebmail;

	@FindBy(xpath = "//div[@id='Marketing_sub']//descendant::td//a[text()='Leads']")
	protected WebElement marketingLeads;

	@FindBy(xpath = "//div[@id='Marketing_sub']//descendant::td//a[text()='Calendar']")
	protected WebElement marketingCalender;

	@FindBy(xpath = "//div[@id='Marketing_sub']//descendant::td//a[text()='Documents']")
	protected WebElement marketingDocuments;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Leads']")
	protected WebElement saleLead;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Accounts']")
	protected WebElement saleAccount;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Contacts']")
	protected WebElement saleContact;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Potentials']")
	protected WebElement salePotential;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Quotes']")
	protected WebElement saleQuotes;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Sales Order']")
	protected WebElement saleSalesOrder;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Invoice']")
	protected WebElement saleInvoice;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Price Books']")
	protected WebElement salePriceBook;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Documents']")
	protected WebElement saleDocument;

	@FindBy(xpath = "//div[@id='Sales_sub']//descendant::a[text()='Calendar']")
	protected WebElement saleCalender;
	

	
}
