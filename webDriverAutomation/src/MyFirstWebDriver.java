import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyFirstWebDriver {
	
	static WebDriver driver;

	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
		 //driver.get("http://www.ebay.com/");
		
	}
	@BeforeMethod
	
	public void beforeMethod(){
		driver.get("http://www.ebay.com/");
		System.out.println("Page Title:"+driver.getTitle());
		
	}
	
	
	
 /*@Test(priority=2)
	public  void testHomePageRegister () {
		 
		 
		 //driver.get("http://www.ebay.com/");
		
		 //System.out.println("Page Title:"+driver.getTitle());
		 //get the element
		 
		 
		 WebElement element = driver.findElement(By.linkText("register"));
		//perform action-click
		 element.click();
		 //assert
		 assertEquals(driver.getTitle(),"Sign in or Register | eBay");
		 
         element=driver.findElement(By.id("email"));
		 
		 element.sendKeys("a@a.com");
		 
		 //entering text
		 
		 System.out.println("current url after:" +driver.getCurrentUrl());
		
		 

	}*/
	
 
 
 @Test(priority=1)
 public void navigateExample(){
		
		//driver.navigate().to("http://www.ebay.com/");
		//assertEquals(driver.getCurrentUrl(),"http://www.ebay.com/");
		
		 WebElement element = driver.findElement(By.linkText("register"));
		 element.click();
		assertEquals(driver.getTitle(),"Sign in or Register | eBay");
		
          driver.navigate().back();
		  assertEquals(driver.getTitle(),"Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay");
		  
		  driver.navigate().forward();
		  assertEquals(driver.getTitle(),"Sign in or Register | eBay");
		  
		  driver.navigate().refresh();
		 
		  
		  
 }
 @AfterMethod
 
	 public static void afterMethod(){
	 driver.close();
 }
}



















//WebDriver driver = new FirefoxDriver();

		//System.setProperty("webdriver.firefox.driver","/Users/Praween/Documents/Javacode/WebDriverAutomation/resources/geckodriver");
			




//WebDriver driver = new FirfoxDriver();
		//System path to driver.exe
		 
				//System.setProperty("webdriver.chrome.driver","/Users/Praween/Documents/Javacode/WebDriverAutomation/resources/chromedriver" );
			  //create driver object
		
		//System.setProperty("webdriver.chrome.driver", "//Users//Praween//Documents//Javacode//WebDriverAutomation//resources//chromedriver.dmg");
				
	
				// create browser with url
				  //driver.get("http://www.ebay.com/");
				  
				 // System.out.println("Page Title ::"+driver.getTitle());
				  
				
			
		
	

	//}

//}
   
	


