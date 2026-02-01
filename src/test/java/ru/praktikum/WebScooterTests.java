package ru.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class WebScooterTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String COOKIE_BUTTON_XPATH = "//button[@class='App_CookieButton__3cvqF']";
    private static final String NAME_INPUT_XPATH = "//input[@placeholder='* Имя']";
    private static final String SURNAME_INPUT_XPATH = "//input[@placeholder='* Фамилия']";
    private static final String ADDRESS_INPUT_XPATH = "//input[@placeholder='* Адрес: куда привезти заказ']";
    private static final String PHONE_INPUT_XPATH = "//input[@placeholder='* Телефон: на него позвонит курьер']";
    private static final String METRO_INPUT_XPATH = "//input[@placeholder='* Станция метро']";
    private static final String ORDER_BUTTON_XPATH = "//button[contains(@class, 'Button_Button__ra12g') or contains(@class, 'Button_UltraBig__UU3Lp')]";
    private static final String RENTAL_DROPDOWN_XPATH = "//div[@class='Dropdown-control' and @aria-haspopup='listbox']";
    private static final String DATE_INPUT_XPATH = "//input[contains(@placeholder, '* Когда привезти самокат')]";
    private static final String COMMENT_INPUT_XPATH = "//input[contains(@placeholder, 'Комментарий для курьера')]";
    private static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final String SAVE_BUTTON_CSS = "button[class*='Button_Middle__1CSJM']";
    private static final String DATE_XPATH = "//div[@aria-label='Choose понедельник, 22-е июня 2026 г.']";
    private static final String CHOOSE_COLOR_XPATH = "//input[@id='black']";
    private static final String YES_BUTTON_XPATH = "//button[contains(text(), 'Да')]";
    private static final String ORDER_CONFIRM_XPATH = "//div[@class='Order_ModalHeader__3FDaJ']";


    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;

    public WebScooterTests(String name, String surname, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Test
    public void arrowOpensExpectedTextTest() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//button[@class='App_CookieButton__3cvqF']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement accordionHeader = driver.findElement
                (By.xpath(
                        ("//div[contains(text(), 'Сколько это стоит?') or contains(text(), 'Как оплатить?')]")));
        ((JavascriptExecutor) driver).executeScript(
                ("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})"), accordionHeader);
        accordionHeader.click();
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//p[contains(text(), 'Сутки — 400 рублей')]")));
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualText = textElement.getText().trim();
        assertFalse("Текст в панели не появился!", actualText.isEmpty());
        assertEquals("Текст не совпадает с ожидаемым!", expectedText, actualText);
    }

    @Parameterized.Parameters
    public static Object[] getTestParameters() {
        return new Object[][]{
                {"Рома", "Ромкин", "Красная площадь, д. 1", "89111234567"},
                {"Виктор", "Корнеплод", "Садовая ул., 22", "89117654321"},
                {"Магомед", "Хачипурин", "Сущевский вал во все стороны", "89111237645"}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    @Test
    public void scooterOrderPositiveWithThreeParametersTest() {
        driver.get(BASE_URL);

        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ORDER_BUTTON_XPATH)));
        orderButton.click();
        fillInputField(NAME_INPUT_XPATH, name);
        fillInputField(SURNAME_INPUT_XPATH, surname);
        fillInputField(ADDRESS_INPUT_XPATH, address);
        fillInputField(PHONE_INPUT_XPATH, phoneNumber);
        WebElement metroInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(METRO_INPUT_XPATH)));
        metroInput.click();  // Открываем список
        metroInput.sendKeys("Войковская");
        WebElement checkTextInMetro = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Войковская')]")));
        checkTextInMetro.click();
        orderButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SAVE_BUTTON_CSS)));
        orderButton.click();
        fillInputField(DATE_INPUT_XPATH, "22.06.2026");
        driver.findElement(By.xpath(DATE_XPATH)).click();
        driver.findElement(By.xpath(CHOOSE_COLOR_XPATH)).click();
        fillInputField(COMMENT_INPUT_XPATH, "Самому на нем не кататься");
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RENTAL_DROPDOWN_XPATH)));
        dropdown.click();
        WebElement rentalOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='Dropdown-option' and text()='двое суток']")));
        rentalOption.click();
        orderButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SAVE_BUTTON_CSS)));
        orderButton.click();
        driver.findElement(By.xpath(YES_BUTTON_XPATH));
        driver.findElement(By.xpath(ORDER_CONFIRM_XPATH));
    }


    private void fillInputField(String xpath, String value) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        input.clear();
        input.sendKeys(value);
    }


    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
