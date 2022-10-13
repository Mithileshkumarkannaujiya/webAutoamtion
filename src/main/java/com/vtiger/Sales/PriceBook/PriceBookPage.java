package com.vtiger.Sales.PriceBook;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.vtiger.utility.Utility;

public class PriceBookPage extends PriceBooksOR {
	private Utility webUtil;
	private Map<String, String> datamap;

	public PriceBookPage(Utility webUtil, Map<String, String> datamap) {
		this.webUtil = webUtil;
		this.datamap = datamap;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	public void CreatingNewPrivceBook() {
webUtil.click(CreatePriceBookBtn);

String priceBookName=datamap.get("Price Book Name");
webUtil.input(bookName, priceBookName);

String descriptiontxt=datamap.get("description");
webUtil.input(desciption, descriptiontxt);

webUtil.click(saveBtn);
		
		
		
	}
	
	
	
	
	
}
