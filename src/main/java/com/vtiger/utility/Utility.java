package com.vtiger.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class Utility {
	private    ExtentReports extRepoObj;
	private   ExtentTest extLogger;
	private WebDriver driver;
	private Properties propObj;

	public Utility() {
		try {
			InputStream file = new FileInputStream("src\\test\\resources\\data\\config.properties");
			propObj = new Properties();
			propObj.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getProObj() {
		return propObj;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void initHtmlReprots() {
String date=getCurrentTime();
		ExtentHtmlReporter htmlRepoObj = new ExtentHtmlReporter("automation//"+date+"reports.html");
		extRepoObj = new ExtentReports();
		extRepoObj.attachReporter(htmlRepoObj);
		extRepoObj.setSystemInfo("OS Name", "Window");
		extRepoObj.setSystemInfo("Browser Name", "Chrome");
		extRepoObj.setSystemInfo("Tester Name", "Mithilesh kumar");
	}


	public void setExtentLogger(String testCaseName) {
		extLogger = extRepoObj.createTest(testCaseName);

	}
	public void flushReport() {
                                                                                                                                              
		extRepoObj.flush();
	}

	public void Launchbrowser(String Browser) {
		if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			extLogger.log(Status.INFO, Browser+ "  Browser  has been Launched");
		} else if (Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			extLogger.log(Status.INFO, Browser+ "  Browser  has been Launched");
		} else if (Browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			extLogger.log(Status.INFO, Browser+ "  Browser has been  Launched");

		} else {
 extLogger.log(Status.INFO, " You have Entered Wrong browser name");
		}
	}

	public void openURL(String URL) {
		driver.get(URL);
		extLogger.log(Status.INFO,URL +" Has Been hitted" );
	}

	public void getCurrentDate() {
		Date date = new Date();
		String currentdate = date.toString().replace(" ", "-").replace(":", "-");
		System.out.println(currentdate);

	}

	public String getCurrentTime() {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		Date objdate = new Date();
		String date = simpledateformat.format(objdate);
		return date;
	}

	//////////////// Windows //////////////////
	public void maximizeWondow() {
		driver.manage().window().maximize();
extLogger.log(Status.INFO, "window has been maximized");
	}

	public void refreshWindow() {
		driver.navigate().refresh();
extLogger.log(Status.INFO," Page has been Refreshed succesfully");
	}

	public void close() {
		driver.close();
extLogger.log(Status.INFO, " Browser closed succesfully");

	}

	public void quit() {
		driver.quit();
		extLogger.log(Status.INFO, "All  Browser closed succesfully");
	}

	public void click(WebElement we) {
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				we.click();
			extLogger.log(Status.INFO ,"  webElement is Clicked on "+ we.toString());
			} else
				extLogger.log(Status.INFO, "  WebElement is not Unabled "+we.toString());
		} else
			extLogger.log(Status.INFO, "  WebElement is not Visible "+we.toString());
	extLogger.log(Status.ERROR, "Element is not clickable "+we.toString() );
	}

	public void input(WebElement we, String value) {

		if (we.isEnabled()) {
			if (we.isDisplayed()) {
				we.clear();
				we.sendKeys(value);
				extLogger.log(Status.INFO,"value is inputed succesfully The Value is inputed succesfully  "+value+" the Element name is  "+we.toString());
			} else
			extLogger.log(Status.INFO, "Element is not Displayed");
		} else
			extLogger.log(Status.INFO, "Element is not Enabled");
	}

	public int getHeight(WebElement we, String elementName) {
		int high = 0;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				high = we.getSize().getHeight();
extLogger.log(Status.INFO, elementName + "  Element height is : " + high);
			} else
				extLogger.log(Status.INFO, elementName + "  element is not Visible");
		} else
			extLogger.log(Status.INFO, elementName + "  Element is not Enabled");

		return high;
	}

	public int getWidth(WebElement we, String elementName) {
		int width = 0;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				width = we.getSize().getWidth();
				System.out.println(elementName + "  Element width is : " + width);
			} else
				System.out.println(elementName + "  element is not visible");
		} else
			System.out.println(elementName + "  Element is not enabled");
		return width;
	}


	public int getXLocation(WebElement we, String elementName) {
		int x = 0;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				x = we.getLocation().getX();
				System.out.println(elementName + "  Element location of X: " + x);
			} else
				System.out.println(elementName + " Element is not visible");
		} else
			System.out.println(elementName + " element is not Enabled");
		return x;
	}

	public int getYLocation(WebElement we, String elementName) {
		int y = 0;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				y = we.getLocation().getY();
				System.out.println(elementName + " element Location of Y is: " + y);
			} else
				System.out.println(elementName + " element is not visible");
		} else
			System.out.println(elementName + " element is not enabled");
		return y;
	}

	public String getInnerText(WebElement we) {
		String text = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				text = we.getText();
				System.out.println("Inner text is :" + text);
			} else
				System.out.println("Element is not enabled");
		} else
			System.out.println("Element is not Displayed");
		return text;
	}

	public String getAttributeText(WebElement we, String attributeName) {
		String attributeValue = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				attributeValue = we.getAttribute(attributeName);
				System.out.println("Inner text value is: " + attributeValue);
			} else
				System.out.println("Element is not visible");
		} else
			System.out.println("Element is not enabled");
		return attributeValue;
	}

	public String getTagName(WebElement we, String elementName) {
		String tagName = null;
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				tagName = we.getTagName();
				System.out.println("Tag Name of " + elementName + " " + tagName);
			} else
				System.out.println("Element is not visible");
		} else
			System.out.println("Element is not enabled");
		return tagName;
	}

	/////////////////// DropDown///////////////////////////////
	public void selectByVisibleText(WebElement we, String text) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.selectByVisibleText(text);
				extLogger.log(Status.INFO, text + " is selected by visible text");
			} else
				extLogger.log(Status.INFO, "Dropdowm is not Enabled");
		} else
			extLogger.log(Status.INFO, "Dropdown is not displayed");
	}


	public static void selectByIndex(WebElement we, int Number) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.selectByIndex(Number);
				System.out.println(Number + "  is selected by index ");
			} else
				System.out.println("Element is not enabled");
		} else
			System.out.println(" element is not dispalyed");
	}

	
	public void selctByValue(WebElement we, String Value) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.selectByValue(Value);
				System.out.println(Value + " is selected by value");
			} else
				System.out.println(" Element is not Enabled ");
		} else
			System.out.println("Element is not displayed");
	}

	public void deSelectByVisibleText(WebElement we, String text) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.deselectByVisibleText(text);
				System.out.println(text + " is deSelected by value");
			} else
				System.out.println("element is not Enabled");
		} else
			System.out.println("element is not displayed ");
	}

	public void deSelecteByValue(WebElement we, String deselectbyvalue) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.deselectByValue(deselectbyvalue);
				System.out.println(deselectbyvalue + " is delselected ");
			} else
				System.out.println(" value is not enabled");
		} else
			System.out.println("value is not displayed");
	}

	public void deSelectByIndex(WebElement we, int indexvalue) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getHeight() > 0) {
			if (we.isEnabled()) {
				se.deselectByIndex(indexvalue);
				System.out.println(indexvalue + " is deSelected By value");
			} else
				System.out.println("element is not enabled");
		} else
			System.out.println(" element is not displayed");
	}

	public void deSelectByAll(WebElement we) {
		Select se = new Select(we);
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			if (we.isEnabled()) {
				se.deselectAll();

				System.out.println("Element is deselected by all");
			} else
				System.out.println("element is not enabled");
		} else
			System.out.println("Element is not Displayed");
	}

	//////////////////// Actions (mouseActions)//////////////////////////////////

	public void ActionsMouseOver(WebElement we) {
		Actions act = new Actions(driver);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				act.moveToElement(we).build().perform();
				System.out.println("mouse is hovered on Element");
			} else
				System.out.println("element is not enabled");
		} else
			System.out.println("Element is not displayed and Element is not present of webpage");
	}

	public void actionsClickAndHold(WebElement we) {
		Actions act = new Actions(driver);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				act.moveToElement(we).build().perform();
				System.out.println("mouse clicked and holded the element");
			} else
				System.out.println("element is not enabled");
		} else
			System.out.println("Element is not present on the HTML Page");

	}

	public void actionInputValue(WebElement we, String inputData) {
		Actions act = new Actions(driver);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				act.sendKeys(we, inputData).build().perform();
				extLogger.log(Status.INFO, inputData+ "  Input Value is given succesfully");
			} else
			extLogger.log(Status.INFO, "Element is not enabled");
		} else
			extLogger.log(Status.INFO, "Element is not present on the HTML Page");
	}

	public void actionClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				act.click(we).build().perform();
				System.out.println("succesfully clicked on the WebElement");
			} else
				System.out.println("Element is not Enabled");
		} else
			System.out.println("Element is not present on the HTML Page");
	}

	public void actionDoubleClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				act.doubleClick(we).build().perform();
				System.out.println("succesfully doble clicked on the WebElement");
			} else
				System.out.println("Element is not enabled");
		} else
			System.out.println("Element is not displayed on the HTML Page");
	}

	public void actionsRightClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				act.contextClick(we).build().perform();
				System.out.println("Right click clicked succesfully on the element");
			} else
				System.out.println("Element is not Present on the HTML Page");
		}
	}

	public void actionDragAndDrop1(WebElement source, WebElement destination) {
		Actions act = new Actions(driver);
		if (source.isDisplayed()) {
			if (source.isEnabled()) {
				act.dragAndDrop(source, destination);
				System.out.println("Elemment is Dragged and Dropped succesfully");
			} else
				System.out.println("Element is not enable ");
		} else
			System.out.println("Element is not present on the HTML Page");

 }

	public void actionDragAndDrop2(WebElement source, WebElement destination) {
		Actions act = new Actions(driver);
		if (source.isDisplayed()) {
			if (source.isEnabled()) {
				act.clickAndHold(source).moveToElement(source).release(destination).build().perform();
				System.out.println("Element is dragged and droped successfully ");
			} else
				System.out.println("Element is not Enabled ");
		} else
			System.out.println("Element is not present on the WebPage");
	}

	///////////////////// Java Script
	///////////////////// ////////////////////////////////////////////////////////
	public void jsClick(WebElement we) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", we);
		System.out.println(" clicked by java script");
	}

	public void jsSendKeys(WebElement we, String inputValue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		we.clear();
		jse.executeAsyncScript("arguments[0].value=" + "" + inputValue + "", we);
		System.out.println("value is Inputed successfully");
	}

	public void jsMouseOver(WebElement we) {

	}

	////////////////////////////////// Waits////////////////////////////
	public void implicitywait(int timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
		extLogger.log(Status.INFO, "implicity wait applied for  "+timeInSecond);
	}

	public void staticWait(int timeInSecond) {
		int second = timeInSecond * 1000;
extLogger.log(Status.INFO, second+"  Static Wait is applied");
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectedElementWait(WebElement we, int timeSecond) {

		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofSeconds(timeSecond));
		expwait.until(ExpectedConditions.visibilityOf(we));

	}

	///////////////////////// Alert ////////////////////////////////////
	public void popUpAccept() {
		driver.switchTo().alert().accept();
extLogger.log(Status.INFO , "    Pop Alert is accepted");
	}

	public void popUpDismiss() {
		driver.switchTo().alert().dismiss();
extLogger.log(Status.INFO, "  Pop Alert is dismissed");
	}

	public void popUPSendKeys(String massage) {
		driver.switchTo().alert().sendKeys(massage);
extLogger.log(Status.INFO, massage +"    hass been send");
	}

	public String popUpGetText() {
		String getText = driver.switchTo().alert().getText();
		return getText;

	}

	///////////////////////////////// iFrame //////////////////////////
	public void switchToFramebyIdorName(String IdorName) {
		driver.switchTo().frame(IdorName);

	}

	public void switchToFramebyWebElement(WebElement we) {
		driver.switchTo().frame(we);

	}

	public void switchToFrameByIndex(int Framevalue) {
		driver.switchTo().frame(Framevalue);

	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();

	}

	public void switchToMainFrame() {
		driver.switchTo().defaultContent();

	}
	/////////////////////////// Window Handle //////////////////////////////////////

	public Set<String> switchToWindowByTitle(String expwindowTitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String multiplewindows : windows) {
			driver.switchTo().window(multiplewindows);
			String actwindowtitle = driver.getTitle();
			System.out.println(actwindowtitle);
			if (!expwindowTitle.equalsIgnoreCase(actwindowtitle)) {
			}
			driver.switchTo().window(driver.getWindowHandle());
		}
		return windows;
	}

	public Set<String> switchToWinodByURL(String expwindowURL) {
		Set<String> windows = driver.getWindowHandles();
		for (String multiplewindows : windows) {
			driver.switchTo().window(multiplewindows);
			String actwindowURL = driver.getCurrentUrl();
			if (!expwindowURL.equalsIgnoreCase(actwindowURL)) {
			}
			driver.switchTo().window(driver.getWindowHandle());
		}
		return windows;
	}

	//////////////////////////// Locaters ///////////////////////////
	public WebElement getElement(String locatorName, String locatorValue) {
		WebElement we = null;
		if (locatorName.equalsIgnoreCase("Xpath")) {
			we = driver.findElement(By.xpath(locatorValue));
		} else if (locatorName.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue));
		} else if (locatorName.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue));
		} else if (locatorName.equalsIgnoreCase("className")) {
			driver.findElement(By.className(locatorValue));
		} else if (locatorName.equalsIgnoreCase("tagName")) {
			driver.findElement(By.tagName(locatorValue));
		} else if (locatorName.equalsIgnoreCase("linkText")) {
			driver.findElement(By.tagName(locatorValue));
		} else if (locatorName.equalsIgnoreCase("partialLinkText")) {
			driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorName.equalsIgnoreCase("cssSelector")) {
			driver.findElement(By.cssSelector(locatorValue));
		}
		return we;
	}

	public void getscreenoshto() throws IOException {

		Date currentdate = new Date();
		String screenshotName = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotName);

		File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotfile, new File(".//screenshot//" + screenshotName + ".png"));

		System.out.println("screenshot has been taken");
extLogger.log(Status.INFO, "Screen Shot has been captured and stored");
	}

	/////////// Window Handle ////////////////

	public void switchToWindowsByTitle(String expTitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String multiplewindows : windows) {
			driver.switchTo().window(multiplewindows);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equalsIgnoreCase(expTitle)) {
				driver.switchTo().window(driver.getWindowHandle());

			}
		}
	}

	public void switchToWindowByURL(String expURL) {
		Set<String> windows = driver.getWindowHandles();
		for (String multiplewindows : windows) {
			driver.switchTo().window(multiplewindows);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			if (url.equalsIgnoreCase(expURL)) {
				break;

				// driver.switchTo().window(driver.getWindowHandle());
			}
		}
	}

	public void switchToMainWindow(String mainWindow) {
		driver.switchTo().window(mainWindow);

	}

	public String getMainWindow() {
		String window = driver.getWindowHandle();
		return window;
	}

	public Set<String> switchWindowByURL(String expURL) {

		Set<String> window = driver.getWindowHandles();
		for (String child : window) {
			String actualURL = driver.getCurrentUrl();
			if (!actualURL.equalsIgnoreCase(expURL)) {
				System.out.println("Your URL is wrong please enter correct URL");
			}
			driver.switchTo().window(child);
		}
		return window;
	}

}