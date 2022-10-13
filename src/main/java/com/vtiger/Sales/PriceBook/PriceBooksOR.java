package com.vtiger.Sales.PriceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceBooksOR {

	@FindBy(xpath = "//a//img[@title='Create Price Book...']")
	protected WebElement CreatePriceBookBtn;

	@FindBy(xpath = "//td//input[@name='bookname']")
	protected WebElement bookName;

	@FindBy(xpath="//textarea[@name='description']")
	protected WebElement desciption;
	
	@FindBy(xpath="//td[@class='moduleName']")
	protected WebElement moduleName;
	
	
	@FindBy(xpath="//textarea[@name='description']//parent::td//parent::tr//following-sibling::tr//input[@title='Save [Alt+S]']")
	protected WebElement saveBtn;
}
