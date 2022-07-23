package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {

    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccountPage createAccount(String email){
        WebElement emailInput = driver.findElement(By.cssSelector(".is_required.validate.account_input.form-control"));
        emailInput.sendKeys(email);

        WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
        createAccountButton.click();

        // zanim poszukamy kolejnych elementów dajmy chwilę stronie na przeładowanie
        // zadanie domowe dla Was pozbyć się tych waitów -> https://www.selenium.dev/documentation/webdriver/waits/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new CreateAccountPage(driver);
    }

    public void loginUser(String email, String password){
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
