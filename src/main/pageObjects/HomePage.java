package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage clickSignInButton(){
        WebElement signInButton = driver.findElement(By.className("hide_xs"));
        signInButton.click();
        return new AuthenticationPage(driver);
    }
}
