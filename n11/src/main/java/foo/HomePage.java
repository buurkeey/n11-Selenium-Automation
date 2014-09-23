package foo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	private WebElement hesabimbtn;
	
	public LogInPage clickHesabim() {
		hesabimbtn.click();
		return new LogInPage(driver);
	}

}

