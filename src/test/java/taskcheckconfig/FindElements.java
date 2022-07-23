package taskcheckconfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {

    public static void main(String[] args) {
        final String MY_STORE_URL = "https://mystore-testlab.coderslab.pl/index.php";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"); // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        WebDriver driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki
        driver.get(MY_STORE_URL);

        WebElement buttonByTag = driver.findElement(By.tagName("button")); // znajdowanie elementu po nazwie taga
        List<WebElement> buttonsByTag = driver.findElements(By.tagName("button")); // znajdowanie wszystkich elementów po nazwie taga

        WebElement divByClassname = driver.findElement(By.className("float-xs-left")); // znajdowanie elementu po atrybucie class
        List<WebElement> divsByClassname = driver.findElements(By.className("float-xs-left")); // znajdowanie elementów po atrybucie class

        WebElement divById = driver.findElement(By.id("menu-icon")); // znajdowanie elementu po atrybucie id - rekomendowana opcja
        // jak HTML jest dobrze skonstruowany to id jest unikalne i raczej nie znajdziemy listy elementów po id - driver znajdzie listę z 1 elementem
        List<WebElement> divsById = driver.findElements(By.id("menu-icon")); // znajdowanie listy - raczej będzie to lista 1-elementowa

        WebElement inputByName = driver.findElement(By.name("email")); // znajdowanie elementu po atrybucie name
        List<WebElement> inputsByName = driver.findElements(By.name("email")); // znajdowanie elementów po atrybucie name

        WebElement link = driver.findElement(By.linkText("Prices drop")); // znajdowanie elementu po tekście linku
        List<WebElement> links = driver.findElements(By.linkText("Prices drop")); // znajdowanie elementu po tekście linku

        WebElement partialLink = driver.findElement(By.partialLinkText("Prices")); // znajdowanie elementu po częściowym tekście linku
        List<WebElement> partialLinks = driver.findElements(By.partialLinkText("Prices")); // znajdowanie elementu po częściowym tekście linku

        WebElement inputByCssSelector = driver.findElement(By.cssSelector("input.form-control[name=\"email\"]")); // znajdowanie elementu używając css selectora
        List<WebElement> inputsByCssSelector = driver.findElements(By.cssSelector("input.form-control[name=\"email\"]")); // znajdowanie elementów używając css selectora

        WebElement elementByXpath = driver.findElement(By.xpath("//a[contains(text(),'Art')]")); // loaklizowanie elementu przez xpath
        List<WebElement>  elementsByXpath = driver.findElements(By.xpath("//a[contains(text(),'Art')]")); // lokalizowanie elementów przez xpath

        String xpath = "//body/main[1]/section[]/div[1]/div[1]/section[1]/section[1]/section[1]/form[1]/section[1]/div[1]/div[1]/input[1]";
        String cssSelector = "input[name=\"email\"].form-control";
    }
}
