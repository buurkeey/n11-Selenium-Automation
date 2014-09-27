package com.burak.n11test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.burak.n11.Factory;
import com.burak.n11.HomePage;

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
			
		HomePage homePage = new HomePage(driver);
	
				
			   homePage.openURL()
					   .verifyHomePage()
					   .clickHesabim()
					   .typeEmail("n11buraktest@test.com")
					   .typePassword("n11135790")
					   .clickLogInBtn()
					   .verifyLoggedIn("Burak Test");		
	}
	
}
