package foo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.commands.SeleniumSelect;

public class LogInPage {
	
	WebDriver driver;
	
	public LogInPage(WebDriver myDriver) {
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
	
	public LogInPage typeEmail() {
		email.sendKeys("burakkoyuncu90@gmail.com");
		return this;
	}
	
	public LogInPage typePassword() {
		password.sendKeys("1234");
		return this;
	}
	
	public LogInPage clickLogInBtn() {
		logInBtn.click();
		return this;
	}
	
	public LogInPage clickFbLogin() {
		fbLoginbtn.click();
		return this;
	}

	
	
}
