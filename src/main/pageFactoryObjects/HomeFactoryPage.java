package pageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AuthenticationPage;

import java.util.List;

public class HomeFactoryPage {

    private WebDriver driver;

    public HomeFactoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "hide_xs")
    WebElement signInButton;

    @FindBy(css = "a[title=\"Log me out\"]")
    List<WebElement> logoutButton;

    @FindBy(css = ".header-rmsearch-input[data-toggle=\"dropdown\"]")
    WebElement hotelDropdown;

    @FindBy(css = ".hotel_name")
    WebElement hotelPrime;

    @FindBy(id = "check_in_time")
    WebElement checkInInput;

    @FindBy(id = "check_out_time")
    WebElement checkOutInput;

    @FindBy(id = "search_room_submit")
    WebElement searchRoomButton;

    public HomeFactoryPage openPage() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        return this;
    }

    public HomeFactoryPage logout() {
        signInButton.click();
        logoutButton.get(1).click();
        return this;
    }

    public AuthenticationPage clickSignInButton() {
        signInButton.click();
        return new AuthenticationPage(driver);
    }

    public SearchResultsPage searchForHotel(){
        hotelDropdown.click();
        hotelPrime.click();
        checkInInput.sendKeys("25-07-2022");
        checkOutInput.sendKeys("26-07-2022");
        searchRoomButton.submit();
        return new SearchResultsPage(driver);
    }
}
