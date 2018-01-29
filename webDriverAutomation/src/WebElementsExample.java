import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementsExample {
	
	public static WebDriver driver;

@BeforeClass
		public void beforeClass(){
			System.setProperty("webdriver.chrome.driver","resources/chromedriver");
			driver = new ChromeDriver();
		
}
			
/*@BeforeMethod
         public void beforeMethod(){

			driver.get("https://www.walmart.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 System.out.println(driver.getTitle());
			 
			  
			
}*/
  /*@Test(priority=1)
  
       public void walmartSignIn(){
	  
	    System.out.println("Checking for the title of the Page :"+driver.getTitle());
	  
	  
  }*/

  
  @Test
  
  public void serchbox(){
	  driver.get("https://www.walmart.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 System.out.println(driver.getTitle());
	  driver.findElement(By.id("global-search-input")).sendKeys("Laptop");
	  driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();
	 // 
	  List<WebElement>searchResults = driver.findElements(By.cssSelector(".prod-ProductTitle.no-margin.truncated.font-normal.heading-b>div"));
	  
	  System.out.println("Result:"+ searchResults.size());
	  
  }
  
  

  @AfterMethod
  
	public static void afterMethod(){
	 driver.close();
	 
	  
	
	  
  }
  
  
   
}
