package com.big.testNGscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.Driver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.big.pageObjects.Homepage;
import com.big.pageObjects.LoginPage;
import com.big.utils.TestReusables;
import com.big.utils.Utilities;

//import listeners.TestAllureListener;
//import pageobject.Homepage;
//import pageobject.LoginPage;

//import io.qameta.allure.Description;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import testBase.TestBase;

//@Listeners({listeners.TestAllureListener.class})
public class LoginTest extends TestReusables{
	SoftAssert sa = new SoftAssert();
	public static int count=0;
	
	private static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	@Test(priority=1,description="Verify_Title")
//	@Severity(SeverityLevel.NORMAL)
//	@Description("Verify Title")
	
//----------------------Verify The Page Title of AMS---------------------------------------
	
	public void Verify_Title() 
	{
	sa.assertEquals(false, false);
		//assert.assertTrue(false);
//		sa.assertEquals(driver.getTitle(),"Appian" );
//		sa.assertAll();
	}
	
	//----------------------Verify forgotPassword---------------------------
	
	@Test(groups = { "Sanity" }, priority=2,dependsOnMethods="Verify_Title",enabled=true)
	public void Verify_ForgotPassword() 
	{
		logger.info("This is info");
		LoginPage lp = new LoginPage(null);
		lp.Forgot_Pswd_click();
		lp.Enter_frgt_pswd("hcsadmin@yopmail.com");
		lp.Send_email_click();
		String confirmation_msg=lp.email_confirm();
		confirmation_msg=confirmation_msg.trim();
		System.out.println("text  "+confirmation_msg);
		sa.assertEquals(confirmation_msg,"An email containing directions for resetting your password has been sent to the email address associated with hcsadmin@yopmail.com.");
		sa.assertAll();
		lp.Back_link_click();
	}	
	
//----------------------Verify Validation msg Login with Invalid---------------------------
	
	@Test(groups = { "Sanity" }, priority=3,dependsOnMethods="Verify_Title",enabled=false)
	public void Login_with_Invalid_credentials() throws InterruptedException 
	{
//		LoginPage lp = new LoginPage();
		//System.out.println("Login with invalid credentials");
		LoginPage lp = new LoginPage(driver);
		lp.EnterUsernam("Invalid_username");
		lp.EnterPswd("pswddfhdg");
		lp.Login_click();
		Thread.sleep(2000);
		String error_msg=lp.read_error();
		sa.assertEquals(error_msg,"The username/password entered is invalid. Usernames and passwords are case sensitive." );
		sa.assertAll();
	}	

	
	
//----------------------Verify Login with Valid Credentials---------------------------------
	
	@Test(groups = {"Sanity"}, priority=4,dependsOnMethods="Verify_Title")
	public void Login_with_Valid_credentials() 
	{
		LoginPage lp = new LoginPage(driver);
		Homepage hp= new Homepage(driver);
		lp.EnterUsernam("CountryHead_4");
		lp.EnterPswd("Rules@12345");
		lp.Login_click();
		Utilities util = new Utilities();
		util.launchwebsite("https://crochettech.appiancloud.com/suite/sites/health-care-solution");
//		sa.assertEquals(driver.getTitle(),"Appian");
//		sa.assertAll();
	}
	
}
