package foo;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver myDriver){
		driver = myDriver;
		PageFactory.initElements(myDriver, this);
	}
	
	public HomePage openURL() {
		driver.navigate().to("http://www.n11.com/");
		return this;
	}
	
	@FindBy(css = ".btnSignIn")
	private WebElement loginbtn;
	
	//verify
	@FindBy(css = ".hLogoT")
	private WebElement verifyPage;
	
	@FindBy(id = "searchData")
	private WebElement data;
	
	@FindBy(css = ".searchBtn")
	private WebElement searchbtn;
	
	@FindBy(linkText = "//www.n11.com/hesabim")
	private WebElement accountbtn;
	
	/*@FindBy(css = ".username")
	private WebDriver verifyFbReturn;*/
	
	public LogInPage clickHesabim() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(loginbtn));
		loginbtn.click();
		return new LogInPage(driver);
	}
	
	//verify
	public HomePage verifyHomePage() {
		Assert.assertEquals("alışverişin uğurlu adresi", verifyPage.getText());
		return this;
	}
	
	public HomePage typeSearhData(String searchData) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(data));
		data.sendKeys(searchData);
		return this;
	}
	
	public ListPage clickSearchBtn() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchbtn));
		searchbtn.click();
		return new ListPage(driver);
	}
	
	/*public HomePage verify() {
		Assert.assertEquals("n11testhesabi@outlook.com", verifyFbReturn.getText());
		return this;
	}*/
	
	public HomePage clickMyAccount() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(accountbtn));
		accountbtn.click();
		return this;
	}

	
}

