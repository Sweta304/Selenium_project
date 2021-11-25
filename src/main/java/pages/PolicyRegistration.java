package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyRegistration extends BasePage{

    @FindBy(xpath="//input[contains(@placeholder,'Фамилия / Surname')]")
    public static WebElement insuredSurname;

    @FindBy(xpath="//input[contains(@placeholder,'Имя / Name')]")
    public static WebElement insuredName;

    @FindBy(xpath="//input[contains(@placeholder,'дд.мм.гггг')]")
    public static WebElement insuredBirthDate;

    @FindBy(xpath="//label[contains(text(),'гражданин РФ')]")
    public static WebElement insurerNationality;

    @FindBy(xpath="//input[@id='person_lastName']")
    public static WebElement insurerSurname;

    @FindBy(xpath="//input[@id='person_firstName']")
    public static WebElement insurerName;

    @FindBy(xpath="//input[@id='person_middleName']")
    public static WebElement insurerMidName;

    @FindBy(xpath="//input[@id='person_birthDate']")
    public static WebElement insurerBirthDate;

    @FindBy(xpath="//label[contains(text(),'Мужской')]")
    public static WebElement insurerSex;

    @FindBy(id="passportSeries")
    public static WebElement passportSeries;

    @FindBy(id="passportNumber")
    public static WebElement passportNumber;

    @FindBy(id="documentDate")
    public static WebElement documentDate;

    @FindBy(id="documentIssue")
    public static WebElement documentIssue;

    @FindBy(xpath="//button[contains(text(),'Продолжить')]")
    public static WebElement continueButton;

    @FindBy(xpath="//input-phone2[@name='phone']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")
    public static WebElement phoneError;

    @FindBy(xpath="//input-email[@name='repeatEmail']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")
    public static WebElement repeatEmailError;

    @FindBy(xpath="//input-email[@name='email']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")
    public static WebElement emailError;

    @FindBy(xpath="//div[contains(@role,'alert-form')]")
    public static WebElement errorAssert;

    public PolicyRegistration (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    public static void fillField (WebElement fieldName, String value) {
//        BasePage basePage = new BasePage();
//        basePage.fillField(fieldName,value);
//    }
//
//    public static void checkFillField(String value, WebElement element) {
//        BasePage basePage = new BasePage();
//        basePage.checkFillField(value, element);
//    }
//
//    public static void checkError(String value, WebElement element) {
//        BasePage basePage = new BasePage();
//        basePage.checkError(value, element);
//    }
}
