package com.Innovationm.login.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class LoginPage {
	private Utility webUtil;

	public LoginPage(Utility webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(name = "user_name")
	private WebElement userName;

	@FindBy(name = "user_password")
	private WebElement userPass;

	@FindBy(name = "login_theme")
	private WebElement loginTheme;

	@FindBy(name = "login_language")
	private WebElement loginLangauge;

	@FindBy(xpath = "//input[@name='Login']")
	private WebElement signIn;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout_Btn;
	

	public void validLogin() {
		String username =webUtil.getProObj().getProperty("UserName");
		webUtil.input(userName, username);
		String password =webUtil.getProObj().getProperty("Password");
		webUtil.input(userPass,password);
		webUtil.selectByVisibleText(loginTheme, "bluelagoon");
        webUtil.selectByVisibleText(loginLangauge, "US English");
        webUtil.click(signIn);
	}

	
	public void signOut() {
		webUtil.click(signout_Btn);
	}
}
