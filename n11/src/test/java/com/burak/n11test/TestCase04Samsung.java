package com.burak.n11test;

import junit.framework.Assert;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

import com.burak.n11.AccountPage;
import com.burak.n11.Factory;
import com.burak.n11.HomePage;
import com.burak.n11.ListPage;
import com.burak.n11.LogInPage;

public class TestCase04Samsung {
	
	WebDriver driver;
	JavascriptExecutor jse = (JavascriptExecutor)driver;	
	String followListPage;
	String followAccountPage;
	
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
				
				 homePage.openURL();
				 homePage.verifyHomePage();
				 homePage.clickHesabim();
				 loginPage.verifyLoginPage();
				 loginPage.typeEmail("n11buraktest@test.com");
				 loginPage.typePassword("n11135790");
				 loginPage.clickLogInBtn();	
				 homePage.verifyLoggedIn("Burak Test");
				 homePage.searchItem("samsung");
				 homePage.clickSearchBtn();
				 listPage.verifySearch("Samsung");
				 listPage.selectSearchPagination("2");
				 listPage.verifyListPage("2");	
				 
				 //3.sırada tıklanan ürünün url'ini followListPage'e atıyorum.
				 
				 followListPage = listPage.getFirstURL("3");				 
				 //listPage.getProductURLFromList("3");				 
				 listPage.clickFavouriteBtn("3");
				 listPage.clickMyAccountFromListPage();
				 accountPage.verifyAccountPage();
				 accountPage.clickMyFavourites();
				 
				 //Favorilerimdeki ürünün url'ini followAccountPage'e atıyorum.
				 
				 followAccountPage = accountPage.getSecondURL();
				 
				 //accountPage.getProductURLFromAccount();
				 
				 //Favori sayfasındaki ürün ile bir önceki sayfada izlemeye
				 //alınmış ürünün aynı ürün olduğunu doğrulatıyorum.
				 
				 Assert.assertEquals(followListPage, followAccountPage);
				 				 
				 accountPage.clickCancelFavourite();
				 accountPage.verifyNonFavouriteProduct();
		
	}

}
