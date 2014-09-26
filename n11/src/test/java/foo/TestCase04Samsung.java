package foo;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase04Samsung {
	
	WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;	
	
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
	public void SamsungTest() throws InterruptedException{
		
		HomePage homePage = new HomePage(driver);
		ListPage listPage = new ListPage(driver);
		LogInPage loginPage = new LogInPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		Factory factory = new Factory(driver);
		
				 homePage.openURL();
				 homePage.verifyHomePage();
				 homePage.clickHesabim();
				 loginPage.verifyLoginPage();
				 loginPage.typeEmail("n11buraktest@test.com");
				 loginPage.typePassword("n11135790");
				 loginPage.clickLogInBtn();	
				 homePage.verifyHomePage();
				 homePage.typeSearhData("samsung");
				 homePage.clickSearchBtn();
				 listPage.verifyFirstListPage();
				 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
				 Thread.sleep(2000);
				 listPage.clicksecondPage();
				 Thread.sleep(5000);
				 				 
				//buraya 2.sayfada olunduğunun assertü eklenecek
				 
				 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,250);");
				 Thread.sleep(2000);
				 
				 listPage.getProductURLFromList();				 
				 listPage.clickFavouriteBtn();
				 listPage.clickMyAccountFromListPage();
				 accountPage.verifyAccountPage();
				 accountPage.clickMyFavourites();
				 Thread.sleep(2000);
				 accountPage.getProductURLFromAccount();
				 
				 //listedeki ürünle favorilerimdeki ürünün urllerini alabiliyorum ama karşılaştırmasını yapamadım
				 //buraya karşılaştırılmasını yapan bir metod lazım
				 
				 accountPage.clickCancelFavourite();
				 accountPage.verifyNonFavouriteProduct();
		
	}

}
