package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	@FindBy(id="name")
	WebElement rname;
	
	@FindBy(id="email")
	WebElement remail;
	
	@FindBy(id="password")
	WebElement rpass;
	
	@FindBy(id="mobile")
	WebElement rmobile;
	
	@FindBy(className="btn-flat")
	WebElement rsubmit;
	
	public void enterName(String rName) {
		rname.clear();
		rname.sendKeys(rName);
	}
	public void enterPass(String rPass) {
		rpass.clear();
		rpass.sendKeys(rPass);
	}
	public void enterMobile(String rMobile) {
		rmobile.clear();
		rmobile.sendKeys(rMobile);
	}
	public void enterEmail(String rEmail) {
		remail.clear();
		remail.sendKeys(rEmail);
	}
		public void clickonSubmitbtn() {
		rsubmit.click();;
	}		
		
		public boolean handleAlert() {
			Alert alt = driver.switchTo().alert();
			String actResult =alt.getText();
			alt.accept();
			return actResult.equals("User registered successfully.");
		}
	public void doRegisterwithdata(String rName,String rPass,String rEmail,String rMobile) {
		{
		enterEmail(rEmail);
		enterPass(rPass);
		enterMobile(rMobile);
		enterName(rName);
		clickonSubmitbtn();
	    
		}
	}
		// to verify Register page
		public boolean verifyRegisterPagetitle() {
			String actResult= driver.getTitle();
			String expResult="Queue Codes | Registration Page";
			return actResult.equals(expResult);
	}
		 	
}
