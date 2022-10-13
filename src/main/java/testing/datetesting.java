package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class datetesting {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\eclipse-workspace\\java workspace\\Automation_By_Manish\\drivers\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://localhost:8888/");
	 driver.findElement(By.name("user_name")).sendKeys("admin");
	 driver.findElement(By.name("user_password")).sendKeys("admin");
	 driver.findElement(By.name("Login")).click();
	 Actions act=new Actions(driver);
	 WebElement marketing=driver.findElement(By.xpath("//a[text()='Marketing']"));
	 act.moveToElement(marketing).perform();
	 driver.findElement(By.xpath("//div[@id='Marketing_sub']//child::a[text()='Campaigns']")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	String expecctedMonthYear="August, 2022";
	String expectedDay="23";
	
	driver.findElement(By.xpath("//img[@id='jscal_trigger_closingdate']")).click();
	
	while(true) {
	WebElement monthYear=driver.findElement(By.xpath("//td[@colspan='6' and @style='cursor: move;']"));
	//System.out.println(monthYear.getText());
	if(monthYear.equals(expecctedMonthYear)) {
List<WebElement> daylist = driver.findElements(By.xpath("//tr//child::td[@class='day']"));
		for(WebElement e:daylist) {
			String calenderday=e.getText();
			System.out.println(calenderday);
			if(calenderday.equals(expectedDay)) {
				e.click();
				break;
				
			}
		}
		break;
		
	}
	else {
		driver.findElement(By.xpath("(//td[@class='button nav'  and @colspan='1'])[3]")).click();
	}
	 
	}
	
	}
}
