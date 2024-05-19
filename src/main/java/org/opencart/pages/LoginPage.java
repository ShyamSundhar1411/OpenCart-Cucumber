package org.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
    private final WebDriver driver;
    private final  By emailInputLocator = By.name("email");
    private final By passwordInputLocator = By.name("password");
    private final By loginButtonLocator = By.xpath("//input[@type='submit']");
    private final By forgotPasswordLinkLocator = By.linkText("Forgotten Password");
    private final By logoutLinkLocator = By.linkText("Logout");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickForgetPassword(){
        WebElement forgotPasswordLink = driver.findElement(forgotPasswordLinkLocator);
        forgotPasswordLink.click();
    }
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPasswordPageUrl(){
        return driver.getCurrentUrl();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }
}

