package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerInformation extends BasePage{
	public OwnerInformation(WebDriver driver) {
		super(driver);
	}

	
	//WebElements
	@FindBy(xpath="//h2[normalize-space()='Owner Information']")
	WebElement txtHeader;
	
	//ActionMethods
	
	 public boolean isOwnerInfoHeaderExists() 
		{
			try {
				return(txtHeader.isDisplayed());
			} catch(Exception e ) {
				return(false);
			}
		}
		  

}
