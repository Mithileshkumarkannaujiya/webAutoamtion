package com.Innovationm.vtiger.sales.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class CreateSalesInvoice {
	private Utility webUtil;
	private Map<String ,String> dataMap;

	public CreateSalesInvoice(Utility webUtil) {
		this.webUtil = webUtil;
		this.dataMap=dataMap;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//a//img[@alt='Create Invoice...']")
	private WebElement CreateInvoiceBtn;

	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subject;

	@FindBy(xpath = "//input[@name='customerno']")
	private WebElement cutomerNo;
                      //////  contact name ////
	@FindBy(xpath = "//input[@name='contact_name']//following-sibling::img[@alt='Select']")
	private WebElement contactNameSelect;

	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchInContactwindow;

	@FindBy(xpath="//select[@name='search_field']")
	private WebElement searchdropdownincontactwindow;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[text()='Prajapati Manish']")
	private WebElement  manishPrajapatiManish;
	
	
	
	@FindBy(xpath = "//input[@name='contact_name']//following-sibling::input[@type='image']")
	private WebElement contactNameClear;

	                       ///// contact name ////////
	
	@FindBy(xpath = "//input[@name='duedate']")
	private WebElement duedate;

	@FindBy(xpath = "//input[@id='exciseduty']")
	private WebElement exciseDuty;

	          //// ACCOUNT NAME WINDOW /////
	
	@FindBy(xpath = "//input[@name='account_name']//following-sibling::img[@title='Select']")
	private WebElement ACCNameSelect;

	@FindBy(xpath="//a[text()='Suresh raj']")
	private WebElement accountSurehsRaj;
	
	@FindBy(xpath = "//input[@name='account_name']//following-sibling::input[@alt='Clear']")
	private WebElement ACCNameClear;

	///////sale order ////
	
	@FindBy(xpath = "//input[@name='salesorder_name']//following-sibling::img[@alt='Select']")
	private WebElement saleOrderSelect;

	@FindBy(xpath="//a[text()='Suresh raj']")
	private WebElement sureshraj;
	
	@FindBy(xpath="//a[text()='Book']")
	private WebElement book;
	
	@FindBy(xpath = "//input[@name='salesorder_name']//following-sibling::input[@alt='Clear']")
	private WebElement SaleOrderClear;

	@FindBy(xpath = "//input[@name='invoicedate']")
	private WebElement invoiceDate;

	@FindBy(xpath = "//input[@name='vtiger_purchaseorder']")
	private WebElement purchaseOrder;

	@FindBy(xpath = "//input[@name='salescommission']")
	private WebElement SalesCommision;

	@FindBy(xpath = "//select[@name='invoicestatus']")
	private WebElement status;

	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement Billingaddre;

	@FindBy(xpath = "//input[@name='bill_pobox']")
	private WebElement billPoBox;

	@FindBy(xpath = "//input[@name='bill_city']")
	private WebElement bill_City;

	@FindBy(xpath = "//input[@name='bill_state']")
	private WebElement bill_State;

	@FindBy(xpath = "//input[@name='bill_code']")
	private WebElement bill_Code;

	@FindBy(xpath = "//input[@name='bill_country']")
	private WebElement bill_Country;

	@FindBy(xpath = "//img[@id='searchIcon1']")
	private WebElement addPoduct1;

	@FindBy(xpath = "//input[@id='totalProductCount']//parent::td//parent::tr//following-sibling::tr//td//div//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	public void createInvoiceLead() {
        webUtil.click(CreateInvoiceBtn);

        webUtil.input(subject, "Purchasing Goods");
        webUtil.input(cutomerNo, "9211420");
        webUtil.click(contactNameSelect);
        String parent =webUtil.getMainWindow();
        webUtil.switchWindowByURL("http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView");
        webUtil.input(searchInContactwindow, "Manish");
        webUtil.selectByVisibleText(searchdropdownincontactwindow, "First Name");
        webUtil.click(manishPrajapatiManish);
        webUtil.popUpAccept();
        webUtil.switchToMainWindow(parent);
        webUtil.input(exciseDuty, "43234");
        webUtil.click(ACCNameSelect);
        webUtil.click(accountSurehsRaj);
        webUtil.switchToMainWindow(parent);
        
        webUtil.click(ACCNameSelect);
        webUtil.switchToWindowByURL("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=");
         webUtil.click(sureshraj);
         webUtil.popUpAccept();
         webUtil.switchToMainWindow(parent);
         
         webUtil.click(saleOrderSelect);
         webUtil.switchToWinodByURL("http://localhost:8888/index.php?module=SalesOrder&action=Popup&html=Popup_picker&popuptype=specific&form=EditView&relmod_id=7&parent_module=Accounts");
         webUtil.click(book);
       //  webUtil.popUpAccept();
         webUtil.switchToMainWindow(parent);
         
         webUtil.input(purchaseOrder, "5433");
         webUtil.input(SalesCommision, "78433");
         webUtil.selectByVisibleText(status, "Approved");
      
         webUtil.click(saveBtn);
  
 
       
       
       
       
      
        
        
        
		
	}
}