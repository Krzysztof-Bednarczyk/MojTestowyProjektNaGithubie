package taskcheckconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ListaElementowDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.bing.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> linkiBinga = driver.findElements(By.cssSelector(".scope"));
        // weź element o indeksie zero z listy i kliknij w niego
        linkiBinga.get(0).click();
        System.out.println(driver.getCurrentUrl());

    }

}
