package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyChoice extends BasePage{

    @FindBy(xpath="//button[contains(text(),'Оформить')]")
    public static WebElement apply;

    public PolicyChoice(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
