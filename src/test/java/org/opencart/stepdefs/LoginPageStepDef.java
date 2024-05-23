package org.opencart.stepdefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
public class LoginPageStepDef {
    private WebDriver driver;
    private LoginPage loginPage;
    private Properties properties;

    @Before
    public void setup(){
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
        if(driver!=null){
            try {
                Thread.sleep(3000); // Delay for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

    @Given("I am on OpenCart login page")
    public void iAmOnOpenCartLoginPage() {
        String loginUrl = properties.getProperty("login.url");
        driver.get(loginUrl);
        loginPage = new LoginPage(driver);
    }


    @Given("I have entered a valid username and password")
    public void iHaveEnteredAValidUsernameAndPassword() {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }


    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        Assert.assertTrue(loginPage.checkLogoutLink());
        
    }

    @When("I login with my credentials")
    public void iLoginWithMyCredentials() {
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
        loginPage.clickLoginButton();
    }

    @Given("I have entered invalid {string} and {string}")
    public void iHaveEnteredInvalidAnd(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        
    }

    @Then("I should see an error message indicating {string}")
    public void iShouldSeeAnErrorMessageIndicating(String errorMessage) {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed());
    }

    @When("I click on the Forgotten Password link")
    public void iClickOnTheForgottenPasswordLink(){
        loginPage.clickForgetPassword();
    }

    @Then("I should be redirected to the password reset page")
    public void iShouldBeRedirectedToThePasswordResetPage() {
        Assert.assertTrue(loginPage.getForgotPasswordPageUrl().contains("account/forgotten"));

    }
}
