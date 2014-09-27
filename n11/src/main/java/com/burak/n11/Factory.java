package com.burak.n11;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Factory {
	
	private WebDriver driver;
	
	public Factory(WebDriver driver) {
		this.driver=driver;
	}
	
	public AccountPage accountPage() {
		return new AccountPage(driver);		
	}
	
	public FacebookPage facebookPage() {
		return new FacebookPage(driver);		
	}
	
	public HomePage homePage() {
		return new HomePage(driver);		
	}
	
	public ListPage listPage() {
		return new ListPage(driver);		
	}
	
	public LogInPage logInPage() {
		return new LogInPage(driver);		
	}
		
}