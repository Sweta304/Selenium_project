package steps;

import io.qameta.allure.Step;
import pages.InsuranceAllTypes;
import pages.MainPage;

public class InsuranceAllTypesSteps extends BaseSteps{

    @Step("Выбран пункт меню Страхование путешественников")
    public void selectTravelIns (){
        new InsuranceAllTypes(driver).insForTravellers.click();
    }
}
