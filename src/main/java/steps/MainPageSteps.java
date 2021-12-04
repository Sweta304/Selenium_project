package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;

public class MainPageSteps extends BaseSteps {

    @Step("Выбран регион")
    public void selectRegion (){
        new MainPage(driver).region.click();
    }

    @Step("Подтверждение использования cookies")
    public void cookiesConfirmation(){
        Actions actions = new Actions(driver);
        actions.moveToElement(new MainPage(driver).cookie, 0, 0);
        actions.moveByOffset(-50, 5).click().build().perform();
    }

    @Step("Переход в меню Страхование")
    public void goToInsurance(){
        new MainPage(driver).ins.click();
    }

    @Step("Переход на все страховые программы")
    public void goToAllInsPrograms(){
        new MainPage(driver).allInsProgramms.click();
    }

}
