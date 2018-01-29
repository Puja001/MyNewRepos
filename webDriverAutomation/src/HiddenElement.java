import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class HiddenElement {
	@Test
	public void selecthidden(){
	WebDriver driver;	
	
	System.setProperty("webdriver.chrome.driver","resources/chromedriver");
	driver = new ChromeDriver();

	driver.get("https://www.walmart.com/ip/Garmin-Drive-5-USA-LM-EX-GPS-Navigator/103445019");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 ////span[@aria-label='Select Quantity: 2']/preceding::div[@class='chooser-option-current']    
 // Actions act= new Actions (driver);
 // act.moveToElement(driver.findElement(By.xpath("//span[@aria-label='Select Quantity: 2']/preceding::div[@class='chooser-option-current"))).click().build().perform();
   WebElement element_quantity= driver.findElement(By.xpath("//span[@aria-label='Select Quantity: 2']/preceding::div[@class='chooser-option-current']"));
	element_quantity.sendKeys("2");
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement element_addtocart = driver.findElement(By.xpath("//button[@data-tl-id='ProductPrimaryCTA-cta_add_to_cart_button']"));
	element_addtocart.click();
	System.out.println("ModelName  :"+ element_addtocart.isDisplayed());
}}
