package stage4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private LoginPage loginPage ;
    private WebElement buttonLogin;

    @BeforeMethod (alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("Creating Driver");
        System.setProperty("webdriver.chrome.driver", "C:/Automation/Drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://qa-trainingw7:86/");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("Deleting Driver");
        driver.quit();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Starting Execution");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Completing Execution");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Executing class: LoginTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: LoginTest");
    }


    @Test
    public void testVerifyLoginPageIsDisplayed() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        loginPage.clickOnElement(loginPage.getLoginLink());
        assertTrue(loginPage.isElementPresent(loginPage.getLoginTitlePage()));
    }

    @Test
    public void testVerifyLoginValidCredentials() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        loginPage.clickOnElement(loginPage.getLoginLink());
        loginPage.clearElementsLoginPage();
        loginPage.typeOnElement(loginPage.getUsername(),"svillegas1" );
        loginPage.typeOnElement(loginPage.getPassword(),"!123Test");
        loginPage.clickOnElement(loginPage.getLoginButton());
        assertTrue(loginPage.isElementPresent(loginPage.getMemberName()));
    }

    @Test
    public void testVerifyLoginInvalidCredentials() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        loginPage.clickOnElement(loginPage.getLoginLink());
        loginPage.clearElementsLoginPage();
        loginPage.clearElementsLoginPage();
        loginPage.typeOnElement(loginPage.getUsername(),"TestSandra" );
        loginPage.typeOnElement(loginPage.getPassword(),"invalidPass");
        loginPage.clickOnElement(loginPage.getLoginButton());
        assertTrue(loginPage.isElementPresent(loginPage.getInvalidLoginMessage()));

    }

}
