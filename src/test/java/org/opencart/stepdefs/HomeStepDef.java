package org.opencart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.HomePage;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;

public class HomeStepDef {
    private WebDriver driver;
    private HomePage homePage;
    private Properties properties;

    @Before
    void setup(){
        driver = new ChromeDriver();
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @After
    public void tearDown(){
        try {
            Thread.sleep(3000); // Delay for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        String homePageUrl = properties.getProperty("home.url");
        driver.get(homePageUrl);
        homePage = new HomePage(driver);

    }

    @Then("I should be on home page")
    public void iShouldBeOnHomePage() {
        String homePageUrl = properties.getProperty("home.url");
        driver.get(homePageUrl);
        homePage = new HomePage(driver);
    }

    @When("I add a product to cart")
    public void iAddAProductToCart() {
        homePage.clickAddToCart();
    }

    @Then("It should be added to cart successfully")
    public void itShouldBeAddedToCartSuccessfully() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());
    }



}
