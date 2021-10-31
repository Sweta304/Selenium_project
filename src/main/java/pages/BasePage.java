package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BasePage {
    WebDriver driver;

    public static void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }

    public static void checkError(String value, WebElement element) {
        assertEquals(value, element.getText());
    }
}
