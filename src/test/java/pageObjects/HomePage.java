package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// WebElements
	@FindBy(xpath = "//h2[normalize-space()='Welcome']")
	WebElement headerWelcome;

	// Action Methods
	public boolean isWelcomeHeaderExists() 
	{
		try {
			return(headerWelcome.isDisplayed());
		} catch(Exception e ) {
			return(false);
		}
	}
}
