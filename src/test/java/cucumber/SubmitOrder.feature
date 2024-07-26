@tag
Feature: Purchase the order from Ecommerce WebSite

Background:
Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive Test for Submitting the order
  
    Given Logged in with <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." messag is displayed on ConfirmationPage 

    Examples: 
      | name  | password| productName|
      | helloveena@gmail.com | Veena123 | ZARA COAT 3|
  
