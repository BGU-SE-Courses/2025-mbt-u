package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;
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
        customerDriver.findElement(By.xpath("/html/body/nav[@id='top']/div[@class='container']/div[@class='nav float-end']/ul[@class='list-inline']/li[@class='list-inline-item'][2]/div[@class='dropdown']/a[@class='dropdown-toggle']/span[@class='d-none d-md-inline']")).click();
        // find the login link and click it
        customerWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav[@id='top']/div[@class='container']/div[@class='nav float-end']/ul[@class='list-inline']/li[@class='list-inline-item'][2]/div[@class='dropdown']/ul[@class='dropdown-menu dropdown-menu-right show']/li[2]/a[@class='dropdown-item']"))).click();
        // find the email input and fill it with the given email
        customerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-email']"))).sendKeys(email);
        // find the password input and fill it with the given password
        customerWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-password']"))).sendKeys(password);
        // find the login button and click it
        customerWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form-login']/div/button[1]"))).click();
        // wait a few seconds for the page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
