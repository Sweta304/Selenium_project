package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PolicyChoice;

public class PolicyChoiceSteps extends BaseSteps{

    @Step ("переход на страницу Страхование путешественников")
    public void goToTravelInsApply () {
        wait.until(ExpectedConditions.visibilityOf(
                new PolicyChoice(driver).apply));
        new PolicyChoice(driver).apply.click();
    }

}
