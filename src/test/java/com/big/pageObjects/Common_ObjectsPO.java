package com.big.pageObjects;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.big.utils.ScenarioContext;
import com.big.utils.TestReusables;
import com.big.utils.Variables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Common_ObjectsPO extends TestReusables{
	ScenarioContext sc = new ScenarioContext();
	
	public Common_ObjectsPO(RemoteWebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//Below code is for Common objects of Login page
	
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

	//Below code is for Left Wdgets in pega applications
	
	@FindBy(xpath=".//*[@class='menu-item-title']")
	List<WebElement> Left_widgets_list;
	
	//Below code is for Filter Options

	@FindBy(xpath="//a[@id='pui_filter']")
	List<WebElement> Filter_list;

	@FindBy(xpath="//a[@id='pui_filter']//parent::span//parent::div//div//child::div[@class='cellIn ']")
	List<WebElement> Filter_icon;
	
	@FindBy(xpath="//label[@class=' cb_standard']//preceding-sibling::input[@type='checkbox']//ancestor::td//following-sibling::td//label")
	List<WebElement> Filter_List;
	
	@FindBy(xpath="//label[@class=' cb_standard']//preceding-sibling::input[@type='checkbox']")
	List<WebElement> Filter_checkbox;
	
	@FindBy(xpath="//button[@data-test-id='px-opr-image-ctrl']")
	WebElement profile_link;
	
	@FindBy(xpath="//span[text()='Log off']")
	WebElement btnLogoff;

	@FindBy(xpath="//span[text()='Notification preferences']")
	WebElement Notification_pref;

	@FindBy(xpath="//span[text()='About this application']")
	WebElement About_app;
	
	@FindBy(xpath="//Button[text()='Apply']")
	WebElement btn_Apply;
	
	@FindBy(xpath="//a[text()='Trouble logging in?']")
	WebElement forgot_password;
	
	@FindBy(xpath="//h2[text()='Add/Update Assets']//ancestor::div[@id='HARNESS_CONTENT']//child::table[@id='gridLayoutTable']")
	List<WebElement> Search_rec;

		
	public void Login(String str1, String str2)
	{
		enterText(username,"username", str1);
		enterText(password,"password", str2);
		click(Login_btn, "Login_btn");
	}

	public void forgot_pswd(String str1, String str2)
	{
		click(forgot_password, "Forgot Password");
	}
	
	public void Application_profile(String action) throws InterruptedException {
		profile_link.click();
		switch (action)
		{
		case "Log Off":
			Thread.sleep(2000);
			click(btnLogoff, "Log off");
			break;			
		case "Notification_pref":
			Thread.sleep(2000);
			click(Notification_pref, "Notification_pref");
			break;	
		case "About Application":
			Thread.sleep(2000);
			click(About_app, "Notification_pref");
			break;	
	}
	}
	
	//just pass name of widget u want to play with
	public void Iterate_thru_Left_Menu(String WidgetName) {
		
			for (WebElement element : Left_widgets_list) 
			{
				if(element.getText().equalsIgnoreCase(WidgetName)) 
				{
					click(element, WidgetName);			
					break;
				}
		}
	}

	//just pass name of filter and options u want to select
	public void filter_Selection(String FilterName, List<String> Drpdown_options) throws InterruptedException{
		
			for (WebElement element : Filter_icon) {
				if(element.getText().equalsIgnoreCase(FilterName)) 
				{	
					element.findElement(By.xpath("//div[text()='"+FilterName+"']//parent::div//following-sibling::span/a")).click();
					Thread.sleep(4000);
					for (String ele : Drpdown_options) {
						
						for (WebElement element2 : Filter_List) {
							System.out.println("Ele "+ ele +" options "+ element2.getText());
							if(element2.getText().equalsIgnoreCase(ele)) 
							{
								Thread.sleep(1000);
								click(element2,"Drpdown_options");
								break;
							}
						} 
					} 
				btn_Apply.click();//clicking apply button		
				break;	
				}
				}
			} 

		

	public boolean search_record(String FilterName,String colname, String search_text) throws Exception
		{
			boolean bool=false;
			int count=0;
			System.out.println("//h2[text()='"+FilterName+"']//ancestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//button[@title='Next Page']");;
			// This line of code is to get the nxt button
			WebElement nxt_button = driver.findElement(By.xpath("//h2[contains(text(),'"+FilterName+"')]//ancestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//input"));
			
			System.out.println("//h2[contains(text(),'"+FilterName+"')]//ancestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//button[@title='Next Page']");
			
			// this line is to get the total no of pages
			String no_of_pages = driver.findElement(By.xpath("//h2[contains(text(),'"+FilterName+"')]//ancestor::div[@class=' flex content layout-content-stacked  content-stacked ']//table[@role='presentation'][@id='grid-desktop-paginator']//button[@title='Next Page']//parent::nobr//parent::td//preceding-sibling::td[1]//label")).getText(); 
			int i=Integer.parseInt(no_of_pages);
			System.out.println("pages "+i);
			
			//this loop iterate thru total no of pages times 
			for (int j=1;j<=i;j++) 
			{
				List<WebElement> item_searched = driver.findElements(By.xpath("//table[@id='gridLayoutTable']//tr//td[@data-attribute-name='"+colname+"']//span[text()='"+search_text +"']"));
				Thread.sleep(5000);
				
//				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//				List<WebElement> item_searched = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='gridLayoutTable']//tr//td[@data-attribute-name='"+colname+"']//span[text()='"+search_text +"']")));
				System.out.println("//table[@id='gridLayoutTable']//tr//td[@data-attribute-name='"+colname+"']//span[text()='"+search_text +"']");
				if(item_searched.size()>0) 
				{
					bool=true;
					count = count+1;
					
				}
				System.out.println("count = "+ count);				
				System.out.println("j = "+ j);
				Thread.sleep(3000); 
				enterText(nxt_button,"Next Button",Integer.toString(j+1));
				//Thread.sleep(3000);
				
				
				keybordentry("Enter");
				//click(nxt_button,"Next Button");			
		}
			return bool; 
}
  
}


////just pass name of filter and options u want to select
//public void filter_Selection(String FilterName, String Drpdown_options) throws InterruptedException{
//	
//		for (WebElement element : Filter_icon) {
//			if(element.getText().equalsIgnoreCase(FilterName)) 
//			{	
//				element.findElement(By.xpath("//div[text()='"+FilterName+"']//parent::div//following-sibling::span/a")).click();
//				Thread.sleep(4000);
//				for (String ele : Drpdown_options) {
//					
//					for (WebElement element2 : Filter_List) {
//						System.out.println("Ele "+ ele +" options "+ element2.getText());
//						if(element2.getText().equalsIgnoreCase(ele)) 
//						{
//							Thread.sleep(1000);
//							click(element2,"Drpdown_options");
//							break;
//						}
//					}
//				} 
//			btn_Apply.click();//clicking apply button		
//			break;	
//			}
//			}
//		} 
//
//	}


	
	//just pass value which u want to slect in a filter
//	public void filter_single_Selection(String FilterName,String option) {
//			for (WebElement element : Filter_List) {
//				
//				if(element.getText().equalsIgnoreCase(option)) 
//				{
//					element.click();
//				}
//		}
//			
//
//	} 
