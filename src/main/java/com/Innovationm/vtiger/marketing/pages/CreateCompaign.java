package com.Innovationm.vtiger.marketing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class CreateCompaign {
	private Utility webUtil;

	public CreateCompaign(Utility webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCompgn;

	@FindBy(name = "campaignname")
	private WebElement cmpgnName;

	@FindBy(name = "campaigntype")
	private WebElement cmpgnType;

	@FindBy(name = "targetaudience")
	private WebElement tagetAudience;

	@FindBy(name = "sponsor")
	private WebElement sponser;

	@FindBy(name = "numsent")
	private WebElement numset;

	@FindBy(name = "campaignstatus")
	private WebElement cpmgnstatus;

	@FindBy(name = "targetsize")
	private WebElement targetsize;

	@FindBy(name = "budgetcost")
	private WebElement budgetcost;

	@FindBy(xpath = "//select[@name='expectedresponse']")
	private WebElement expResponse;

	@FindBy(xpath = "//input[@name='expectedsalescount']")
	private WebElement expsales;

	@FindBy(xpath = "//input[@name='expectedresponsecount']")
	private WebElement expResponseCoount;

	@FindBy(xpath = "//input[@name='actualcost']")
	private WebElement actualcost;

	@FindBy(xpath = "//input[@name='expectedrevenue']")
	private WebElement expRevenue;

	@FindBy(xpath = "//input[@name='actualsalescount']")
	private WebElement acutalsalescoutn;

	@FindBy(xpath = "//input[@name='actualresponsecount']")
	private WebElement acutalresponsecount;

	@FindBy(xpath = "//input[@name='actualroi']")
	private WebElement actRoi;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;

	@FindBy(xpath = "//textarea[@name='description']//parent::td//parent::tr//following-sibling::tr//td//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public void createCompaignLead() {
		webUtil.click(createCompgn);
		webUtil.input(cmpgnName, "Sudhakar ");
		webUtil.selectByVisibleText(cmpgnType, "Conference");
		webUtil.input(tagetAudience, "Manish");
		webUtil.input(sponser, "raekshJi");
		webUtil.input(numset, "5564545");
		webUtil.selectByVisibleText(cpmgnstatus, "Active");
		webUtil.input(targetsize, "65443345");
		webUtil.input(budgetcost, "555765");
		webUtil.input(expResponseCoount, "5643446");
		webUtil.selectByVisibleText(expResponse, "Good");
		webUtil.input(expsales, "7563");
		webUtil.input(actualcost, "6345465");
		webUtil.input(expRevenue, "76345");
		webUtil.input(acutalsalescoutn, "40349");
		webUtil.input(acutalresponsecount, "850394583");
		webUtil.input(actRoi, "89383");
		webUtil.input(description, "Hi friends I am learning automation but not from the evs institte I am learning automation from myself with the help of manish who has been my student ");
		webUtil.click(saveButton);
	
	
	}

}
