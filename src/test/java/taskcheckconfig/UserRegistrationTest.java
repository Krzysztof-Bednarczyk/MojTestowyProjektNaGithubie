package taskcheckconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistrationTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        // zadanie 3

        WebElement signInButton = driver.findElement(By.className("hide_xs"));
        signInButton.click();

        // spacje nie zadziałają w classname więc możemy użyć jednej wybranej mądrze klasy
        // WebElement emailInput = driver.findElement(By.className("account_input"));
        // albo zrobić css selector
        WebElement emailInput = driver.findElement(By.cssSelector(".is_required.validate.account_input.form-control"));
        emailInput.sendKeys(GenerateEmail.withTimestamp());

        WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
        createAccountButton.click();

        // zanim poszukamy kolejnych elementów dajmy chwilę stronie na przeładowanie
        // zadanie domowe dla Was pozbyć się tych waitów -> https://www.selenium.dev/documentation/webdriver/waits/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // zadanie 4
        // wypełnianie formularza rejestracji
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstNameInput.sendKeys("Adam");
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastNameInput.sendKeys("Słodowy");


        // to możemy pominąć, bo email jest przepisany z poprzedniej strony
        WebElement secondEmailInput = driver.findElement(By.xpath("//input[@id='email']"));
        secondEmailInput.click();
        secondEmailInput.clear();
        secondEmailInput.sendKeys(GenerateEmail.withTimestamp());

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='passwd']"));
        passwordInput.sendKeys("password1");

        WebElement registerButton = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        registerButton.click();

        // znowu pauza, bo przeładowywujemy stronę
        // zadanie domowe dla Was pozbyć się tych waitów -> https://www.selenium.dev/documentation/webdriver/waits/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // zadanie 5
        WebElement myPersonalInformationLink = driver.findElement(By.cssSelector("a[title='Information']"));
        WebElement myAddressesLink = driver.findElement(By.cssSelector("a[title='Addresses']"));
    }
}
