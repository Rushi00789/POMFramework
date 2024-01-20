package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddUserPage;
import Pages.DashBoardPage;
import Pages.RegisterPage;
import Pages.loginPage;

public class POMtest extends BaseIntegration {
	
	@Test(dataProvider ="loginData")
	public void doLogin(String testName,String uName,String uPass) {
		loginPage login = new loginPage(driver);
		if(testName.equals("all are valid")) {
			DashBoardPage dash = login.doLoginwithValidData(uName,uPass);
			Assert.assertTrue(dash.verifyHomePagetitle());
			dash.doLogout();
		}else {
			 login.doLoginwithInValidData(uName,uPass);
			Assert.assertTrue(login.verifyLogInPagetitle());
		}
	}
	
@Test (dataProvider="registerData")

public void doRegister(String testname,String rName, String rPass,String rMobile,String rEmail) {
	if(driver.getTitle().equals("Queue Codes | Log in")) {
		loginPage login = new loginPage(driver);
		login.clickonRegisterLink();
	}
	RegisterPage register =new RegisterPage(driver);
	register.doRegisterwithdata(rName, rPass, rMobile,rEmail);
		if(testname.equals("all are valid")) {
			Assert.assertTrue(register.handleAlert());
	}else {
		Assert.assertTrue(register.verifyRegisterPagetitle());
	}
}

@Test (dataProvider="addUserData")

public void addUser(String testname,String aUsername, String aPassword,String aMobile,String aEmail,String aState) {
	if(driver.getTitle().equals("Queue Codes | User")) { /// dashboard page title
		AddUserPage Aupage = new AddUserPage(driver);
		Aupage.clickOnAddUser();
	}
	AddUserPage Aupage =new AddUserPage(driver);
	Aupage.doAddUserwithdata(aUsername,aPassword,aMobile,aEmail,aState);
		if(testname.equals("all are valid")) {
			Assert.assertTrue(Aupage.handleAlert());
	}else {
		Assert.assertTrue(Aupage.verifyaddUserPagetitle());
	}

}

}
