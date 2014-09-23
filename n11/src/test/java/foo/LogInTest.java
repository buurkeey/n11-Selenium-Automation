package foo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
		
		driver = new FirefoxDriver();
		
	}
	
	@After
	public void tearDown(){
		
		driver.quit();
		
	}
	
	@org.junit.Test
	public void LogInTestCase(){
		
		HomePage newhomepage = new HomePage(driver);
				
				newhomepage.openURL()
				.clickHesabim()
				.typeEmail()
				.typePassword()
				.clickLogInBtn();		
		
	}
	
}
