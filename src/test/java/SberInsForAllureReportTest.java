import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import steps.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SberInsForAllureReportTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsuranceAllTypesSteps insuranceAllTypesSteps = new InsuranceAllTypesSteps();
    TravelInsSteps travelInsSteps = new TravelInsSteps();
    PolicyChoiceSteps policyChoiceSteps = new PolicyChoiceSteps();
    PolicyRegistrationSteps policyRegistrationSteps = new PolicyRegistrationSteps();

    HashMap<String, String> testData = new HashMap<>();

    @DisplayName("Страхование путешественников")
    @Test
    public void Test(){
        testData.put("Фамилия застрахованного","Гриффин");
        testData.put("Имя застрахованного","Питер");
        testData.put("Дата рождения застрахованного","03.06.1990");
        testData.put("Фамилия страхователя","Гриффинов");
        testData.put("Имя страхователя","Питор");
        testData.put("Отчество страхователя","Питровичь");
        testData.put("Дата рождения страхователя","03.06.1990");
        testData.put("Серия паспорта","2143");
        testData.put("Номер паспорта","676354");
        testData.put("Дата выдачи паспорта","03.06.2018");
        testData.put("Кем выдан","ОВД");


        mainPageSteps.cookiesConfirmation();
        mainPageSteps.selectRegion();
        mainPageSteps.goToInsurance();
        mainPageSteps.goToAllInsPrograms();
        insuranceAllTypesSteps.selectTravelIns();
        travelInsSteps.goToOnlineReg();
        travelInsSteps.goToSiteReg();

        //переход на активную вкладку
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        policyChoiceSteps.goToTravelInsApply();

        policyRegistrationSteps.isVisible();
        policyRegistrationSteps.fillFields(testData);
        policyRegistrationSteps.checkFillFields(testData);
        policyRegistrationSteps.clickContinue();
        policyRegistrationSteps.errorChecking();
    }
}
