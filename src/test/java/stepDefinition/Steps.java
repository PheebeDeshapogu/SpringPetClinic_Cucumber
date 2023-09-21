package stepDefinition;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.FindOwners;
import pageObjects.HomePage;
import pageObjects.OwnerInformation;
import pageObjects.OwnersDetails;

public class Steps {
	WebDriver driver;
	Logger logger;
	ResourceBundle rb;
	String br;
	HomePage hp;
	FindOwners fo;
	OwnerInformation oi;
	OwnersDetails od;

	@Before
	public void setup() {
     rb = ResourceBundle.getBundle("config");// Load config.properties file
		
		logger = LogManager.getLogger(this.getClass());
		// this.getClass-captures the current test case which is executing;
		
		//Reading config.properties(for browser)-Approach1
			 br = rb.getString("browser");
			 }

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Scenario status====>" + scenario.getStatus());
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			
			/*double myDouble = 9.78d;   (For my understanding of TYPECASTING took an example from W3School)
             int myInt = (int) myDouble; // Manual casting: double to integer
  			System.out.println(myDouble);   // Outputs 9.78
    		System.out.println(myInt);      // Outputs 9*/
			
			scenario.attach(screenshot, "image/png", scenario.getName());
			
			//byte[] screenshot = ((TakeScreenshot) driver). getScreenshotAs(OutputType.BYTES);//Above 2 steps are combined into 1 step
			//scenario.attach(screenshot, "image/png", scenario.getName());  //Above three steps are combined into 2 steps
		}
		driver.quit();
	}

	@Given("User launch the browser")
	public void user_launch_the_browser() {

		ChromeOptions options = new ChromeOptions();//Both these statements are for removing "chrome is controlled by automated software"
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("--remote-allow-origins=*");// Both these statements
		
		Map<String, Object> prefs = new HashMap<String, Object>();//these statements are only to remove the pop up to Save and Never
		prefs.put("credentials_enable_service", false);//these statements are only to remove the pop up to Save and Never
		prefs.put("profile.password_manager_enabled", false);//these statements are only to remove the pop up to Save and Never
		options.setExperimentalOption("prefs", prefs);//these statements are only to remove the pop up to Save and Never
		
		if (br.equals("chrome")) {
			driver = new ChromeDriver(options);
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

		
	

	@Given("opens the URL {string}")
	public void opens_the_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User navigates to FIND OWNERS menu and clicks on FIND OWNERS")
	public void user_navigates_to_find_owners_menu_and_clicks_on_find_owners() {
		hp = new HomePage(driver);
		hp.isWelcomeHeaderExists();
		logger.info("Welcome header is present");
		fo = new FindOwners(driver);
		fo.ClickFindOwners();

	}

	/*@When("Clicks on Add Owner")
	public void clicks_on_add_owner() {
		//hp = new HomePage(driver);
		fo = new FindOwners(driver);
		//fo.ClickFindOwners();
		//logger.info("Clicked on Find Owners");
		fo.ClickAddOwnr();
		logger.info("Clicked on the Add Owner");

	}*/

	/*@When("User enters firstname as {string} and lastname as {string} and Address as {string} and City as {string} and Telephone as {string} and click  on Add owner")
	public void user_enters_firstname_as_and_lastname_as_and_address_as_and_city_as_and_telephone_as_and_click_on_add_owner(String Fname, String Lname, String Address, String City, String Telephone)  {
		
		OwnersDetails od = new OwnersDetails(driver);
		od.txtFname(Fname);
		logger.info("Enter the Fname");
		od.txtLname(Lname);
		logger.info("Enter the Lname");
		od.txtAddress(Address);
		logger.info("Enter the Address");
		od.txtCity(City);
		logger.info("Enter the City");
		od.txtTelephone(Telephone);
		logger.info("Enter the Telephone");
		od.BtnAddOwner2();
		logger.info("Clicked on Add Owner Button");
	}*/
	@When("User enters the {string} field and clicks on Find Owner")
	public void user_enters_the_field_and_clicks_on_find_owner(String lname) {
	    
		fo = new FindOwners(driver);
		fo.TextLname(lname);
		fo.ClickFindOwnr();
	}

	@Then("user navigates to Owner Information Page")
	public void user_navigates_to_owner_information_page() {
		OwnerInformation oi = new OwnerInformation(driver);
		boolean headingExists = oi.isOwnerInfoHeaderExists();
		if (headingExists) {
			logger.info("Login Success");
			Assert.assertTrue(true);
		} else {
			logger.info("Login Failed");
			Assert.assertTrue(false);
		}
		logger.info("Validating the Owner Information Page");
	}

}
