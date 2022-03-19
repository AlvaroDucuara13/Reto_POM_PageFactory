package co.com.sofka.StepDefinition.SetUp;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUi {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";

    private static final String PARABANK_URL = "https://parabank.parasoft.com/parabank/index.htm";

    protected WebDriver driver;

    protected void setUpWebDriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void generalSetUp(){
        driver = new ChromeDriver();
        driver.get(PARABANK_URL);
        driver.manage().window().maximize();
    }

    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quiteDriver(){
        driver.quit();
    }

}
