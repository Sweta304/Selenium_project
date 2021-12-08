package steps;

import io.qameta.allure.Step;
import pages.InsuranceAllTypes;

public class InsuranceAllTypesSteps {

    @Step("Выбран пункт меню Страхование путешественников")
    public void selectTravelIns (){
        new InsuranceAllTypes().insForTravellers.click();
    }
}
