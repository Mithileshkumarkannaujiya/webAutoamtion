package com.Innovatoin.Vtiger.Marketting.Document.Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class CreateMarkettingdocuments {
	private Utility webUtil;
	private Map<String, String> dataMap;

	public CreateMarkettingdocuments(Utility webUtil, Map<String, String> dataMap) {
		this.webUtil = webUtil;
		this.dataMap = dataMap;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//a//img[@title='Create Document...']")
	@CacheLookup
	private WebElement createDocumentBtn;

	@FindBy(xpath = "//td//input[@name='notes_title']")
	private WebElement titletxt;

	@FindBy(xpath = "//input[@name='assigntype'  and @value='T']")
	private WebElement radioGroupBtn;

	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement assignedGroupDropdown;

	@FindBy(xpath = "//span[@class='cke_toolgroup']//span//a[@id='cke_5']")
	private WebElement boldBtn;

	@FindBy(xpath = "//span[@id='cke_4']//span[@class='cke_button']//a[@class='cke_off cke_button_italic']")
	private WebElement italicBtn;

	@FindBy(xpath = "//span[@id='cke_4']//span[@class='cke_button']//a[@class='cke_off cke_button_underline']")
	private WebElement underLineBtn;

	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement textArea;

	@FindBy(xpath = "//div//input[@id='filename_E__']")
	private WebElement fileName;

	@FindBy(xpath = "//td//input[@id='fileversion']")
	private WebElement versionTxt;

	@FindBy(xpath = "//td//input[@id='fileversion']//parent::td//parent::tr//following-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@name='filestatus']")
	private WebElement Active;

	public void createNewDocument() {
		webUtil.selectedElementWait(createDocumentBtn, 60);
		webUtil.click(createDocumentBtn);

		String Titlename = dataMap.get("Title");
		webUtil.input(titletxt, Titlename);

		webUtil.click(radioGroupBtn);
		String assignedTO = dataMap.get("AssignedGroup");

		webUtil.selectByVisibleText(assignedGroupDropdown, assignedTO);
		webUtil.click(boldBtn);
		webUtil.click(italicBtn);
		webUtil.click(underLineBtn);

		webUtil.switchToFrameByIndex(0);

		String textAreaWriting = dataMap.get("descrition");
		webUtil.input(textArea, textAreaWriting);

		webUtil.switchToMainFrame();

		String fileNametitle = dataMap.get("FileName");
		webUtil.input(fileName, fileNametitle);

		webUtil.click(Active);

		String versionName = dataMap.get("versionName");
		webUtil.input(versionTxt, versionName);

		webUtil.click(saveBtn);

	}

}
