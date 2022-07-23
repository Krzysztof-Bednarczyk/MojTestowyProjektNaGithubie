package pageObjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPersonalInfoLink(String expectedText){
        WebElement myPersonalInformationLink = driver.findElement(By.cssSelector("a[title='Information']"));
        Assertions.assertThat(myPersonalInformationLink.getText()).isEqualTo(expectedText);
    }

}
