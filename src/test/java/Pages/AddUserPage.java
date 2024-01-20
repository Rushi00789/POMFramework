package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
	// WebElement aUsername,aEmail,aPassword,aMobile,aState;
 
 
	// browser activation
	WebDriver driver;
	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	@FindBy(id="hlogout")
	WebElement logout;
	
	@FindBy(xpath="//*[@id=\"Users\"]/a/span")
	WebElement users;
	
	@FindBy(id="add-user")
	WebElement AddUser;
	
	@FindBy(xpath="//*[@id=\"username\"]")
	WebElement aUsername;
	
	@FindBy(xpath="")
	WebElement aMobile;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement aEmail;
	
	@FindBy(xpath="//*[@id=\"Male\"]")
	WebElement MaleGenderBtn;
	
	@FindBy(xpath="//*[@id=\"Female\"]")
	WebElement FemaleGenderBtn;
	
	@FindBy(xpath="/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[5]/div/select")
	WebElement aState;
	
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement aPassword;
	
	@FindBy(xpath="submit")
	WebElement aSubmit;
	
	public void clickOnAddUser() {
		// TODO Auto-generated method stub
		AddUser.click();
	}
		
		
		public void enterName(String ausername) {
			aUsername.clear();
			aUsername.sendKeys(ausername);
		}
		public void enterPass(String apassword) {
			aPassword.clear();
			aPassword.sendKeys(apassword);
		}
		 public void enterMobile(String amobile) {
			aMobile.clear();
			aMobile.sendKeys(amobile);
		}
		  public void enterEmail(String aemail) {
			aEmail.clear();
			aEmail.sendKeys(aemail);
		}
		  public void enterState(String astate) {
					  // select by index of drop down
			  Select dropdown = new Select(aState);
			  dropdown.selectByVisibleText(astate);
		        // Select the desired option by its visible text
		  }
		  
		  public void clickOnMaleRBtn() {
			  MaleGenderBtn.click();
		    }
		  
		  
		  public void clickOnFemaleRBtn() {
			  FemaleGenderBtn.click();
		  }
		  
			public void clickonSubmitbtn() {
			aSubmit.click();;
		 }		
			
		public boolean handleAlert() {
			// TODO Auto-generated method stub
			Alert alt = driver.switchTo().alert();
			String actResult =alt.getText();
			alt.accept();
			return actResult.equals("User Added Successfully. You can not see added user.");
			
		}
		
	public void doAddUserwithdata(String aUsername,String aPassword,String aEmail,String aMobile, String aState) {
		{
		enterEmail(aEmail);
		enterPass(aPassword);
		enterMobile(aMobile);
		enterName(aUsername);
		enterState(aState);
		clickOnMaleRBtn();
		clickOnFemaleRBtn();
		clickonSubmitbtn();
		}
	}
	public boolean verifyaddUserPagetitle() {
		String actResult= driver.getTitle();
		String expResult="Queue Codes | Dashboard";
		return actResult.equals(expResult);
		
	}

	
}
