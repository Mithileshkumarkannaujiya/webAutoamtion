package com.Innovationm.vtiger.or.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ORCommon {

@FindBy (xpath = "//a[text()='My Home Page']")
protected WebElement homePg;

@FindBy(xpath="//td[@class='tabUnSelected']//a[text()='Marketing']")
protected WebElement marketing;
@CacheLookup


@FindBy(xpath="//a[text()='Sales']")
protected WebElement sales;


@FindBy(xpath="//a[text()='Support']")
protected WebElement support;


@FindBy(xpath="//a[text()='Analytics']")
protected WebElement analytics;


@FindBy(xpath="//a[text()='Inventory']")
protected WebElement invetory;


@FindBy(xpath="//a[text()='Tools']")
protected WebElement  tools;


@FindBy(xpath="//a[text()='Gmail Bookmarklet']")
protected WebElement mailBook;


 @FindBy(xpath="//a[text()='vtiger News']")
 protected WebElement vtigernews;

 
 @FindBy(xpath="//a[text()='Feedback']")
 protected WebElement feedback;
 
 
 @FindBy(xpath="//a[text()='My Preferences']")
protected  WebElement preference;
 
 
@FindBy(xpath="//a[text()='Help']")
protected WebElement help;


@FindBy(xpath="//a[text()='About Us']")
protected  WebElement about;

@FindBy(xpath="//a[text()='Sign Out']")
protected WebElement signOut;

 }
