import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class signinLink {
	
	
	static WebDriver driver;
	
	
	@BeforeClass
	public void beforeClass(){
	
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
	}
  
	@Test
	public void search(){
		 driver.get("https://www.walmart.com/");
		System.out.println("Page Title:"+driver.getTitle());
		
	  driver.findElement(By.id("global-search-input")).sendKeys("laptop");
		driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();
	
	
	
				WebDriverWait wait = new WebDriverWait(driver, 30);
				
				WebElement myAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header-GlobalAccountFlyout-flyout-link")));
				System.out.println("Result:");
				Actions action = new Actions(driver);
				
				action.moveToElement(myAccountElement).perform();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In"))).click();
				driver.getTitle();
	
			
	}
				
				//return new SignInPage(driver);
				
			
		}
			

			
			
		



