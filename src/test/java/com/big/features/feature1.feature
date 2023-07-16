Feature: Verify the google Search Functionality

  #As a end user
  #I want to search something in google
  #So that I get the information required
  @Regression
  Scenario: Validate Login screen
    Given I am on Login Screen
    When User enters Credentials to LogIn
      | username      | password    |
      | Procurement Admin | @Install03 |
    Then I Should reached to Home Page

  #@Regression
  #Scenario: Validates Dashboard Page
    #Given user is on home page
    #When user clicks on Dashboard link
    #Then user redirects to Dashboard page

  #@Regression
  #Scenario: Validates Total Assets Page
    #Given user is on Dashboard page
    #When user clicks on Total Assets link
    #Then User redirects to Total Assets page

  #@Regression2
  #Scenario: Validates Add User Functionality
  #Given Add user button is there
  #When User clicks on Add user button
  #Then Add user details page is open
  #And user enters details
  #And user clicks on submit button
  #Then user should be added successfully
  
  #@Regression
  #Scenario: Verify the filter Functionality
    #Given User clicks on multiple filters
    #When User selects the Name filter
    #Then results should be fetched as per searched name
