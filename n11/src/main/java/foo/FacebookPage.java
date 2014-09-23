package foo;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(className = ".uiInputLabelLabel")
	private WebElement verifyPage;
	
	public FacebookPage typeFbEmail(String userFbEmail) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(fbemail));
		fbemail.sendKeys(userFbEmail);
		return this;
		}
	
	public FacebookPage typeFbPassword(String userFbPassword) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(fbpass));
		fbpass.sendKeys(userFbPassword);
		return this;
	}
	
	public HomePage clickFbLoginBtn() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(fbLoginBtn));
		fbLoginBtn.click();
		return new HomePage(driver);
	}
	
	//verify
	public FacebookPage verifyFacebookPage() {
		Assert.assertEquals("Oturumumu sürekli açık tut", verifyPage.getText());
		return this;		
	}

	
}
