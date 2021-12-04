package steps;

import io.qameta.allure.Attachment;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseSteps {

    Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.get("http://www.sberbank.ru/ru/person");
        //ожидание 30 секунд
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //развернуть окно браузера
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        //закрыть браузер
        driver.quit();
    }

    protected void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }

    public void checkError(String value, WebElement element) {
        assertEquals(value, element.getText());
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
