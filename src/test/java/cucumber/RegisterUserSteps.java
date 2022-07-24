package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactoryObjects.HomeFactoryPage;
import pageObjects.AccountPage;
import pageObjects.AuthenticationPage;
import pageObjects.CreateAccountPage;

import static taskcheckconfig.GenerateEmail.withTimestamp;

public class RegisterUserSteps {

    private WebDriver driver;

    private static final String EXPECTED_TEXT = "MY PERSONAL INFORMATION";
    private static final String PASSWORD = "password1";
    private static final String EXPECTED_BOOKING_MESSAGE = "Room successfully added to your cart";
    private static final String EXPECTED_MESSAGE_COLOR_RGBA_VALUE = "rgba(70, 167, 78, 1)";


    private String email;
    private HomeFactoryPage homeFactoryPage;
    private AuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;
    private AccountPage accountPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        email = withTimestamp();
    }

    @Given("unregistered user is on home page")
    public void openHomePage() {
        homeFactoryPage = new HomeFactoryPage(driver);
        homeFactoryPage.openPage();
    }

    @When("user clicks on sign in button")
    public void clickSignIn() {
        authenticationPage = homeFactoryPage.clickSignInButton();
    }

    @And("provides new email address")
    public void authenticate() {
        createAccountPage = authenticationPage.createAccount(email);
    }

    @And("^fills form with (.*) (.*) (.*)$")
    public void fillForm(String firstName, String lastName, String password){
        accountPage = createAccountPage.registerUser(firstName, lastName, password);
    }

    @Then("new user is created")
    public void userCreation(){
        Assertions.assertThat(accountPage.getMyPersonalLinkText()).isEqualTo(EXPECTED_TEXT);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
