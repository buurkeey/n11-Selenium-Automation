package com.burak.n11;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage extends HomePage{
	
	WebDriver driver;
	
	public ListPage(WebDriver myDriver){
		super(myDriver);
		driver = myDriver;
		PageFactory.initElements(myDriver, this);
	}
	
	//verify
	@FindBy(css = ".resultText h1:nth-of-type(1)")
	private WebElement verifylist;
	
	@FindBy(css = "#view li:nth-of-type(3) .textImg.followBtn") 
	private WebElement follow;
	
	@FindBy(css = ".myAccount .username")
	private WebElement accountbtn;
	
	
	public ListPage verifySearch(String product) {
		Assert.assertEquals(product, verifylist.getText());
		return this;		
	}
	
	public ListPage selectSearchPagination(String pageNumber) {
		WebElement listPage = driver.findElement(By.linkText(pageNumber));
		listPage.click();
		return this;		
	}
	
	public ListPage clickFavouriteBtn(String itemNumber) {
		WebElement product = driver.findElement(By.cssSelector("#view li:nth-of-type("+itemNumber+") .textImg.followBtn"));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,250);");
		product.click();
		return this;		
	}
	
	public ListPage verifyListPage(String pageNumber) {
		WebElement pNumber = driver.findElement(By.cssSelector(".header .currentPage"));
		Assert.assertEquals(pageNumber, pNumber.getAttribute("value"));
		return this;
	}
	
	public AccountPage clickMyAccountFromListPage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(accountbtn));
		accountbtn.click();
		return new AccountPage(driver);
	}	
	
	public String getFirstURL(String number) {
		String fURL = driver.findElement(By.cssSelector("#view li:nth-of-type("+number+") .oldPrice")).getAttribute("href");
		return fURL;		
	}
		
}
