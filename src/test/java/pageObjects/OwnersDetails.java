package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersDetails extends BasePage{
	public OwnersDetails(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='address']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//button[normalize-space()='Add Owner']")
	WebElement btnAddOwner2;
	
	
	//ActionMethods
	public void txtFname(String Fname) {
		fname.sendKeys(Fname);
	}
	public void txtLname(String Lname) {
		lname.sendKeys(Lname);
	}
	public void txtAddress(String Address) {
		address.sendKeys(Address);
	}
	
	public void txtCity(String City) {
		city.sendKeys(City);
	}
	public void txtTelephone(String Telephone) {
		telephone.sendKeys(Telephone);
	}
	public void BtnAddOwner2() {
		btnAddOwner2.click();
	}
}
