import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class NewBrowser {
	static WebDriver driver;
	@Test
	public void beforeClass()throws InterruptedException{
		
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("marionette", true);
		//WebDriver driver = new FirefoxDriver(capabilities);
		
		//System.setProperty("webdriver.firefox.marionette", "resources/geckodriver");
		
		System.setProperty("webdriver.gecko.driver","resources/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("/Applications/Firefox.app /Applications/Firefox.app" );
		WebDriver driver = new FirefoxDriver();
		//DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(FirefoxDriver.BINARY, true);
		
		driver.get("http://www.ebay.com/");
		
		 driver.close();
	}
}


