package org.opencart.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private final By addToCartButtonLocator = By.xpath("//h4/a[text()='macbook']/../../following-sibling::div//button[contains(@onclick, 'cart.add')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickAddToCart(){
        WebElement addToCart = driver.findElement(addToCartButtonLocator);
        addToCart.click();
    }
}
