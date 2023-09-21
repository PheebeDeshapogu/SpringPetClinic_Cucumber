package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindOwners extends BasePage {
	
	public FindOwners(WebDriver driver) {
		super(driver);
	}

	// WebElement
	
	@FindBy(xpath="//a[@title='find owners']")
	WebElement TitleFindOwner;
	
	//@FindBy(xpath = "//span[normalize-space()='Find owners']")
	//WebElement lnkFindOwnr;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txtLname;
	
	@FindBy(xpath="//button[contains(text(),'Find')]")
	WebElement btnFindOwner;
	
	@FindBy(xpath="//a[normalize-space()='Add Owner']")
	WebElement btnAddownr;

	// Action Methods
	public void ClickFindOwners() {
		TitleFindOwner.click();
	}
	public void ClickFindOwnr() {
		btnFindOwner.click();
	}

	public void ClickAddOwnr()
	{
		btnAddownr.click();
		
	}
	public void TextLname(String lname) {
		txtLname.sendKeys(lname);
	}
}
