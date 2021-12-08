package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class TravelInsPage extends BasePage{
    @FindBy(xpath="//span[contains(@class,'kitt-button__text')][contains(text(),'Оформить онлайн')]")
    public static WebElement onlineReg;

    @FindBy(xpath="//span[contains(@class,'kitt-button__text')][contains(text(),'Оформить на сайте')]")
    public static WebElement siteReg;

    public TravelInsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
