package com.big.stepdef;

import org.junit.runner.RunWith;

import com.big.pageObjects.Homepage;
import com.big.pageObjects.User_Mgmt_PO;
import com.big.utils.TestReusables;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class Dashboard_steps extends TestReusables{
	Homepage hp = new Homepage(driver);
	User_Mgmt_PO um = new User_Mgmt_PO(driver);
	
    @Given("^user is on home page$")
    public void user_is_on_home_page() throws Throwable {
        System.out.println("user is on Home page");
    }

//    @When("^user clicks on Dashboard link$")
//    public void user_clicks_on_dashboard_link() throws Throwable {
//     //   hp.click_links(hp.Users_Management_link,"Users link");
//    }

    @Then("^User redirects to users page$")
    public void user_redirects_to_dashboard_page() throws Throwable {
        System.out.println("User Redirects to users page");
        //um.Click_Filters();
    }

}