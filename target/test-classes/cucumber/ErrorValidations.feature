
@tag
Feature: Error validations
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Nagative test case for E-commerce application
      Given I landed on Ecommerce Page
    	Given Logged in with <name> and password <password>
    	Then "Incorrect email password." message is displayed

    Examples: 
      | name  | password| 
      | helloveena@gmail.com | Veena12 | 