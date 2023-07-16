package com.big.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.big.utils.TestReusables;

//import testBase.TestBase;

public class LoginPage extends TestReusables{//this line is added by me

	//RemoteWebDriver driver;
	
	//Initialization
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Declaration
	
	@FindBy(xpath="//input[@id='txtUserID']")
	WebElement username; 
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='sub']")
	WebElement Login_btn;
		
	@FindBy(xpath="//a[@id='forgotPasswordLink']")
	WebElement forgt_pswd;

	@FindBy(xpath="//input[@id='username']")
	WebElement forgt_pswd_txt;
	
	@FindBy(xpath="//span[@id='error']")
	WebElement err_msg;
		
	@FindBy(xpath="//input[@value='Send Email']")
	WebElement send_email_btn;
	
	@FindBy(xpath="//a[@id='back_link']")
	WebElement back_link;
	
	@FindBy(xpath="//div[@id='email_sent_message']//span") //*[contains(text(),"ABC")]
	WebElement email_confirmation_txt;
		
	public void Login(String str1, String str2)
	{
		enterText(username,"username", str1);
		enterText(password,"password", str2);
		click(Login_btn, "Login_btn");
	}
	
	
    public void EnterUsernam(String usr)
   {
    	username.clear();
		username.sendKeys(usr);
   }
  
	public void EnterPswd(String pswd)
   {
	    password.clear();
		password.sendKeys(pswd);
   }        

	public void Enter_frgt_pswd(String pswd)
   {
		forgt_pswd_txt.clear();
		forgt_pswd_txt.sendKeys(pswd);
   }   
	
	public void Login_click()
   {
	   Login_btn.click();
   }        	

	public void Forgot_Pswd_click()
   {
	   forgt_pswd.click();
   }        	
	
	public void Send_email_click()
   {
		send_email_btn.click();
   }        	

	public void Back_link_click()
   {
		back_link.click();
   }     

	public String read_error()
   {
	return err_msg.getText();
   }        	

	public String email_confirm()
	   {
		return email_confirmation_txt.getText();
	   }        	
}