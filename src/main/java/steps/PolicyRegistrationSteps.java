package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PolicyRegistration;

import java.util.HashMap;

public class PolicyRegistrationSteps extends BaseSteps{

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value){
        new PolicyRegistration(driver).fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String value, String field) {
        new PolicyRegistration(driver).checkFillField(value, field);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> fillField(k,v));
    }

    @Step("проверка заполненности полей")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> checkFillField(v,k));
    }

    @Step("Ожидает что поле становится видимым")
    public void isVisible(){
        wait.until(ExpectedConditions.elementToBeClickable(
                new PolicyRegistration(driver).insuredSurname));
    }

    @Step("Нажимает кнопку Продолжить")
    public void clickContinue(){
        new PolicyRegistration(driver).continueButton.click();
    }

    @Step("Проверяется наличие сообщений об ошибке")
    public void errorChecking (){
        new PolicyRegistration(driver).checkError("При заполнении данных произошла ошибка",new PolicyRegistration(driver).errorAssert);
        String error_txt = "Поле не заполнено.";
        new PolicyRegistration(driver).checkError(error_txt,new PolicyRegistration(driver).phoneError);
        new PolicyRegistration(driver).checkError(error_txt,new PolicyRegistration(driver).repeatEmailError);
        new PolicyRegistration(driver).checkError(error_txt,new PolicyRegistration(driver).emailError);
    }

}
