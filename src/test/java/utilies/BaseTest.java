package utilies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

public class BaseTest {

    private WebDriver driver;

    public WebDriver createDriver(String browserType, String executionType){

        if(executionType.equals("local")){
            createLocalDriver(browserType);
        }
        else if (executionType.equals("remote")){
            createRemoteDriver(browserType);
        }
        return driver;

    }

    private void createLocalDriver(String browserType){
        try {
            if(browserType.equals("chrome")){
                System.out.println("Creating Local Chrome Driver");
                System.setProperty("webdriver.chrome.driver", "C:/Automation/Drivers/chrome/chromedriver.exe");
                driver = new ChromeDriver();

            }else if (browserType.equals("firefox")) {
                System.out.println("Creating Local Firefox Driver");
                System.setProperty("webdriver.gecko.driver", "C:/Automation/Drivers/firefox/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }catch (NoSuchElementException e){
            System.out.println("Local WebDriver creation exception");
        }
    }

    private void createRemoteDriver(String browserType ) {

        try {
            if(browserType.equals("chrome")){
                System.out.println("Creating Remote Chrome Driver");
                driver = new RemoteWebDriver(new URL("http://10.230.188.19:48795/wd/hub"), new ChromeOptions());

            }else if (browserType.equals("firefox")) {
                System.out.println("Creating Remote Firefox Driver");
                driver = new RemoteWebDriver(new URL("http://10.230.188.19:18035/wd/hub"), new FirefoxOptions());

            }
        }catch (NoSuchElementException e){
            System.out.println("Remote WebDriver creation exception");
        } catch (MalformedURLException e) {
            System.out.println("URL exception");
            e.printStackTrace();

        }
    }


    /*Create remote driver hub and nodes https://www.guru99.com/introduction-to-selenium-grid.html
    ****use ubication of the standalone jar
    * C:\Automation>
    *java -jar selenium-server-standalone-3.141.59.jar -port 4446 -role hub
    ****verify the hub ip address and change
    *java -Dwebdriver.chrome.driver=C:\Automation\Drivers\chrome\chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://10.230.188.19:4446/grid/register/
    *java -Dwebdriver.gecko.driver=C:\Automation\Drivers\firefox\geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://10.230.188.19:4446/grid/register/
    */

}
