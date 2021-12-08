package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PolicyChoice;
import java.util.ArrayList;


public class PolicyChoiceSteps{

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
    @Step ("переход на страницу Страхование путешественников")
    public void goToTravelInsApply () {
        ArrayList<String> tabs2 = new ArrayList<String>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs2.get(1));
        wait.until(ExpectedConditions.visibilityOf(
                new PolicyChoice().apply));
        new PolicyChoice().apply.click();
    }

}
