package steps;

import io.qameta.allure.Step;
import pages.TravelInsPage;

public class TravelInsSteps {

    @Step ("Нажатие на кнопку Оформить онлайн")
    public void goToOnlineReg(){
        new TravelInsPage().onlineReg.click();
    }

    @Step ("Переход на оформление на сайте")
    public void goToSiteReg(){
        new TravelInsPage().siteReg.click();
    }

}
