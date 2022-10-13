package com.Innovationm.vtiger.marketing.leads.pages;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Innovationm.vtiger.or.home.OR_Home;
import com.Innvationm.vtiger.home.page.HomePage;
import com.vtiger.utility.Utility;

public class CreateLead {

	private Utility webUtil;
private Map<String,String> dataMap;
	public CreateLead(Utility webUtil,Map<String,String> dataMap) {
		this.webUtil = webUtil;
		this.dataMap=dataMap;
		PageFactory.initElements(webUtil.getDriver(), this);

		
	}

	@FindBy(xpath = "//a//img[@alt='Create Lead...']")
	private WebElement createLead;

	@FindBy(name = "salutationtype")
	private WebElement nameTitle;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='company']")
	private WebElement comapany;

	@FindBy(xpath = "//input[@name='designation']")
	private WebElement title;

	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement leadSource;

	@FindBy(xpath = "//select[@name='leadstatus']")
	private WebElement leadStatus;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phone;

	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mobile;

	@FindBy(xpath = "//input[@name='fax']")
	private WebElement fax;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement assignedTo;

	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement grouptype;

	@FindBy(xpath = "//textarea[@name='lane']")
	private WebElement street;

	@FindBy(xpath = "//input[@name='code']")
	private WebElement postalCode;

	@FindBy(xpath = "//input[@name='country']")
	private WebElement country;

	@FindBy(xpath = "//input[@name='pobox']")
	private WebElement poBox;

	@FindBy(xpath = "//input[@name='city']")
	private WebElement city;

	@FindBy(xpath = "//input[@name='state']")
	private WebElement state;

	@FindBy(xpath = "//input[@name='state']//parent::td//following::td//textarea[@class='detailedViewTextBox']")
	private WebElement description;

	@FindBy(xpath = "//textarea[@name='description']//parent::td//parent::tr//following-sibling::tr//td//div//input[@class='crmbutton small save']")
	private WebElement savebutton;
	//// input[@name='state']//parent::td//following::div//input[@title='Save
	//// [Alt+S]' and @name='button' and @type='submit' and @class='crmbutton small
	//// save' and @accesskey='S']

	public void CreateNewMarketingLead() {
		webUtil.click(createLead);
		String titleName =dataMap.get("Leadsurname");
		webUtil.selectByVisibleText(nameTitle, titleName);
		String name =dataMap.get("LeadFirstName");
		webUtil.input(firstName, name);
		String lastNam =dataMap.get("LeadLastname");
		webUtil.input(lastName, lastNam);
		String companyName =dataMap.get("LeadcompanyName");
		webUtil.input(comapany, companyName);
		String titleDesc =dataMap.get("title");
		webUtil.input(title, titleDesc);
		
		
		webUtil.selectByVisibleText(leadSource, "Partner");
		webUtil.selectByVisibleText(leadStatus, "Cold");
		webUtil.input(phone, "786754545634");
		String mobilenumber=dataMap.get("mobie");
		webUtil.input(mobile, mobilenumber);
	    String faxnumber=dataMap.get("fax");	
		webUtil.input(fax, faxnumber);
		String EmailId=dataMap.get("email");
		webUtil.input(email, EmailId);
		webUtil.click(grouptype);
		//webUtil.selectByVisibleText(assignedTo, "admin");
		String Streetaddress=dataMap.get("Street");
		webUtil.input(street, Streetaddress);
		
		String postalCodekey=dataMap.get("PostalCode");
		webUtil.input(postalCode, postalCodekey);
		
		String countrykey=dataMap.get("city");
		webUtil.input(country, countrykey);
		String descriptionkey=dataMap.get("Description");
		webUtil.input(description,descriptionkey);

		try {
			webUtil.getscreenoshto();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          webUtil.click(savebutton);

          webUtil.getCurrentTime();
	}

}
