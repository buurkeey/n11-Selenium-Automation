package com.burak.n11test;

import junit.framework.Assert;

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
				 listPage.getProductURLFromList();				 
				 listPage.clickFavouriteBtn("3");
				 listPage.clickMyAccountFromListPage();
				 accountPage.verifyAccountPage();
				 accountPage.clickMyFavourites();
				 accountPage.getProductURLFromAccount();
				 
				 //listedeki ürünle favorilerimdeki ürünün urllerini alabiliyorum ama karşılaştırmasını yapamadım
				 //buraya karşılaştırılmasını yapan bir metod lazım
				 
				 accountPage.clickCancelFavourite();
				 accountPage.verifyNonFavouriteProduct();
		
	}

}
