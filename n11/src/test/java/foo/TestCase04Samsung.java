package foo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase04Samsung {
	
	WebDriver driver;

	JavascriptExecutor jse = (JavascriptExecutor)driver;	
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void SamsungTest() throws InterruptedException{
		
		HomePage homePage = new HomePage(driver);
		ListPage listPage = new ListPage(driver);
		LogInPage loginPage = new LogInPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		
				 homePage.openURL();
				 driver.manage().window().maximize();
				 homePage.verifyHomePage();
				 homePage.clickHesabim();
				 loginPage.verifyLoginPage();
				 loginPage.typeEmail("n11buraktest@test.com");
				 loginPage.typePassword("n11135790");
				 loginPage.clickLogInBtn();	
				 homePage.verifyHomePage();
				 homePage.typeSearhData("samsung");
				 homePage.clickSearchBtn();
				 listPage.verifyPage();
				 
				 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
				 Thread.sleep(2000);
				 
				 listPage.clicksecondPage();
				 
				//buraya 2.sayfada olunduğunun assertü eklenecek
				 
				 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,250);");
				 Thread.sleep(2000);
				 
				 listPage.clickFavouriteBtn();
				 listPage.clickMyAccountFromListPage();
				 accountPage.verifyPage();
				 accountPage.clickMyFavourites();
				 
				 //buraya favorilere eklenen ürünle favorilerimdeki ürünün aynı olduğunun assertü konulacak
				 
		//		 accountPage.clickCancelFavourite();
		//		 accountPage.verifyNonFavouriteProduct();
		
	}

}
