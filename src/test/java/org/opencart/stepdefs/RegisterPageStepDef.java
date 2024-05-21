package org.opencart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.opencart.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class RegisterPageStepDef {
    private WebDriver driver;
    private RegisterPage registerPage;
    @Before
    void setup(){
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        registerPage = new RegisterPage(driver);
    }
}
