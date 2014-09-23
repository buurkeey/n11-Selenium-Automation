package foo;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage {
	
	WebDriver driver;
	
	public ListPage(WebDriver myDriver){
		driver = myDriver;
		PageFactory.initElements(myDriver, this);
	}
	
	//verify
	@FindBy(css = ".resultText h1:nth-of-type(1)")
	private WebElement verifylistpage;
	
	@FindBy(linkText = "http://www.n11.com/arama?q=samsung&pg=2")
	private WebElement secondlistpage;
	
	/*@FindBy(css = ".header .currentPage")
	private WebElement secondlistpageverify;*/
	
	public ListPage verifyPage() {
		Assert.assertEquals("Samsung", verifylistpage.getText());
		return this;		
	}
	
	public ListPage click2ndPage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(secondlistpage));
		secondlistpage.click();
		return this;		
	}
	
	/*public ListPage verify2ndPage() {
		Assert.assertEquals("2", secondlistpageverify.get);*/
		
	}

}
