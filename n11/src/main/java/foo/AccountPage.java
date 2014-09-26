package foo;

import junit.framework.Assert;

import org.apache.regexp.recompile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends HomePage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver myDriver){
		super(myDriver);
		driver = myDriver;
		PageFactory.initElements(myDriver, this);
	}
	
	@FindBy(xpath = ".//*[@id='myNavigation']/li[3]/a")
	private WebElement myfavourites;
	
	//verify
	@FindBy(css = ".leftColumn #myNavigation li:nth-of-type(1)")
	private WebElement accountpageverify;
	
	@FindBy(xpath = ".//*[@id='watchList']/tbody/tr/td[7]/a")
	private WebElement cancelfavourite;
	
	@FindBy(xpath = ".//*[@id='watchList']/tbody/tr/td") 
	private WebElement verifynoproduct;
	
	public AccountPage clickMyFavourites() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(myfavourites));
		myfavourites.click();
		return this;		
	}  
	
	public AccountPage verifyAccountPage() {
		Assert.assertEquals("Sipariş Durumu", accountpageverify.getText());
		return this;		
	}
	
	public AccountPage clickCancelFavourite() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(cancelfavourite));
		cancelfavourite.click();
		return this;		
	}
	
	public AccountPage verifyNonFavouriteProduct() {
		Assert.assertEquals("İzlediğiniz bir ürün bulunmamaktadır.", verifynoproduct.getText());
		return this;		
	}

}
