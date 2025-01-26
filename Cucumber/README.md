# Testing OpenCart  using Cucumber
This directory contains the cucumber files for testing `A set of scenarios for testing the user stories: Changing a product quantity and adding a product to the cart` module of the OpenCart  application.

# Video of the test

Click on the image below to watch the video of the test.

The link for the video is [here](https://drive.google.com/file/d/18rtgC6jXHFAeunPFNTffw9BFYyioSOxf/view?usp=sharing).

You can also click on the image below to watch the video.
[![Watch the video](https://keyholesoftware.com/wp-content/uploads/Cucumber.jpg.webp)](https://drive.google.com/file/d/18rtgC6jXHFAeunPFNTffw9BFYyioSOxf/view?usp=sharing)

## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/hellocucumber](resources/hellocucumber) directory. See the files for a detailed description of the tests.

## Step files
The step files in the [src/test/java/hellocucumber](src/test/java/hellocucumber) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.
