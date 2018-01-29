import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;


public class NewWindowHandles {
	

	 static WebDriver driver;

	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
		 
		
	}
	
	@Test
	
	public void windowHandle(){
		driver.get("http://whiteboxqa.com/");
		System.out.println("Page Title:"+driver.getCurrentUrl());
		driver.findElement(By.id("headerfblogin")).click();
		
		String parentWindow= driver.getWindowHandle();
		Set <String> windowNames = driver.getWindowHandles();
		for (String name: windowNames){
			if(!name.equals(parentWindow)){
				driver.switchTo().window(name);
				break;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("Puja@com");
		driver.findElement(By.id("pass")).sendKeys("test123");
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		
		System.out.println("Result:" +driver.getCurrentUrl());
		driver.switchTo().parentFrame();
		 driver.close();
		 
		
		
		
		
	}
	}

	
	


