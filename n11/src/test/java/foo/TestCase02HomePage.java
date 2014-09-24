package foo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase02HomePage {
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void HomePageTestCase() {
	
		HomePage homePage = new HomePage(driver);
		
				 homePage.openURL();
				 driver.manage().window().maximize();
				 homePage.verifyHomePage();
		}
	
}
