package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class StepDefinitions {
    private int oldQuantity;

    private ChromeDriver customerDriver;
    private ChromeDriver adminDriver;

    private WebDriverWait customerWait;
    private WebDriverWait adminWait;

    String chrome_path = "C:\\BGU\\Year 3\\Quality Assurance\\2025-mbt-u\\Selenium\\chromedriver.exe";

    // opens the browser and navigates to the website under test
    @Given("customer is on homepage")
    public void userInHomePage() {
        // initialize the Chrome driver
        System.setProperty("webdriver.chrome.driver", chrome_path);
        this.customerDriver = new ChromeDriver();
        this.customerWait = new WebDriverWait(customerDriver, Duration.ofSeconds(40));
        // navigate to the website
        customerDriver.get("http://localhost/opencartsite/");
        // set the window position
        customerDriver.manage().window().setPosition(new Point(5, 5));
        // Set window size to 1000x1000
        Dimension dimension = new Dimension(1000, 1000);
        customerDriver.manage().window().setSize(dimension);
    }

    // user logs in with the given email and password
    @When("customer is logged in with {string} and {string}")
    public void userIsLoggedInWithEmailAndPassword(String email, String password) {
        // find the my account link and click it
        customerDriver.findElement(By.xpath("//*[@id='top']/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/a[1]/i[2]")).click();
        // find the login link and click it
        customerWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='top']/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/ul[1]/li[2]/a[1]"))).click();
        // find the email input and fill it with the given email
        customerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-email']"))).sendKeys(email);
        // find the password input and fill it with the given password
        customerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys(password);
        // find the login button and click it
        customerWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form-login']/div[3]/button[1]"))).click();
        // wait a few seconds for the page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("customer adds a {string} with quantity 2 to cart")
    public void userAddsProductToCart(String product) throws InterruptedException {
        // find the search input and fill it with the given product
        customerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"search\"]"))).sendKeys(product);
        // find the search button and click it
        customerWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]"))).click();

        // find add to cart button and scroll to it
        WebElement addToCartButton = customerDriver.findElement(By.xpath("//form[1]/div[1]/button[1]"));
        // scroll to the element
        ((JavascriptExecutor) customerDriver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        // wait until the element is clickable
        customerWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        // click on the element using JavaScript executor to ensure it's clicked
        ((JavascriptExecutor) customerDriver).executeScript("arguments[0].click();", addToCartButton);
        Thread.sleep(1000);
        ((JavascriptExecutor) customerDriver).executeScript("arguments[0].click();", addToCartButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("customer navigates to checkout page and sees the selected {string}")
    public void userNavigatesToCheckoutPage(String product) throws InterruptedException {
        // find shopping cart button and scroll to it
        WebElement shoppingCartButton = customerDriver.findElement(By.xpath("//*[@id='cart']/div[1]/button[1]"));
        // scroll to the element
        ((JavascriptExecutor) customerDriver).executeScript("arguments[0].scrollIntoView(true);", shoppingCartButton);
        Thread.sleep(1000);
        // proceed to checkout
        WebElement cartInformation = customerDriver.findElement(By.xpath("//*[@id='cart']/div[1]/button[1]"));
        cartInformation.click();
        WebElement checkout = customerDriver.findElement(By.xpath("//*[@id='cart']/div[1]/ul[1]/li[1]/div[1]/p[1]/a[2]/strong[1]"));
        checkout.click();


        // find checkoutWindow and scroll to it
        WebElement checkoutWindow = customerDriver.findElement(By.xpath("//*[@id='checkout-confirm']/div/table/tbody/tr/td[1]"));
        // scroll to the element
        ((JavascriptExecutor) customerDriver).executeScript("arguments[0].scrollIntoView(true);", checkoutWindow);
        Thread.sleep(1000);
        // Assert that the product is added to the cart
        WebElement productName = customerDriver.findElement(By.xpath("//*[@id='checkout-confirm']/div/table/tbody/tr/td/a[1]"));
        assert(productName.getText().equals(product));

        // We can see that there is no error for quantity of 2
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------------------------------------------
    // opens the browser and navigates to the admin dashboard
    @Given("admin is on 'Admin Dashboard page'")
    public void adminInDashboard() {
        // initialize the Chrome driver
        System.setProperty("webdriver.chrome.driver", chrome_path);
        this.adminDriver = new ChromeDriver();
        this.adminWait = new WebDriverWait(adminDriver, Duration.ofSeconds(40));
        // navigate to the website admin page
        adminDriver.get("http://localhost/opencartsite/admin1/index.php?route=common/login");
        // set the window position
        adminDriver.manage().window().setPosition(new Point(5, 5));
        // Set window size to 1000x1000
        Dimension dimension = new Dimension(1000, 1000);
        adminDriver.manage().window().setSize(dimension);
        // We can see that there is no error for quantity of 2
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // user logs in with the given email and password
    @When("admin is logged in with {string} and {string}")
    public void adminIsLoggedInWithUsernameAndPassword(String username, String password) throws InterruptedException {
        // find the username input and fill it with the given username
        adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-username']"))).sendKeys(username);
        // find the password input and fill it with the given password
        adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys(password);
        // find the login button and click it;
        WebElement login = adminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type=\"submit\"]")));
        login.click();
        // wait a few seconds for the page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // admin navigates to the catalog page
    @And("admin navigates to Catalog")
    public void adminOnCatalog() {
        // navigate to |||
        WebElement navigationButton = adminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[@id='container']/header[@id='header']/div[@class='container-fluid']/button[@id='button-menu']/i[@class='fa-solid fa-bars']")));
        navigationButton.click();
        // find the catalog button and click it
        WebElement catalogButton = adminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu-catalog']/a[1]")));
        catalogButton.click();
    }

    // admin navigates to the product page
    @And("admin clicks on Products")
    public void adminClicksProducts() {
        // wait for products button to be visible
        WebElement productsButton = adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse-1']/li[2]/a[1]")));
        // click on products button
        productsButton.click();
    }

    // admin navigates to the product
    @And("Admin clicks on Edit of a specific {string}")
    public void adminEditsProduct(String product) throws InterruptedException {
        // find filter icon and click it
        WebElement filterIcon = adminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[@id='container']/div[@id='content']/div[@class='page-header']/div[@class='container-fluid']/div[@class='float-end']/button[@class='btn btn-light d-lg-none']")));
        filterIcon.click();
        Thread.sleep(2000);
        // wait for filter sidebar to be visible, and then send the product name to the matching field
        adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-name']"))).sendKeys(product);
        // scroll into view of "sales" which is a little below filter button
        WebElement filterButton = adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form-filter']/div/button[1]")));
        // scroll to the filter button
        ((JavascriptExecutor) adminDriver).executeScript("arguments[0].scrollIntoView(true);", filterButton);
        // wait for it to be visible
        Thread.sleep(1000);
        adminWait.until(ExpectedConditions.elementToBeClickable(filterButton)).click();

        // scroll into product header
//        WebElement productHeader = adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[1]")));
//        // scroll to the productHeader button
//        ((JavascriptExecutor) adminDriver).executeScript("arguments[0].scrollIntoView(true);", productHeader);
        Thread.sleep(1500);
        WebElement edit = adminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-product\"]/div[1]/table/tbody/tr/td[7]/div/a")));
        edit.click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Admin navigates to Data tab")
    public void adminNavigatesToDataTab() {
        // find the data tab and click it
        WebElement dataTab = adminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form-product']/ul[1]/li[2]/a[1]")));
        dataTab.click();
    }

    @And("Admin sets the max quantity to 1")
    public void adminSetsMaxQuantityToOne() throws InterruptedException {
        // find the quantity input and fill it with the given quantity
        WebElement quantityInput = adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name, \"quantity\")]")));
        ((JavascriptExecutor) adminDriver).executeScript("arguments[0].scrollIntoView(true);", quantityInput);
        Thread.sleep(1000);

        quantityInput.clear();
        quantityInput.sendKeys("1");

        assert (quantityInput.getAttribute("value").equals("1"));
    }

    @Then("Admin clicks on Save - Max quantity successfully set to 1")
    public void adminClicksSave() throws InterruptedException {
        // find the save button and click it
        WebElement saveButton = adminWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='content']/div/div/div/button[1]")));
        ((JavascriptExecutor) adminDriver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        Thread.sleep(1000);

        saveButton.click();
    }

    // ----------------------------------------------------------------------------------------
    @After
    public void clearShoppingCart() throws InterruptedException {
        // if user driver is not null
        if (customerDriver != null) {
            // find add to cart button and scroll to it
            WebElement addToCartButton = customerDriver.findElement(By.xpath("//*[@id='cart']/div[1]/button[1]"));
            // scroll to the element
            ((JavascriptExecutor) customerDriver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
            Thread.sleep(1000);
            // remove the products from the cart of user driver
            WebElement cartInformation = customerDriver.findElement(By.xpath("//*[@id='cart']/div[1]/button[1]"));
            cartInformation.click();
            WebElement removeButton = customerDriver.findElement(By.xpath("//*[@id='cart']/div/ul/li/table/tbody/tr/td/form/button[1]"));
            removeButton.click();
            // wait a few seconds for the page to finish
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // close the browser
            customerDriver.quit();
        }
        if (adminDriver != null) {
            // close the browser
            adminInDashboard();
            adminIsLoggedInWithUsernameAndPassword("admin", "1234");
            adminOnCatalog();
            adminClicksProducts();
            adminEditsProduct("iMac");
            adminNavigatesToDataTab();

            // find the quantity input and fill it with the given quantity
            WebElement quantityInput = adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name, \"quantity\")]")));
            ((JavascriptExecutor) adminDriver).executeScript("arguments[0].scrollIntoView(true);", quantityInput);
            Thread.sleep(1000);

            quantityInput.clear();
            quantityInput.sendKeys("997");
            adminClicksSave();
        }
    }
}
