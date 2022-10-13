package com.Innovationm.vtiger.marketing.leads.pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class EditLead {
private Utility webUtil;
private Map<String,String> dataMap;

public EditLead(Utility webUtil, Map<String,String> dataMap) {
	this.webUtil=webUtil;
	this.dataMap=dataMap;
PageFactory.initElements(webUtil.getDriver(), this);	
	}

@FindBy(xpath="//input[@name='search_text']")
private WebElement searchTxtBox;

@FindBy(xpath="//select[@id='bas_searchfield']")
private WebElement searchByName;

@FindBy(xpath="//input[@class='crmbutton small create'    and @name='submit']")
private WebElement searchBtn;

@FindBy(xpath="//td[text()='LEA5 ']//following-sibling::td//a[text()='edit']")
private WebElement Lead5EditName;

@FindBy(xpath="//input[@name='firstname']")
private WebElement firstName;

@FindBy(xpath="//input[@name='email']")
private WebElement emailId;

@FindBy(xpath="//input[@name='website']")
private WebElement websitename;


@FindBy(xpath="//textarea[@name='description']//parent::td//parent::tr//following-sibling::tr//div//input[@class='crmbutton small save']")
private WebElement saveBtn;


public void editLead() {
	
 webUtil.click(Lead5EditName);
 String LeadNamekey=dataMap.get("Leadname");
webUtil.input(firstName, LeadNamekey);
String Emailkey=dataMap.get("email");
webUtil.input(emailId, Emailkey);
String websitekey=dataMap.get("website");
webUtil.input(websitename, websitekey);
try {
	webUtil.getscreenoshto();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
webUtil.click(saveBtn);

	
}

/*
public void clickonEdit(String leadName) {

List<WebElement> listOfLead=	webUtil.getDriver().findElements(By.xpath("//tr[@onmouseover=\"this.className='lvtColDataHover'\"]//td"));
	for(int i=0; i<=listOfLead.size()-1;i++) {
		String textOfLead =listOfLead.get(i).getText();
		List<WebElement> listOfEditlink=	webUtil.getDriver().findElements(By.xpath("//a[contains(text(),'edit')]"));
		WebElement	editLink=null;
		for(int j=0;j<=listOfEditlink.size()-1;j++) {
				editLink=listOfEditlink.get(j);
		}
		if(textOfLead.equalsIgnoreCase(leadName)) {
			editLink.click();
		}
	
	}

	
}



		
	*/	

}


