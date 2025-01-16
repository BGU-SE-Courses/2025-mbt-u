Feature: A set of scenarios for testing the user stories: Changing a product quantity and adding a product to the cart

  Scenario Outline: Testing a case where a customer checks out an item with a quantity of 2
    Given customer is on homepage
    When customer is logged in with "<email>" and "<password>"
    And customer adds a "<Product>" with quantity "<Quantity>" to cart
    Then "<Product>" with quantity "<Quantity>" successfully added to the cart
    And customer navigates to checkout page
    Examples:
      | email           | password | Product | Quantity |
      | hagai@gmail.com | 123456   | iMac    | 2        |


  Scenario Outline: Testing a case where an admin sets the max quantity of a product to 1
    Given admin is on 'Admin Dashboard page'
    When admin is logged in with "<email>" and "<password>"
    And admin navigates to Catalog
    And admin clicks on Products
    And Admin clicks on Edit of a specific "<Product>"
    And Admin navigates to Data tab
    And Admin sets the max quantity to "<MaxQuantity>"
    And Admin clicks on Save
    Then Max quantity successfully set to "<MaxQuantity>"
    Examples:
      | email | password | Product  | MaxQuantity |
      | admin    | 1234     | iMac  | 2           |
