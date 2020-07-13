package stage3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertTrue;

public class RegisterTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod(alwaysRun = true)
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
        System.out.println("Executing class: RegistrerTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: RegistrerTest");
    }


    @Test
    public void testVerifyRegistrerLink() throws Exception {
        System.out.println("Executing Register test:testVerifyRegistrerLink");
        driver.get("http://qa-trainingw7:86/");
        driver.findElement(By.xpath("//a[@id='ctl00_LoginView_RegisterLink']")).click();
        assertTrue(isElementPresent(By.xpath("//h2[contains(.,'Register')]")));
    }

    @Test
    public void testValidateMandatoryMessages() throws Exception {
        System.out.println("Executing Register test:testValidateMandatoryMessages");
        driver.get("http://qa-trainingw7:86/");
        driver.findElement(By.xpath("//a[@id='ctl00_LoginView_RegisterLink']")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton']")).click();
        assertTrue(isElementPresent(By.xpath("//span[@title='First name is required.' and contains(@style,'inline')]")));
        assertTrue(isElementPresent(By.xpath("//span[@title='Last name is required.' and contains(@style,'inline')]")));
        assertTrue(isElementPresent(By.xpath("//span[@title='Email is required.' and contains(@style,'inline')]")));
        assertTrue(isElementPresent(By.xpath("//span[@title='User name is required.' and contains(@style,'inline')]")));
        assertTrue(isElementPresent(By.xpath("//span[@title='Password is required.' and contains(@style,'visible')]")));
        assertTrue(isElementPresent(By.xpath("//span[@title='Confirm password is required.' and contains(@style,'visible')]")));
        assertTrue(isElementPresent(By.xpath("//span[@title='Security question is required.' and contains(@style,'visible')]")));
        assertTrue(isElementPresent(By.xpath("//span[@title='Security answer is required.' and contains(@style,'visible')]")));
    }

    @Test
    public void testVerifyUserNameAlreadyTaken() throws Exception {
        System.out.println("Executing Register test:testVerifyUserNameAlreadyTaken");
        driver.get("http://qa-trainingw7:86/");
        driver.findElement(By.id("ctl00_LoginView_RegisterLink")).click();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")).sendKeys("Sandra");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")).sendKeys("Villegas");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")).sendKeys("test@avantica.com");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")).sendKeys("svillegas");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")).sendKeys("!123Test");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")).sendKeys("!123Test");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")).sendKeys("test");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton']")).click();
        assertTrue(isElementPresent(By.xpath("//span[contains(.,'User name already exists. Please enter a different user name.')]")));
    }

    @Test
    public void testVerifyMismatchedPasswords() throws Exception {
        System.out.println("Executing Register test:testVerifyMismatchedPasswords");
        driver.get("http://qa-trainingw7:86/");
        driver.findElement(By.id("ctl00_LoginView_RegisterLink")).click();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")).sendKeys("Sandra");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")).sendKeys("Villegas");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")).sendKeys("test@avantica.com");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")).sendKeys("test123");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")).sendKeys("!123test");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")).sendKeys("!123Test");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")).sendKeys("test");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")).clear();
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")).sendKeys("test");
        driver.findElement(By.id("ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton")).click();
        assertTrue(isElementPresent(By.xpath("//span[contains(@style,'inline') and contains(.,'The password and confirmation password must match.' )]")));
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
