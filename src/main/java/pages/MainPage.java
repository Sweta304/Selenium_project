package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage{
    @FindBy(xpath="//button[contains(@class,'kitt-region__accept')]")
    public static WebElement region;

    @FindBy(xpath="//button[contains(@class,'kitt-cookie-warning__close')]")
    public static WebElement cookie;

    @FindBy(xpath="//*[contains(@aria-label,'Страхование')]")
    public static WebElement ins;

    @FindBy(xpath="//*[contains(text(),'Все страховые программы')]")
    public static WebElement allInsProgramms;


    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
