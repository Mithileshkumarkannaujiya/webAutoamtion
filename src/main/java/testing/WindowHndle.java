package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHndle {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\dell\\eclipse-workspace\\java workspace\\Automation_By_Manish\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("");
	
	
	
	
}}
