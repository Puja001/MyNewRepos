import java.util.concurrent.TimeUnit;

import jdk.nashorn.internal.ir.annotations.Ignore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DragAndDrop {
	
  WebDriver driver;

	
	@BeforeClass
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	
	public void droppableExample(){
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement frame1= driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dtn = driver.findElement(By.id("droppable"));
		
		
		//WebElement src = driver.findElement(By.cssSelector(".draggable"));
		action.dragAndDrop(src,dtn).perform();
		
		driver.close();
	}

		
@Ignore	


public void draggableExample(){
	driver.get("http://jqueryui.com/draggable/");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Actions action = new Actions(driver);
	WebElement frame1= driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(frame1);
	
	
	
	WebElement src = driver.findElement(By.id("draggable"));
	action.dragAndDropBy(src,800,800).perform();
	
	driver.close();
}
}
		
		
		
		
		
		
		
		
	


