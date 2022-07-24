package pageFactoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".room_cont")
    List<WebElement> searchResultList;

    @FindBy(css = ".ajax_add_to_cart_button")
    List<WebElement> bookingButtons; // [BOOK NOW, BOOK NOW, BOOK NOW]

    @FindBy(css = ".layer_cart_product>h2")
    WebElement bookingMessage;

    public List<WebElement> getSearchResultList() {
        return searchResultList;
    }

    public void bookARoom(int index){
        bookingButtons.get(index).click(); // [BOOK NOW, BOOK NOW, BOOK NOW] -> get(0)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getBookingMessage(){
        return bookingMessage.getText();
    }

    public String getMessageColor(){
        return bookingMessage.getCssValue("color");
    }
}
