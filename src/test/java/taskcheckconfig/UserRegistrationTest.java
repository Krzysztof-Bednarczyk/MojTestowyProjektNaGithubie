package taskcheckconfig;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static taskcheckconfig.GenerateEmail.withTimestamp;

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
        emailInput.sendKeys(withTimestamp());

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
        secondEmailInput.sendKeys(withTimestamp());

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

        WebElement slider = driver.findElement(By.id("slider_row"));

        WebElement iconBuilding = driver.findElement(By.className("icon-building"));

        System.out.println(myPersonalInformationLink.getText()); // drukujemy do konsoli tekst z znalezionego elementu
        // - tekst jest od razu sformatowany, tak
        // jak go widzimy na stronie
        System.out.println(myAddressesLink.getText()); // drukujemy do konsoli tekst z znalezionego elementu

        System.out.println(slider.getAttribute("class")); // drukujemy atrybut elementu slider - atrybut class
        System.out.println(slider.getTagName()); // drukujemy nazwę tag'a(znacznika) - div

        System.out.println(iconBuilding.isDisplayed() + "  wyświetla się");
        System.out.println(iconBuilding.isEnabled() + "  jest aktywny");
        System.out.println(iconBuilding.isSelected() + "  jest zaznaczony");

        Assertions.assertThat(iconBuilding.isDisplayed()).isTrue();

    }
}
