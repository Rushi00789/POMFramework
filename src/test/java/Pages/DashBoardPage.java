package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashBoardPage {

	WebDriver driver;
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="hlogout")
	WebElement logout;
	
	
		public boolean verifyHomePagetitle() {
		String actResult= driver.getTitle();
		String expResult="Queue Codes | Dashboard";
		return actResult.equals(expResult);
		
		
	}
		public void doLogout() {
			logout.click();
		}
		
		
}	
	
