package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsuranceAllTypes extends BasePage {

    @FindBy(xpath="//h3[contains(text(),'Страхование путешественников')]")
    public static WebElement insForTravellers;

    public InsuranceAllTypes () {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
