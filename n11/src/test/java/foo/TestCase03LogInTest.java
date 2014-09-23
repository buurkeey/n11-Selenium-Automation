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
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void LogInTestCase(){
		
		HomePage homePage = new HomePage(driver);
		LogInPage loginPage = new LogInPage(driver);
				
				homePage.openURL();
				driver.manage().window().maximize();
				homePage.clickHesabim();
				loginPage.typeEmail("n11buraktest@test.com");
				loginPage.typePassword("n11135790");
				loginPage.clickLogInBtn();	
				homePage.verifyHomePage();
		
	}
	
}
