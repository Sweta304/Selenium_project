import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import pages.*;

public class RefactoredSberInsuranceTest extends BaseTest {

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");

        MainPage mainPage = new MainPage(driver);
        InsuranceAllTypes insuranceAllTypes = new InsuranceAllTypes(driver);
        TravelInsPage travelInsPage = new TravelInsPage(driver);
        PolicyChoice policyChoice = new PolicyChoice(driver);
        PolicyRegistration policyRegistration = new PolicyRegistration(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(mainPage.cookie, 0, 0);
        actions.moveByOffset(-50, 5).click().build().perform();

        //mainPage.cookie.click();
        mainPage.region.click();


        mainPage.ins.click();
        mainPage.allInsProgramms.click();


        insuranceAllTypes.insForTravellers.click();


        travelInsPage.onlineReg.click();
        travelInsPage.siteReg.click();

        //переход на активную вкладку
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        wait.until(ExpectedConditions.visibilityOf(
                policyChoice.apply));

        policyChoice.apply.click();

        //заполняем апплет "Застрахованные"
        wait.until(ExpectedConditions.elementToBeClickable(
                policyRegistration.insuredSurname));

        policyRegistration.fillField(policyRegistration.insuredSurname,"Иванов");
        policyRegistration.fillField(policyRegistration.insuredName,"Иван");
        policyRegistration.fillField(policyRegistration.insuredBirthDate,"03.06.1990");

        //policyRegistration.insurerNationality.click();

        //заполняем апплет "Страхователь"

        policyRegistration.insurerSurname.click();
        Thread.sleep(1000);

        policyRegistration.fillField(policyRegistration.insurerSurname,"Питров");
        policyRegistration.fillField(policyRegistration.insurerName,"Питер");
        policyRegistration.fillField(policyRegistration.insurerMidName,"Гриффин");
        policyRegistration.fillField(policyRegistration.insurerBirthDate,"03.06.1980");

        policyRegistration.insurerMidName.click();
        policyRegistration.insurerSex.click();

        //заполняем апплет "Паспортные данные"

        policyRegistration.fillField(policyRegistration.passportSeries,"1234");
        policyRegistration.fillField(policyRegistration.passportNumber,"123456");
        policyRegistration.fillField(policyRegistration.documentDate,"03.06.2021");

        policyRegistration.documentIssue.click();

        Thread.sleep(1000);
        policyRegistration.fillField(policyRegistration.documentIssue,"ОВД Москвы");

        //проверяем корректность заполнения полей

        //проверка апплета "Застрахованные"

        policyRegistration.checkFillField("Иванов",policyRegistration.insuredSurname);
        policyRegistration.checkFillField("Иван",policyRegistration.insuredName);
        policyRegistration.checkFillField("03.06.1990",policyRegistration.insuredBirthDate);

        //проверка апплета "Страхователь"

        policyRegistration.checkFillField("Питров",policyRegistration.insurerSurname);
        policyRegistration.checkFillField("Питер",policyRegistration.insurerName);
        policyRegistration.checkFillField("Гриффин",policyRegistration.insurerMidName);
        policyRegistration.checkFillField("03.06.1980",policyRegistration.insurerBirthDate);

        //проверка апплета "Паспортные данные"

        policyRegistration.checkFillField("1234",policyRegistration.passportSeries);
        policyRegistration.checkFillField("123456",policyRegistration.passportNumber);
        policyRegistration.checkFillField("03.06.2021",policyRegistration.documentDate);
        policyRegistration.checkFillField("ОВД Москвы",policyRegistration.documentIssue);

        //нажимаем "Продолжить"

        PolicyRegistration.continueButton.click();

        //проверяем наличие сообщений об ошибке
        policyRegistration.checkError("При заполнении данных произошла ошибка",policyRegistration.errorAssert);

        String error_txt = "Поле не заполнено.";

        policyRegistration.checkError(error_txt,policyRegistration.phoneError);
        policyRegistration.checkError(error_txt,policyRegistration.repeatEmailError);
        policyRegistration.checkError(error_txt,policyRegistration.emailError);

    }

}
