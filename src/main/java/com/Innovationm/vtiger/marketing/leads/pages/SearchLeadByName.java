package com.Innovationm.vtiger.marketing.leads.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class SearchLeadByName {
	private Utility webUtil;

	public SearchLeadByName(Utility webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement seachBox;

	@FindBy(xpath = "//select[@id='bas_searchfield']")
	private WebElement seachbyName;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchBtn;

	@FindBys(@FindBy(xpath = "//td[@class='searchAlph']"))
	private List<WebElement> searchAlphabetical;

	@FindBy(xpath = "//input[@name='selectall']//parent::td//parent::tr//following-sibling::tr//td")
	private WebElement rowno;

	@FindBy(xpath = "//input[@name='selectall']//parent::td//parent::tr//following-sibling::tr[1]//td")
	private WebElement columnno;

	@FindBy(xpath="//a[text()='Prajapati']")
	private WebElement LeadNamePrajapati;
	
	public void searchLead() {

		for (int i = 0; i <= searchAlphabetical.size() - 1; i++) {
			WebElement word = searchAlphabetical.get(i);
			String actualtext = word.getText();
			System.out.print(actualtext + " ");
			if (actualtext.equalsIgnoreCase("M")) {
				// word.click();-- Jab Page Refresh ho jaayegea to Phir se Chalega to ye gadabad
				// hai
				webUtil.click(word);
			}

		}

		webUtil.input(seachBox, "Manish");
		webUtil.selectByVisibleText(seachbyName, "First Name");
		webUtil.click(searchBtn);
  try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
   webUtil.click(LeadNamePrajapati);
	}

}
