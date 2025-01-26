# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [opencart](http://localhost/opencartsite/).

In this assignment, we tested an open-source software called OpenCart. 

OpenCart is an open-source e-commerce platform that allows users to create and manage online stores. 

It provides a robust framework for catalog management, payment integration, and customer management.


## Installation
1. Install XAMPP to set up a local web server environment.
2. Download the OpenCart installation package from OpenCart’s official website.
3. Set up a MySQL database for OpenCart via phpMyAdmin.
4. Extract the OpenCart zip file to the htdocs directory in your XAMPP installation.
5. Start the Apache and MySQL services from the XAMPP Control Panel.
6. Open your browser and navigate to http://localhost/opencartsite/ to start the OpenCart installation wizard.
7. Follow the wizard steps to configure the database and administrator account.
8. Once installed, access the admin dashboard at http://localhost/opencartsite/admin1.

## What we tested
We tested the product catalog and checkout module in OpenCart. We chose to test the following user stories:

User story 1: A customer checks out an item with a quantity of 2.

Preconditions: The store has at least one product available in the catalog.

Expected outcome: The item is successfully added to the cart, and the checkout process is completed without errors.


User story 2: An admin sets the maximum quantity of a product to 1.

Preconditions: The admin is logged into the dashboard and navigates to the product catalog.

Expected outcome: The admin successfully updates the maximum product quantity, and the system enforces the new limit during checkout.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Cucumber Results:

User story 1: Passed. 
The customer was able to add a product with a quantity of 2 to the cart and complete the checkout process.

User story 2: Passed. The admin successfully updated the maximum quantity of the product, and the new limit was enforced during checkout.

Provengo Results:
The model was analyzed to generate a concise state-space graph, and various test suites were run to ensure comprehensive coverage of the user stories.
All tests passed with no unexpected behaviors.

## Detected Bugs
We detected the following bugs:

No bugs detected.
