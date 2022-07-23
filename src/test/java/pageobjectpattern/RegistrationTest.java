package pageobjectpattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AccountPage;
import pageObjects.AuthenticationPage;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;

import static taskcheckconfig.GenerateEmail.withTimestamp;

public class RegistrationTest {

    private WebDriver driver;

    private static final String EXPECTED_TEXT = "MY PERSONAL INFORMATION";

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    void registrationTest(){
        HomePage homePage = new HomePage(driver);
        AuthenticationPage authenticationPage = homePage.clickSignInButton();
        CreateAccountPage createAccountPage = authenticationPage.createAccount(withTimestamp());
        AccountPage accountPage = createAccountPage.registerUser("Adam", "Słodowy", "password1");
        accountPage.verifyPersonalInfoLink(EXPECTED_TEXT);
    }

    @AfterEach
    void tearDown(){
        driver.close();
    }
}
