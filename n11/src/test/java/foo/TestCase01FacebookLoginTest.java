package foo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase01FacebookLoginTest {

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
		public void LogInTestCase() throws InterruptedException{
			
			HomePage homepage = new HomePage(driver);
			LogInPage loginpage = new LogInPage(driver);
			FacebookPage facebookpage = new FacebookPage(driver);		
				
					homepage.openURL();
					driver.manage().window().maximize();
					homepage.verifyHomePage();
					homepage.clickHesabim();
					loginpage.verifyLoginPage();
					loginpage.clickFbLogin();
				
				//Store the current window handle
				String winHandleBefore = driver.getWindowHandle();
				//Perform the click operation that opens new window
				//Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				// Perform the actions on new window
				
					facebookpage.typeFbEmail("n11testhesabi@outlook.com");
					facebookpage.typeFbPassword("n11135790");
					facebookpage.clickFbLoginBtn();

				//Switch back to original browser (first window)

					driver.switchTo().window(winHandleBefore);

				//continue with original browser (first window)
					Thread.sleep(5000);
					homepage.verifyHomePage();
			
		}	

}
