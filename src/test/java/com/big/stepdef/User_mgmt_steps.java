package com.big.stepdef;

import org.junit.runner.RunWith;
import org.testng.asserts.SoftAssert;

import com.big.pageObjects.Homepage;
import com.big.pageObjects.User_Mgmt_PO;
import com.big.utils.TestReusables;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class User_mgmt_steps extends TestReusables{
	Homepage hp = new Homepage(driver);
	SoftAssert sa = new SoftAssert();
	User_Mgmt_PO um = new User_Mgmt_PO(driver);


    @Given("^Add user button is there$")
    public void add_user_button_is_there() throws Throwable {
        sa.assertEquals(um.Add_User.isDisplayed(),true);
    }

    @When("^User clicks on Add user button$")
    public void user_clicks_on_add_user_button() throws Throwable {
        um.Click_AddUser();
    }

    @Then("^Add user details page is open$")
    public void add_user_details_page_is_open() throws Throwable {
        sa.assertEquals(um.Users_Management_text.getText(), "Users Management");
//        sa.assertAll();
    }

    @Then("^user should be added successfully$")
    public void user_should_be_added_successfully() throws Throwable {
        boolean err_msg=um.err_msg.isDisplayed();
        sa.assertEquals(err_msg, false);
        sa.assertAll();
    }

    @And("^user enters details$")
    public void user_enters_details() throws Throwable {
    	um.fill_details();
    }

    @And("^user clicks on submit button$")
    public void user_clicks_on_submit_button() throws Throwable {
    	um.Click_submit_Btn();
    }

////////////---Filter functionality----------------
    
    @Given("^User clicks on multiple filters$")
    public void user_clicks_on_multiple_filters() throws Throwable {
        um.Click_Filters();
    }

    @When("^User selects the Name filter$")
    public void user_selects_the_name_filter() throws Throwable {
        
    }

    @Then("^results should be fetched as per searched name$")
    public void results_should_be_fetched_as_per_searched_name() throws Throwable {
        
    }

}