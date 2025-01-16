Feature: A set of scenarios for testing the user stories: Changing a product quantity and adding a product to the cart

  Scenario Outline: Testing a case where a customer checks out an item with a quantity of 2
    Given customer is on homepage
    When customer is logged in with "<email>" and "<password>"
    Then customer adds a "<Product>" with quantity 2 to cart
    And customer navigates to checkout page and sees the selected "<Product>"
    Examples:
      | email           | password    | Product |
      | hagai@gmail.com | 123456      | iMac  |


  Scenario Outline: Testing a case where an admin sets the max quantity of a product to 1
    Given admin is on 'Admin Dashboard page'
    When admin is logged in with "<username>" and "<password>"
    And admin navigates to Catalog
    And admin clicks on Products
    And Admin clicks on Edit of a specific "<Product>"
    And Admin navigates to Data tab
    And Admin sets the max quantity to 1
    Then Admin clicks on Save - Max quantity successfully set to 1
    Examples:
      | username      | password  | Product   |
      | admin         | 1234      | iMac      |
    


