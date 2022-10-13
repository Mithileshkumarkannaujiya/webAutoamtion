package com.Innovationm.vtiger.marketing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class CreateAccountLead {
	private Utility webUtil;

	public CreateAccountLead(Utility webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//img[@alt='Create Account...']")
	private WebElement createLead;

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement accountName;

	@FindBy(xpath = "//input[@name='website']")
	private WebElement websiteName;

	@FindBy(xpath = "//input[@name='tickersymbol']")
	private WebElement tickerSymbol;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNo;

	@FindBy(xpath = "//input[@id='fax']")
	private WebElement faxNo;

	@FindBy(xpath = "//input[@id='email1']")
	private WebElement emailId;

	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billingAddress;

	@FindBy(xpath = "//input[@name='bill_pobox']")
	private WebElement billingPoBx;

	@FindBy(xpath = "//input[@name='bill_city']")
	private WebElement billingCity;

	@FindBy(xpath = "//input[@name='bill_state']")
	private WebElement billingState;

	@FindBy(xpath = "//input[@name='bill_code']")
	private WebElement postalCode;

	@FindBy(xpath = "//input[@name='bill_country']")
	private WebElement billingCountry;

	@FindBy(xpath = "//b[text()='Copy Billing address']//preceding-sibling::input")
	private WebElement cpyBillingAddress;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;

	@FindBy(xpath = "//textarea[@name='description']//parent::td//parent::tr//following-sibling::tr//td//div//input[@class='crmbutton small save']")
	private WebElement saveButton;

	public void CreateAccountLead() {
	webUtil.click(createLead);
	//	webUtil.actionClick(createLead);
		webUtil.input(accountName, "Mangesh Bhai");
		webUtil.input(websiteName, "www.pagalpanthi.com");
		webUtil.input(tickerSymbol, "S");
		webUtil.input(phoneNo, "89583495");
		webUtil.input(faxNo, "45643564");
		webUtil.input(emailId, "Rajaji@gmail.com");
		webUtil.input(billingAddress, "GoregavCity");
		webUtil.input(billingPoBx, "rampura");
		webUtil.input(billingCity, "rajpur");
		webUtil.input(billingState, "AndhraPradesh");
		webUtil.input(postalCode, "4523");
		webUtil.input(billingCountry, "India");
		webUtil.click(cpyBillingAddress);
		webUtil.click(saveButton);
	}
}