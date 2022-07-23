package pageobjectpattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactoryObjects.HomeFactoryPage;
import pageFactoryObjects.SearchResultsPage;
import pageObjects.AccountPage;
import pageObjects.AuthenticationPage;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;

import java.util.List;

import static taskcheckconfig.GenerateEmail.withTimestamp;

public class RegistrationTest {

    private WebDriver driver;

    private static final String EXPECTED_TEXT = "MY PERSONAL INFORMATION";
    private static final String PASSWORD = "password1";

    private String email;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        email = withTimestamp();
    }

    @Test
    void registrationTest(){
        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        CreateAccountPage createAccountPage = authenticationPage.createAccount(email);
        AccountPage accountPage = createAccountPage.registerUser("Adam", "Słodowy", PASSWORD);
        Assertions.assertThat(accountPage.getMyPersonalLinkText()).isEqualTo(EXPECTED_TEXT);
    }

    @Test
    void searchForHotel(){
        HomeFactoryPage homePage = new HomeFactoryPage(driver);
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        CreateAccountPage createAccountPage = authenticationPage.createAccount(withTimestamp());
        createAccountPage.registerUser("Adam", "Słodowy", PASSWORD);
        homePage.openPage();
        SearchResultsPage searchResultsPage = homePage.searchForHotel();
        List<WebElement> list = searchResultsPage.getSearchResultList();
        Assertions.assertThat(list).isNotEmpty();
    }
    @AfterEach
    void tearDown(){
        driver.close();
    }
}
