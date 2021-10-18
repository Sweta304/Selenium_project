import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SberInsurance {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver");

        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        //ожидание 30 секунд
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //развернуть окно браузера
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//button[contains(@class,'kitt-region__accept')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'kitt-cookie-warning__close')]")).click();
        driver.findElement(By.xpath("//*[contains(@aria-label,'Страхование')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Все страховые программы')]")).click();
        driver.findElement(By.xpath("//h3[contains(text(),'Страхование путешественников')]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'kitt-button__text')][contains(text(),'Оформить онлайн')]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'kitt-button__text')][contains(text(),'Оформить на сайте')]")).click();

        //переход на активную вкладку
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//button[contains(text(),'Оформить')]"))));

        driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")).click();

        //заполняем апплет "Застрахованные"
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//input[contains(@placeholder,'Фамилия / Surname')]"))));

        fillField(By.xpath("//input[contains(@placeholder,'Фамилия / Surname')]"), "Иванов");
        fillField(By.xpath("//input[contains(@placeholder,'Имя / Name')]"), "Иван");
        fillField(By.xpath("//input[contains(@placeholder,'дд.мм.гггг')]"), "03.06.1990");

        driver.findElement(By.xpath("//label[contains(text(),'гражданин РФ')]")).click();

        //заполняем апплет "Страхователь"
        driver.findElement(By.xpath("//input[@id='person_lastName']")).click();
        fillField(By.xpath("//input[@id='person_lastName']"),"Питров");
        fillField(By.xpath("//input[@id='person_firstName']"),"Питер");
        fillField(By.xpath("//input[@id='person_middleName']"),"Гриффин");
        fillField(By.xpath("//input[@id='person_birthDate']"),"03.06.1980");

        driver.findElement(By.xpath("//input[@id='person_middleName']")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Мужской')]")).click();

        //заполняем апплет "Паспортные данные"
        fillField(By.id("passportSeries"),"1234");
        fillField(By.id("passportNumber"),"123456");
        fillField(By.id("documentDate"),"03.06.2021");

        driver.findElement(By.id("documentIssue")).click();
        Thread.sleep(1000);
        fillField(By.id("documentIssue"),"ОВД Москвы");

        //проверяем корректность заполнения полей

        //проверка апплета "Застрахованные"
        assertEquals("Иванов",
                driver.findElement(By.xpath("//input[contains(@placeholder,'Фамилия / Surname')]")).getAttribute("value"));
        assertEquals("Иван",
                driver.findElement(By.xpath("//input[contains(@placeholder,'Имя / Name')]")).getAttribute("value"));
        assertEquals("03.06.1990",
                driver.findElement(By.xpath("//input[contains(@placeholder,'дд.мм.гггг')]")).getAttribute("value"));

        //проверка апплета "Страхователь"
        assertEquals("Питров",
                driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Питер",
                driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Гриффин",
                driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("03.06.1980",
                driver.findElement(By.id("person_birthDate")).getAttribute("value"));

        //проверка апплета "Паспортные данные"
        assertEquals("1234",
                driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("123456",
                driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("03.06.2021",
                driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("ОВД Москвы",
                driver.findElement(By.id("documentIssue")).getAttribute("value"));

        //нажимаем "Продолжить"

        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

        //проверяем наличие сообщений об ошибке
        assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//div[contains(@role,'alert-form')]")).getText());


        String error_txt = "Поле не заполнено.";
        assertEquals(error_txt,
                driver.findElement(By.xpath("//input-phone2[@name='phone']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")).getText());
        assertEquals(error_txt,
                driver.findElement(By.xpath("//input-email[@name='repeatEmail']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")).getText());
        assertEquals(error_txt,
                driver.findElement(By.xpath("//input-email[@name='email']/span/validation-message/span[contains(@class,'invalid-validate form-control__message')]")).getText());

    }

    @After
    public void tearDown() throws Exception {
        //закрыть браузер
        driver.quit();
    }

    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

}
