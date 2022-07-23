package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountPage registerUser(String firstName, String lastName, String password){
        // wypełnianie formularza rejestracji
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastNameInput.sendKeys(lastName);

        // to możemy pominąć, bo email jest przepisany z poprzedniej strony
        WebElement secondEmailInput = driver.findElement(By.xpath("//input[@id='email']"));
        secondEmailInput.click();

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='passwd']"));
        passwordInput.sendKeys(password);

        WebElement registerButton = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        registerButton.click();

        // znowu pauza, bo przeładowywujemy stronę
        // zadanie domowe dla Was pozbyć się tych waitów -> https://www.selenium.dev/documentation/webdriver/waits/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AccountPage(driver);
    }
}
