package com.big.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.TestReusables;

//import testBase.TestBase;

public class User_Mgmt_PO extends TestReusables{

	public User_Mgmt_PO(RemoteWebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath="//Button[@data-test-id='202212191141010817686']")
  public WebElement Add_User;

  @FindBy(xpath="//li[@data-test-id='dynamic-nav-menu_6']")
  public WebElement Users_Management_link;
 
  @FindBy(xpath="//input[@id='pgRepPgSubSectionUserManagementContentBBBPpxResults1colWidthCache1']//ancestor::div[@tabindex='0']//following-sibling::span/a")
  public WebElement Name_filter;
  
  @FindBy(xpath="//h1[text()='Users Management']")
  public WebElement Users_Management_text;  
  
  @FindBy(xpath="//a[text()='1 ']")
  public WebElement page_1;  
  
  @FindBy(xpath="//tr[@class='cellCont']//a[@id='pui_filter']")
  public List<WebElement> filters;
  
  @FindAll({@FindBy(xpath="//td[@style='height:35px;text-align:left; width : 25px;height:21px;']")})
  public List<WebElement> filter_checkboxes;
  
  @FindBy(xpath="//button[text()='Apply']")
  public WebElement Apply_btn;
  
  @FindBy(xpath="//input[@data-test-id='20221219113635044514']")
  public WebElement FirstName;
  
  @FindBy(xpath="//input[@data-test-id='202212230405040769541']")
  public WebElement LastName;
 
  @FindBy(xpath="//select[@data-test-id='202212191136350447278']")
  public WebElement Role;
  
  @FindBy(xpath="//select[@data-test-id='202212230413470323777']")
  public WebElement Location;
  
  @FindBy(xpath="//input[@type='tel']")
  public WebElement phoneno;
  
  @FindBy(xpath="//input[@placeholder='abc.xyz/xyzabc']")
  public WebElement email;

  @FindBy(xpath="//button[@title='Submit']")
  public WebElement Submit_btn;
  
  @FindBy(xpath="//button[@id='container-close']")
  public WebElement close_btn;
  
  @FindBy(xpath="//p[text()='There has been an issue; please consult your system administrator']")
  public WebElement err_msg; 
  
  public void Click_AddUser() {
	  page_1.click();
	  click(Add_User,"Add Users"); 
  }
  
  public void fill_details() {
	  enterText(FirstName,"FirstName","Bits"+ Return_Rand_string("abcd"));
	  enterText(LastName,"LastName","Bits"+ Return_Rand_string("fghj"));
	  selectByValue(Role,"Role","Admin");
	  select_Location();
	  enterText(phoneno,"Phone number","98"+ Return_Rand_string("12345678"));
	  enterText(email,"Email","Test"+Return_Rand_string("abcxyz"));
  }
  
  public void Click_submit_Btn()
  {
	  click(Submit_btn,"Submit_btn");
  }
  
  public void select_Location() {
	Select select = new Select(Location);
	List<WebElement> siz = select.getOptions();
	int sizeofdropdown=siz.size();
	double a = Math.random()*(sizeofdropdown-0+1)+0;  
	int random_indexno = (int)a;
	selectByIndex(Location,"Location",random_indexno);
	  //Location.sendKeys(Keys.DOWN);
  }
  
  
  
  public void Click_Filters() throws InterruptedException {
	  //Users_Management_click.click();
	  System.out.println("Filters size "+ filters.size());
	  page_1.click();
	  int i=0;
	  for(WebElement ele:filters) {//this for each which works as follows iterate thru list
		  i=i+1;
		  Thread.sleep(2000);
		  click(ele,"filter"+i);
		  
		  int chkboxes_total=filter_checkboxes.size();
		  Thread.sleep(2000);
		  System.out.println("Total "+chkboxes_total);
		  double a = Math.random()*(chkboxes_total-0+1)+0;  
		  int random_indexno = (int)a;
		  System.out.println("selected index "+random_indexno);
		  	  click(filter_checkboxes.get(random_indexno),"Filter+Chkboxes");
		  	  //click_multiple(filter_checkboxes,random_indexno,"Filter+Chkboxes");
			  click(Apply_btn,"Apply Button");
	  }

  }
  
  public String Return_Rand_string(String str)
  {
      // create a string of all characters
      String alphabet = str;
      // create random string builder
      StringBuilder sb = new StringBuilder();
      // create an object of Random class
      Random random = new Random();
      // specify length of random string
      int length = str.length();
      for(int i = 0; i < length; i++) {
        // generate random index number
        int index = random.nextInt(alphabet.length());
        // get character specified by index
        // from the string
        char randomChar = alphabet.charAt(index);
        // append the character to string builder
        sb.append(randomChar);
      }
      String randomString = sb.toString();
      return randomString;
      //System.out.println("Random String is: " + randomString);
  } 
}