package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class PolicyChoice extends BasePage{

    @FindBy(xpath="//button[contains(text(),'Оформить')]")
    public static WebElement apply;

    public PolicyChoice() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
