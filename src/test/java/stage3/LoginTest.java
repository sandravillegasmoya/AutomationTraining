package stage3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod (alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("Creating Driver");
        System.setProperty("webdriver.chrome.driver", "C:/Automation/Drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://qa-trainingw7:86/");
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
        System.out.println("Executing Login test:testVerifyLoginPageIsDisplayed");
        driver.get("http://qa-trainingw7:86/");
        driver.findElement(By.id("ctl00_LoginView_LoginLink")).click();
        assertTrue(isElementPresent(By.xpath("//h2[contains(.,'Login')]")));
    }

    @Test
    public void testVerifyLoginValidCredentials() throws Exception {
        System.out.println("Executing Login test:testVerifyLoginValidCredentials");
        driver.get("http://qa-trainingw7:86/");
        driver.findElement(By.id("ctl00_LoginView_LoginLink")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_UserName']")).clear();
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_UserName']")).sendKeys("svillegas1");
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_Password']")).clear();
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_Password']")).sendKeys("!123Test");
        driver.findElement(By.id("ctl00_Main_LoginConrol_LoginButton")).click();
        assertTrue(isElementPresent(By.xpath("//div[@id='nav_login']/span[@id='ctl00_LoginView_MemberName']")));
    }

    @Test
    public void testVerifyLoginInvalidCredentials() throws Exception {
        System.out.println("Executing Login test:testVerifyLoginInvalidCredentials");
        driver.get("http://qa-trainingw7:86/");
        driver.findElement(By.id("ctl00_LoginView_LoginLink")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_UserName']")).clear();
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_UserName']")).sendKeys("TestSandra");
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_Password']")).clear();
        driver.findElement(By.xpath("//input[@id='ctl00_Main_LoginConrol_Password']")).sendKeys("invalidPass");
        driver.findElement(By.id("ctl00_Main_LoginConrol_LoginButton")).click();
        assertTrue(isElementPresent(By.xpath("//td[contains(.,'Your login attempt was not successful. Please try again.') and contains(@style,'Red')]")));
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
