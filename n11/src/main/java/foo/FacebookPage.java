package foo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

	WebDriver driver;
	
	public FacebookPage(WebDriver myDriver) {
		driver = myDriver;
		PageFactory.initElements(myDriver, this);
	}
	
	@FindBy(id = "email")
	private WebElement fbemail;
	
	@FindBy(id = "pass")
	private WebElement fbpass;
	
	@FindBy(id = "u_0_1")
	private WebElement fbLoginBtn;
	
	public FacebookPage typeFbEmail() {
		fbemail.sendKeys("n11testhesabi@outlook.com");
		return this;
		}
	
	public FacebookPage typeFbPassword() {
		fbpass.sendKeys("n11135790");
		return this;
	}
	
	public HomePage clickFbLoginBtn() {
		fbLoginBtn.click();
		return new HomePage(driver);
	}
	
}
