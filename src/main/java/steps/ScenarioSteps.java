package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsuranceAllTypesSteps insuranceAllTypesSteps = new InsuranceAllTypesSteps();
    TravelInsSteps travelInsSteps = new TravelInsSteps();
    PolicyChoiceSteps policyChoiceSteps = new PolicyChoiceSteps();
    PolicyRegistrationSteps policyRegistrationSteps = new PolicyRegistrationSteps();

    @When("^Подтверждено согласие на использование cookies$")
    public void cookiesConfirmationClick(){
        mainPageSteps.cookiesConfirmation();
    }

    @When("^Выбран регион$")
    public void selectRegionClick(){
        mainPageSteps.selectRegion();
    }

    @When("^Осуществлен переход в меню Страхование$")
    public void goToInsuranceClick(){
        mainPageSteps.goToInsurance();
    }

    @When("^Осуществлен переход на все страховые программы$")
    public void goToAllInsProgramsClick(){
        mainPageSteps.goToAllInsPrograms();
    }

    @When("^Выбран пункт меню Страхование путешественников$")
    public void selectTravelInsClick(){
        insuranceAllTypesSteps.selectTravelIns();
    }

    @When("^Нажата кнопка Оформить онлайн$")
    public void goToOnlineRegClick(){
        travelInsSteps.goToOnlineReg();
    }

    @When("^Осуществлен переход на оформление на сайте$")
    public void goToSiteRegClick(){
        travelInsSteps.goToSiteReg();
    }

    @When("^Осуществлен переход на страницу Страхование путешественников$")
    public void goToTravelInsApplyClick(){
        policyChoiceSteps.goToTravelInsApply();
    }

    @When("^Поле становится видимым$")
    public void isVisibleClick(){
        policyRegistrationSteps.isVisible();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> PolicyRegistrationSteps.fillField(field,value));
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.<String,String>asMap(String.class, String.class)
                .forEach((field, value) -> PolicyRegistrationSteps.checkFillField(value,field));
    }

    @When("^Нажата кнопка Продолжить$")
    public void clickContinueClick(){
        policyRegistrationSteps.clickContinue();
    }

    @Then("^Проверяется наличие сообщений об ошибке$")
    public void errorCheckingClick(){
        policyRegistrationSteps.errorChecking();
    }

}
