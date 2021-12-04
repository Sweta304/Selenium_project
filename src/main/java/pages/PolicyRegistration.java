package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PolicyRegistration extends BasePage {

    @FindBy(xpath = "//input[contains(@placeholder,'Фамилия / Surname')]")
    public static WebElement insuredSurname;

    @FindBy(xpath = "//input[contains(@placeholder,'Имя / Name')]")
    public static WebElement insuredName;

    @FindBy(xpath = "//input[contains(@placeholder,'дд.мм.гггг')]")
    public static WebElement insuredBirthDate;

    @FindBy(xpath = "//label[contains(text(),'гражданин РФ')]")
    public static WebElement insurerNationality;

    @FindBy(xpath = "//input[@id='person_lastName']")
    public static WebElement insurerSurname;

    @FindBy(xpath = "//input[@id='person_firstName']")
    public static WebElement insurerName;

    @FindBy(xpath = "//input[@id='person_middleName']")
    public static WebElement insurerMidName;

    @FindBy(xpath = "//input[@id='person_birthDate']")
    public static WebElement insurerBirthDate;

    @FindBy(xpath = "//label[contains(text(),'Мужской')]")
    public static WebElement insurerSex;

    @FindBy(id = "passportSeries")
    public static WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public static WebElement passportNumber;

    @FindBy(id = "documentDate")
    public static WebElement documentDate;

    @FindBy(id = "documentIssue")
    public static WebElement documentIssue;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    public static WebElement continueButton;

    @FindBy(xpath = "//input-phone2[@name='phone']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")
    public static WebElement phoneError;

    @FindBy(xpath = "//input-email[@name='repeatEmail']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")
    public static WebElement repeatEmailError;

    @FindBy(xpath = "//input-email[@name='email']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")
    public static WebElement emailError;

    @FindBy(xpath = "//div[contains(@role,'alert-form')]")
    public static WebElement errorAssert;

    public PolicyRegistration(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(insuredSurname, value);
                break;
            case "Имя застрахованного":
                fillField(insuredName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(insuredBirthDate, value);
                break;
            case "Фамилия страхователя":
                fillField(insurerSurname, value);
                break;
            case "Имя страхователя":
                fillField(insurerName, value);
                break;
            case "Отчество страхователя":
                fillField(insurerMidName, value);
                break;
            case "Дата рождения страхователя":
                fillField(insurerBirthDate, value);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи паспорта":
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void checkFillField(String value, String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                checkFillField(value, insuredSurname);
                break;
            case "Имя застрахованного":
                checkFillField(value, insuredName);
                break;
            case "Дата рождения застрахованного":
                checkFillField(value, insuredBirthDate);
                break;
            case "Фамилия страхователя":
                checkFillField(value, insurerSurname);
                break;
            case "Имя страхователя":
                checkFillField(value, insurerName);
                break;
            case "Отчество страхователя":
                checkFillField(value, insurerMidName);
                break;
            case "Дата рождения страхователя":
                checkFillField(value, insurerBirthDate);
                break;
            case "Серия паспорта":
                checkFillField(value, passportSeries);
                break;
            case "Номер паспорта":
                checkFillField(value, passportNumber);
                break;
            case "Дата выдачи паспорта":
                checkFillField(value, documentDate);
                break;
            case "Кем выдан":
                checkFillField(value, documentIssue);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");

        }
    }
}
