package foo;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.commands.SeleniumSelect;

public class LogInPage extends HomePage {
	
	WebDriver driver;
	
	public LogInPage(WebDriver myDriver) {
		super(myDriver);
		driver = myDriver;
		PageFactory.initElements(myDriver, this);
	}
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "loginButton")
	private WebElement logInBtn;
	
	@FindBy(css = ".button.inicon.facebook.medium.facebookBtn")
	private WebElement fbLoginbtn;
	
	@FindBy(id = "forgotPassword")
	private WebElement verifyPage;
	
	public LogInPage typeEmail(String userEmail) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(userEmail);
		return this;
	}
	
	public LogInPage typePassword(String userPassword) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(userPassword);
		return this;
	}
	
	public LogInPage clickLogInBtn() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logInBtn));
		logInBtn.click();
		return this;
	}
	
	public LogInPage clickFbLogin() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(fbLoginbtn));
		fbLoginbtn.click();
		return this;
	}
	
	public LogInPage verifyLoginPage() {
		Assert.assertEquals("Şifremi Unuttum", verifyPage.getText());
		return this;
	}	
	
}
