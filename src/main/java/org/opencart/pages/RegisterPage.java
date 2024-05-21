package org.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class RegisterPage {
    private final WebDriver driver;
    private final By firstNameInputLocator = By.name("firstname");
    private final By lastNameInputLocator = By.name("lastname");
    private final By emailInputLocator = By.name("email");
    private final By telephoneInputLocator = By.name("telephoneInputLocator");
    private final By passwordInputLocator = By.name("password");
    private final By confirmPasswordInputLocator = By.name("confirm");
    private final By privacyInputLocator = By.xpath("//input[@type='checkbox' and @name='agree']");
    private final By registerButtonLocator = By.xpath("//input[@type='submit']");
    RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterFirstName(String firstName){
        WebElement firstNameElement = driver.findElement(firstNameInputLocator);
        firstNameElement.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        WebElement lastNameElement = driver.findElement(lastNameInputLocator);
        lastNameElement.sendKeys(lastName);
    }
    public void enterEmail(String email){
        WebElement emailElement = driver.findElement(emailInputLocator);
        emailElement.sendKeys(email);
    }
    public void enterTelephone(String telephone){
        WebElement telephoneElement = driver.findElement(telephoneInputLocator);
        telephoneElement.sendKeys(telephone);
    }
    public void enterPassword(String password){
        WebElement passwordElement = driver.findElement(passwordInputLocator);
        passwordElement.sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword){
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordInputLocator);
        confirmPasswordElement.sendKeys(confirmPassword);
    }
    public void setPrivacy(String value){
        WebElement privacyElement = driver.findElement(privacyInputLocator);
        privacyElement.sendKeys(value);
    }
    public void clickRegister(){
        WebElement registerButton = driver.findElement(registerButtonLocator);
        registerButton.click();
    }

}