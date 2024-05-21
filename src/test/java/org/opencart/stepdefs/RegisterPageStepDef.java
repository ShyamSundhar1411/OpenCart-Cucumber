package org.opencart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.github.javafaker.Faker;
import org.opencart.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterPageStepDef {
    private WebDriver driver;
    private RegisterPage registerPage;
    private Faker faker;
    @Before
    public void setup(){
        driver = new ChromeDriver();
        faker = new Faker();
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
    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        registerPage = new RegisterPage(driver);
    }

    @Given("I have entered valid credentials for registration")
    public void iHaveEnteredValidCredentialsForRegistration() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String telephone = faker.phoneNumber().cellPhone();
        String password = faker.internet().password(8, 10);

        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterTelephone(telephone);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.setPrivacy();

    }

    @When("I click on register button")
    public void iClickOnRegisterButton() {
        registerPage.clickRegister();
    }

    @Then("I should be registered successfully")
    public void iShouldBeRegisteredSuccessfully() {
        Assert.assertTrue(registerPage.checkLogoutButton());
    }

    @Given("I have entered {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iHaveEntered(String firstName, String lastName, String email, String telephone, String password, String confirmPassword, String privacyAgreement) {
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterTelephone(telephone);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        if (privacyAgreement.equals("true")) {
            registerPage.setPrivacy();
        }
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed()||driver.findElement(By.className("text-danger")).isDisplayed());
    }
}
