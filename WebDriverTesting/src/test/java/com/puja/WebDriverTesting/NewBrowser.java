package com.puja.WebDriverTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 public class NewBrowser {
	static WebDriver driver;
	
	
	
	@Test(dataProvider="wordpressData")
	
	public void signin(String username,String pasword) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("http://www.ebay.com/");
		System.out.println("Tittle "+driver.getTitle());
		
		driver.findElement(By.cssSelector("#gh-ug>a")).click();
		System.out.println("Tittle "+driver.getTitle());
		
		driver.findElement(By.cssSelector("#userid")).sendKeys("username");
		driver.findElement(By.cssSelector("#pass")).sendKeys("password");
		
	    driver.findElement(By.cssSelector("#sgnBt")).click();
	    
	    Thread.sleep(5000);
	    System.out.println(driver.getTitle());
	    driver.quit();
	    
	
	
		
	}
	@DataProvider(name="wordpressData")
	public Object[][] passData()
	{
		Object[][] data= new Object[3][2];
		data [0][0] = "Puja1";
		data [0][1] ="Test123";
		
		data [1][0] ="Jha12";
		data [1][1]	="Test123";	
		
		data [2][0] ="Jha12";
		data [2][1]	="Test123";
		return data;
	}
}





