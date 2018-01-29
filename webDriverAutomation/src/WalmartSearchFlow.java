import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WalmartSearchFlow {
	
	static WebDriver driver;
	

@BeforeClass
	public void beforeClass(){
	
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
	}
  
@BeforeMethod(enabled=false)
	public void beforeMethod(){
	   driver.get("https://www.walmart.com/");
		System.out.println("Page Title:"+driver.getTitle());
   }
	
	@Test
	public  void searchProduct(){
		driver.get("https://www.walmart.com/");
	     driver.findElement(By.cssSelector("#global-search-input")).sendKeys("gps");
	     WebDriverWait wait= new WebDriverWait(driver,20);
	     String result= wait.until(function);
	     System.out.println("From Function:" +result);
	     assertEquals( result,"https://www.walmart.com/search/?query=garmin%20gps&typeahead=gps");	
	}
	
	Function<WebDriver,String>function = new Function<WebDriver,String>(){
	    public String apply(WebDriver arg0){
		WebDriverWait wait = new WebDriverWait(driver,20);
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".header-Typeahead-row")));
		for(WebElement ele: elements)
		  {
			  if( ele.getText().equalsIgnoreCase("garmin gps")){
			  ele.click();
			  break;
			  
		  }
		  }
		 
		 
		  
		  return  driver.getCurrentUrl();
			 
		 }
	
	};
	
	
 @Test	
	
	
	public void SearchPage(){
	 searchProduct();
	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> searchResult= driver.findElements(By.cssSelector(".product-title-link>span"));
		System.out.println("Result:"+ searchResult.size());
		
		assertEquals(searchResult.size(),40);
		 }
 	
@Test(enabled=false)

	public void AddToCart(){

	    //product Page
	
	
		driver.get("https://www.walmart.com/ip/Garmin-Drive-5-USA-LM-EX-GPS-Navigator/103445019");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		                                                                  ////span[@aria-label='Select Quantity: 2']/preceding::div[@class='chooser-option-current']    
		WebElement element_quantity= driver.findElement(By.xpath("//div[@class='chooser-option-current']/span"));
		element_quantity.sendKeys("2");
		
		WebElement element_addtocart = driver.findElement(By.xpath("//button[@data-tl-id='ProductPrimaryCTA-cta_add_to_cart_button']"));
		element_addtocart.click();
		System.out.println("ModelName  :"+ element_addtocart.isDisplayed());
    
		///order summary page
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String   element_cartItems=driver.findElement(By.cssSelector(".js-btn-product.btn-fake-link")).getText();
		System.out.println("CurrentPage Title:"+element_cartItems);
		assertNotNull("Garmin Drive 5' USA LM EX GPS Navigator",element_cartItems);    //5" has this " mark
		System.out.println("yeeeeeee1");
		//System.out.println("CHECKOUT BUTTON _1: "+ element_cartItems.isDisplayed());
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element_checkout  = driver.findElement(By.xpath("//button[@data-automation-id='pac-pos-proceed-to-checkout']"));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("yeeeeeee2");
		 element_checkout.click();

		//System.out.println("CHECKOUT BUTTON_2 : "+ element_checkout.isDisplayed());
		System.out.println("yeeeeeee3");
		System.out.println("CurrentPage Title:"+driver.getTitle());
      }

	
   //sign in
		
/*@Test(priority=4)
	
		public void walmartSignIn(){
	     //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.name("email")).sendKeys("Puja");
	     driver.findElement(By.name("password")).sendKeys("Test123");
	     driver.findElement(By.xpath("//button[text()='Sign In']"));
	    // String pagename=driver.findElement(By.xpath("//h1[contains(text(),'Sign In')]")).getText();
	      //System.out.println("Page_Name :"+pagename);
	
	  
	    //System.out.println("Checking for the title of the Page :" +driver.getCurrentUrl());
	   // assertEquals(driver.getCurrentUrl(),"https://www.walmart.com/checkout/#/sign-in");
   }*/
	
	
	@AfterTest
	public void aftetest(){
	
		driver.close();
	}
	
	}
