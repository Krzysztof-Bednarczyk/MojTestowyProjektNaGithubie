package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchSteps {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        // zgadzamy się na cookie
        WebElement agreeButton = driver.findElement(By.id("L2AGLb"));
        agreeButton.click();
    }

    @When("^a keyword (.*) is entered in input field")
    public void enterKeyword(String keyword){
        // wpisujemy tekst do wyszukiwarki
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();
    }

    @Then("^the first one should contain (.*)")
    public void verifyContent(String result){
        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3.LC20lb"));
        String actualText = searchResults.get(0).getText();
        Assertions.assertThat(actualText).contains(result);
    }

    @And("close browser")
    public void closeBrowser(){
        driver.quit();
    }
}
