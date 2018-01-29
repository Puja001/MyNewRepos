import java.util.List;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;
import java.util.function.Function;

//import jdk.nashorn.internal.ir.annotations.Ignore;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class WaitExample {
	
		
		static WebDriver driver;

			
			@BeforeClass
			public void beforeClass(){
				System.setProperty("webdriver.chrome.driver","resources/chromedriver");
				driver = new ChromeDriver();
			}

			  
		/*@Test
			
			 public void explicitwait(){
			driver.get("https://www.walmart.com/");
			
				
				 System.out.println(driver.getTitle());
				  //driver.manage().window().maximize();// ask about error
				  driver.findElement(By.cssSelector("#global-search-input")).sendKeys("Laptop");
				
				  WebDriverWait wait= new WebDriverWait(driver,30);
				  
				 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".header-Typeahead-row")));
				  List<WebElement> elements= driver.findElements(By.cssSelector(".header-Typeahead-row"));
				  for(WebElement ele: elements)
				  {
					  if( ele.getText().equalsIgnoreCase("Laptop in sale"));
					  ele.click();
					  break;
					  
				  }
				  
				  
				  System.out.println("utl after selecting one of item:"+ driver.getCurrentUrl());
					  
			  }*/
		/*@Test
		public void explcitwaitexample(){

			 driver.get("https://www.walmart.com/");
		     System.out.println(driver.getTitle());
		     driver.findElement(By.cssSelector("#global-search-input")).sendKeys("Laptop");
		     WebDriverWait wait= new WebDriverWait(driver,20);
		     String result= wait.until(function);
		     System.out.println("From Function:" +result);
		
		}	*/
		
		
		Function<WebDriver,String>function = new Function<WebDriver,String>(){
			 public String apply(WebDriver arg0){
			WebDriverWait wait = new WebDriverWait(driver,20);
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".header-Typeahead-row")));
			for(WebElement ele: elements)
			  {
				  if( ele.getText().equalsIgnoreCase("Laptop in sale")){
				  ele.click();
				  break;
				  
			  }
			  }
			 
			 
			  
			  return  driver.getCurrentUrl();
				 
			 }
		
		};
		
		
			
			
		
@Test
 
  public void fluentWaitExample(){
	driver.get("https://www.walmart.com/");
    System.out.println(driver.getTitle());
    driver.findElement(By.cssSelector("#global-search-input")).sendKeys("Laptop");
    
	 FluentWait wait = new FluentWait(driver).pollingEvery(2,TimeUnit.SECONDS).withTimeout(20, TimeUnit.SECONDS);
	 String result=(String)wait.until(function);
	 System.out.println("rom Funtion: "+result);
	 
	 
	}

	 
	
	 
	 
	
	
		
			 
			
			@AfterMethod
		public void aftermethod(){
				driver.close();
			}
			
		}


		
			
		

			  
				

				 
				  
				
				  
			  
			  

		



