package foo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase03LogInTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void LogInTestCase(){
			
		Factory factory = new Factory(driver);
				
				factory.homePage()
					   .openURL()
					   .verifyHomePage()
					   .clickHesabim()
					   .typeEmail("n11buraktest@test.com")
					   .typePassword("n11135790")
					   .clickLogInBtn()
					   .verifyHomePage();		
		
	}
	
}
