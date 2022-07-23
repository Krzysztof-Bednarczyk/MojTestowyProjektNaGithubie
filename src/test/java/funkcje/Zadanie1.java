package funkcje;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taskcheckconfig.GenerateEmail;

import java.time.Duration;

public class Zadanie1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/my-account");
        WebElement email = driver.findElement(By.id("email_create"));
        email.sendKeys(GenerateEmail.withTimestamp());
        WebElement createAnAccount = driver.findElement(By.id("SubmitCreate"));
        createAnAccount.click();

        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='customer_firstname']")));

        WebElement firstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        if (firstName.isDisplayed()) {
            firstName.sendKeys("Blablabla");
        } else {
//            Assert.fail();
            System.out.println("firstName - not displayed");
        }
        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        Assertions.assertThat(lastName.isDisplayed()).isTrue();
        lastName.sendKeys("Balbla");


        WebElement email2 = driver.findElement(By.xpath("//input[@id='email']"));
        if (email2.isDisplayed()) {
            System.out.println("email2 - is displayed");
            ;
        } else {
//            Assert.fail();
            System.out.println("email - not displayed");
        }
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        if (password.isDisplayed()) {
            password.sendKeys("Boom123!@#");
        } else {
//            Assert.fail();
            System.out.println("password - not displayed");
        }
        WebElement register = driver.findElement(By.id("submitAccount"));
        if (register.isDisplayed()) {
            register.click();
        } else {
//            Assert.fail();
            System.out.println("register - not displayed");
        }

    }

}
