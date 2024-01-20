package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;
	
	public loginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(id="submit")
	WebElement signin;
	
	@FindBy(linkText="Register a new membership")
	WebElement regLinktext;
	
	public void enterEmail(String uName) {
		email.clear();
		email.sendKeys(uName);
	}
	public void enterPass(String uPass) {
		pass.clear();
		pass.sendKeys(uPass);
	}
		public void clickonSignin() {
		signin.click();
	}		
	
	public void clickonRegisterLink() {
			regLinktext.click();
		}
	public DashBoardPage doLoginwithValidData(String uName,String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickonSignin();
		return new DashBoardPage(driver); // after successfull login dashboard page will appear
		
	}
	public void doLoginwithInValidData(String uName,String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickonSignin();
	
	}
	// to verify login page
	public boolean verifyLogInPagetitle() {
		String actResult= driver.getTitle();
		String expResult="Queue Codes | Log in";
		return actResult.equals(expResult);
}
	
	}
	
	