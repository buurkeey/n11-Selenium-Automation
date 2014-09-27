package com.burak.n11;

import junit.framework.Assert;

import org.openqa.selenium.By;
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
	private WebElement verifylistpage;
	
	@FindBy(css = ".productArea .pagination a:nth-of-type(2)")
	private WebElement secondlistpage;
	
	/*@FindBy(xpath = ".//*[@id='contentListing']/div/div/div[2]/section/div[1]/div[2]/div/input")
	private WebElement secondlistpageverify;*/
	
	@FindBy(css = "#view li:nth-of-type(3) .textImg.followBtn") 
	private WebElement follow;
	
	@FindBy(css = ".myAccount .username")
	private WebElement accountbtn;
	
	
	public ListPage verifyFirstListPage() {
		Assert.assertEquals("Samsung", verifylistpage.getText());
		return this;		
	}
	
	public ListPage clicksecondPage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(secondlistpage));
		secondlistpage.click();
		return this;		
	}
	
	public ListPage clickFavouriteBtn() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(follow));
		follow.click();
		return this;		
	}
	
	/*public ListPage verifySecondPage() {
		Assert.assertEquals("2", secondlistpageverify.getText());
		return this;
	}	*/
	
	public AccountPage clickMyAccountFromListPage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(accountbtn));
		accountbtn.click();
		return new AccountPage(driver);
	}	
	
	public ListPage getProductURLFromList() {
		String firstlink = driver.findElement(By.cssSelector("#view li:nth-of-type(3) .oldPrice")).getAttribute("href");
		System.out.println(firstlink);
		return this;
	}
	
	
}
