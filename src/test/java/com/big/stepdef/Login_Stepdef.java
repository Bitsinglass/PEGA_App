package com.big.stepdef;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;

import com.big.pageObjects.Common_ObjectsPO;
import com.big.pageObjects.Homepage;
import com.big.pageObjects.LoginPage;
import com.big.utils.TestReusables;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class Login_Stepdef extends TestReusables{
	
	LoginPage lp = new LoginPage(TestReusables.driver);
	Homepage hp = new Homepage(TestReusables.driver);
	Common_ObjectsPO cp = new Common_ObjectsPO(TestReusables.driver);
	
	 @Given("^I am on Login Screen$")
	    public void i_am_on_login_screen() throws Throwable {
	        System.out.println("I am on Login screen");
	    }
	 
	 
	 @When("^User enters Credentials to LogIn$")
		public void user_enters_testuser__and_Test(DataTable table) throws Throwable {
		     //handling data table my logic 
		     //table returning or converting to list of map of objects
	 		 List<Map<String, String>> data = table.asMaps(String.class, String.class);
		     for (Map<String, String> data2 : table.asMaps(String.class, String.class))
		     	{
			    	 //System.out.println("user "+data2.get("username").toString());
			    	 cp.Login(data2.get("username").toString(), data2.get("password").toString()); 
		     	}
		     } 
	 
	  
	    @Then("^I Should reached to Home Page$")
	    public void i_should_reached_to_home_page() throws Throwable 
	    {
	    	
	    	cp.Iterate_thru_Left_Menu("Configuration Management");
	    	Thread.sleep(5000);
	    	//hp.TAssets.click();
	    	Thread.sleep(5000);
	    	List<String> Drpdown_list = new ArrayList<>();// this array is used for making list of drop down 
	    	Drpdown_list.add("Bulk Meter");
	    	Drpdown_list.add("INACTIVE");
	    	Thread.sleep(1000);
	    	// this method has 2 params 1 is for Column u want to apply filters & 2nd one is for value u want to select from filter options
	    	cp.filter_Selection("Status", Drpdown_list);
	    	// for 2nd Pega application
//	    	cp.search_record("Asset","Asset Type","Bulk Meter");
	    	Thread.sleep(2000);
	    	//cp.Application_profile("Log Off");
	    }  
 
//	    @Given("^User is on Home Page$")
//	    public void user_is_on_home_page() throws Throwable 
//	    {
//	    	
////	    	Common_ObjectsPO cp = new Common_ObjectsPO(TestReusables.driver);
////	    	cp.Iterate_thru_Left_Menu("Dashboard", "Click");
////	    	Thread.sleep(5000);
////	    	hp.TAssets.click();
////	    	Thread.sleep(5000);
////	    	cp.filter_Selection("Asset Type", "Click");
////	    	List<String> myList = new ArrayList<>();
////	    	myList.add("Bulk Meter");
////	    	myList.add("Ups");
////	    	Thread.sleep(1000);
////	    	cp.filter_multiple_Selection(myList);
////	    	Thread.sleep(2000);
////	    	cp.Application_profile("Log Off");
//	    }  

	    @When("^user clicks on Dashboard link$")
	    public void user_clicks_on_Dashboard_link() throws Throwable 
	    {
	    	Common_ObjectsPO cp = new Common_ObjectsPO(TestReusables.driver);
	    	cp.Iterate_thru_Left_Menu("Dashboard");
	    }  

	    @Then("^user redirects to Dashboard_page$")
	    public void user_redirects_to_Dashboard_page() throws Throwable 
	    {
	    	driver.getTitle();
	    }  
}
