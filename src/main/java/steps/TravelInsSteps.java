package steps;

import io.qameta.allure.Step;
import pages.TravelInsPage;

public class TravelInsSteps extends BaseSteps{

    @Step ("Нажатие на кнопку Оформить онлайн")
    public void goToOnlineReg(){
        new TravelInsPage(driver).onlineReg.click();
    }

    @Step ("Переход на оформление на сайте")
    public void goToSiteReg(){
        new TravelInsPage(driver).siteReg.click();
    }

}
