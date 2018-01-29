import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;


public class AmazonTest {
	
	
  static  WebDriver driver;
  
	@Test
	public void signinTest(){
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		
		System.out.println("home page title:" +driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList>span:nth-of-type(2)"));
		
		element.click();
		System.out.println("sign in page title:" +driver.getTitle());
	}

	//mouse actions & explicit wait
	@Test(enabled=false)
	public void tryPrimeTest(){
		
		System.out.println("home page title:" +driver.getTitle());
		
		WebElement element = driver.findElement(By.cssSelector("#nav-link-prime .nav-line-2"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".prime-button-try>a")));
		element.click();
		
		System.out.println("prime page title:" +driver.getTitle());
	}
	
	//fluent wait
	@Test
	public void searchBoxTest() throws InterruptedException{
		
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		element.click();
		element.sendKeys("w");
		element.sendKeys("a");
		element.sendKeys("t");
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.withTimeout(30, TimeUnit.SECONDS);
		//wait.ignoring(NoSuchElementException.class);
		WebElement elm=	wait.until(function);
		
		System.out.println("element selected:"+ elm.getText());		
		elm.click();
		
		System.out.println("search results page:"+ driver.getTitle());
		
		
	}
	
	Function<WebDriver,WebElement> function = new Function<WebDriver,WebElement>(){

		public WebElement apply(WebDriver arg0) {
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			List<WebElement> elements=	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#suggestions div")));
			
			System.out.println("list size:"+ elements.size());
			WebElement elm1 =null;
			for(WebElement elm: elements){				
				System.out.println(elm.getText());
				if(elm.getText().equals("water balloons")){
					elm1=elm;
					break;
				}
			}
			return elm1;
		}

		
	};
	
	
	
	
	


}
