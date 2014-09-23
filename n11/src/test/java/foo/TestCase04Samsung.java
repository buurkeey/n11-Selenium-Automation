package foo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase04Samsung {
	
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
	public void SamsungTest() {
		
		HomePage homePage = new HomePage(driver);
		ListPage listPage = new ListPage(driver);
		
				 homePage.openURL();
				 driver.manage().window().maximize();
				 homePage.typeSearhData("samsung");
				 homePage.clickSearchBtn();
				 listPage.verifyPage();
				 listPage.click2ndPage();
				 
				 //buraya 2.sayfada olunduğunun assertü eklenecek
				 
		
	}

}
