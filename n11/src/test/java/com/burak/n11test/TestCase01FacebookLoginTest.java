package com.burak.n11test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.burak.n11.FacebookPage;
import com.burak.n11.HomePage;
import com.burak.n11.LogInPage;

public class TestCase01FacebookLoginTest {

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
		public void LogInTestCase() throws InterruptedException{
			
			HomePage homepage = new HomePage(driver);
			LogInPage loginpage = new LogInPage(driver);
			FacebookPage facebookpage = new FacebookPage(driver);
				
					homepage.openURL();
					homepage.verifyHomePage();
					homepage.clickHesabim();
					loginpage.verifyLoginPage();
					loginpage.clickFbLogin(); 				
					String winHandleBefore = driver.getWindowHandle();
				
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
					
					Thread.sleep(5000);
					facebookpage.verifyFacebookPage();
					facebookpage.typeFbEmail("n11testhesabi@outlook.com");
					facebookpage.typeFbPassword("n11135790");
					facebookpage.clickFbLoginBtn();
					driver.switchTo().window(winHandleBefore);
					Thread.sleep(5000);
					homepage.verifyLoggedIn("Burak Test");			
		}	

}
