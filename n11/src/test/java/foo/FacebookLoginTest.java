package foo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLoginTest {

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
			
			HomePage homepage = new HomePage(driver);
			LogInPage loginpage = new LogInPage(driver);
					
				homepage.openURL();
				homepage.clickHesabim();
				loginpage.clickFbLogin();
				
				//Store the current window handle
				String winHandleBefore = driver.getWindowHandle();

				//Perform the click operation that opens new window

				//Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}

				// Perform the actions on new window

				//Close the new window, if that window no more required
				driver.close();

				//Switch back to original browser (first window)

				driver.switchTo().window(winHandleBefore);

				//continue with original browser (first window)
			
		}	

}
