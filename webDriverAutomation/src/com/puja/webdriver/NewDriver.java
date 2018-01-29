package com.puja.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewDriver {
	
	
	static WebDriver driver;
	@Test
	public void beforeClass(){
		
		/*System.setProperty("webdriver.gecko.driver","resources/geckodriver");
		driver = new FirefoxDriver();
		 driver.get("http://www.ebay.com/");*/
		System.setProperty("webdriver.gecko.driver","resources/geckodriver");
		 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			WebDriver driver = new FirefoxDriver(capabilities);
	driver.get("http://www.ebay.com/");
	}
}
