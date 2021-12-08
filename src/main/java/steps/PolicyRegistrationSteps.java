package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PolicyRegistration;
import java.util.HashMap;

public class PolicyRegistrationSteps{

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);

    @Step("поле {0} заполняется значением {1}")
    public static void fillField(String field, String value){
        new PolicyRegistration().fillField(field, value);
    }

    @Step("поле {1} заполнено значением {0}")
    public static void checkFillField(String value, String field) {
        new PolicyRegistration().checkFillField(value, field);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k,v)-> fillField(k,v));
    }

    @Step("проверка заполненности полей")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("Ожидает что поле становится видимым")
    public void isVisible(){
        wait.until(ExpectedConditions.elementToBeClickable(
                new PolicyRegistration().insuredSurname));
    }

    @Step("Нажимает кнопку Продолжить")
    public void clickContinue(){
        new PolicyRegistration().continueButton.click();
    }

    @Step("Проверяется наличие сообщений об ошибке")
    public void errorChecking (){
        new PolicyRegistration().checkError("При заполнении данных произошла ошибка",new PolicyRegistration().errorAssert);
        String error_txt = "Поле не заполнено.";
        new PolicyRegistration().checkError(error_txt,new PolicyRegistration().phoneError);
        new PolicyRegistration().checkError(error_txt,new PolicyRegistration().repeatEmailError);
        new PolicyRegistration().checkError(error_txt,new PolicyRegistration().emailError);
    }

}
