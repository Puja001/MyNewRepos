import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DropDownAndRadio {
	
	static WebDriver driver;

	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
	}

		@Test
		
		public void windowHandle() throws InterruptedException {
			driver.get("https://www.facebook.com/");
			System.out.println("Page Title:"+driver.getCurrentUrl());
			driver.findElement(By.cssSelector("#u_0_9")).sendKeys("Puja");
			
			
			WebElement element= driver.findElement(By.id("month"));
			Select select= new Select(element);
			select.selectByIndex(2);
			

			 select = new Select (driver.findElement(By.id("day")));
		     select.selectByValue("4");
			

			select = new Select( driver.findElement(By.id("year")));
			select.selectByVisibleText("2000");
			System.out.println("Page Title  1:"+driver.getCurrentUrl());
			
			driver.findElement(By.cssSelector("#u_0_rl")).click();
			Thread.sleep(500);
		}
			
			@AfterMethod
		public void aftermethod(){
				driver.close();
			}
			
			
			
			
			
			
			

}

