package ru.praktikum;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;


public class MainPageFAQTestData extends BaseTest {

    protected static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String COOKIE_BUTTON_XPATH = "//button[@class='App_CookieButton__3cvqF']";
    public static final String OPEN_ACCORDION_XPATH_1 = "//*[@id= 'accordion__heading-0']";
    public static final String TAKE_TEXT_ELEMENT_1_XPATH = ".//p[contains(text(), 'Сутки — 400 рублей')]";
    public static final String OPEN_ACCORDION_XPATH_2 = "//*[@id='accordion__heading-1']";
    public static final String TAKE_TEXT_ELEMENT_2_XPATH = ".//p[contains(text(), 'Пока что у нас так')]";
    public static final String OPEN_ACCORDION_XPATH_3 = "//*[@id='accordion__heading-2']";
    public static final String TAKE_TEXT_ELEMENT_3_XPATH = ".//p[contains(text(), 'Допустим, вы оформляете')]";
    public static final String OPEN_ACCORDION_XPATH_4 = "//*[@id='accordion__heading-3']";
    public static final String TAKE_TEXT_ELEMENT_4_XPATH = ".//p[contains(text(), 'Только начиная с завтрашнего дня')]";
    public static final String OPEN_ACCORDION_XPATH_5 = "//*[@id='accordion__heading-4']";
    public static final String TAKE_TEXT_ELEMENT_5_XPATH = ".//p[contains(text(), 'Пока что нет!')]";
    public static final String OPEN_ACCORDION_XPATH_6 = "//*[@id='accordion__heading-5']";
    public static final String TAKE_TEXT_ELEMENT_6_XPATH = ".//p[contains(text(), 'Самокат приезжает к вам')]";
    public static final String OPEN_ACCORDION_XPATH_7 = "//*[@id='accordion__heading-6']";
    public static final String TAKE_TEXT_ELEMENT_7_XPATH = ".//p[contains(text(), 'Да, пока самокат не привезли')]";
    public static final String OPEN_ACCORDION_XPATH_8 = "//*[@id='accordion__heading-7']";
    public static final String TAKE_TEXT_ELEMENT_8_XPATH = ".//p[contains(text(), 'Да, обязательно')]";


    protected static Object[][] getFAQTestParameters() {
        return new Object[][]{
                {OPEN_ACCORDION_XPATH_1, TAKE_TEXT_ELEMENT_1_XPATH, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {OPEN_ACCORDION_XPATH_2, TAKE_TEXT_ELEMENT_2_XPATH, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                        " можете просто сделать несколько заказов — один за другим."},
                {OPEN_ACCORDION_XPATH_3, TAKE_TEXT_ELEMENT_3_XPATH,  "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
                        " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли" +
                        " самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {OPEN_ACCORDION_XPATH_4, TAKE_TEXT_ELEMENT_4_XPATH, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {OPEN_ACCORDION_XPATH_5, TAKE_TEXT_ELEMENT_5_XPATH, "Пока что нет! Но если что-то срочное — всегда можно позвонить в " +
                        "поддержку по красивому номеру 1010."},
                {OPEN_ACCORDION_XPATH_6, TAKE_TEXT_ELEMENT_6_XPATH, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь" +
                        " суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {OPEN_ACCORDION_XPATH_7, TAKE_TEXT_ELEMENT_7_XPATH, "Да, пока самокат не привезли. Штрафа не будет, объяснительной " +
                        "записки тоже не попросим. Все же свои."},
                {OPEN_ACCORDION_XPATH_8, TAKE_TEXT_ELEMENT_8_XPATH, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }


    public void arrowOpensExpectedText(String questionKey, String answer, String expectedText) {
        acceptCookies();
        clickAndCheckText(questionKey, answer, expectedText);
    }

    private void clickAndCheckText(String questionKey, String answer, String expectedText) {
        WebElement accordionHeader = driver.findElement(By.xpath(questionKey));
        smoothScrollToElement(driver, accordionHeader);
        accordionHeader.click();
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(answer)));
        smoothScrollToElement(driver, textElement);
        String actualText = textElement.getText().trim();
        System.out.println("Фактический текст: " + actualText + "ТЕСТ ПРОЙДЕН");
        assertEquals("Текст не совпадает с ожидаемым! ТЕСТ НЕ ПРОЙДЕН", expectedText, actualText);
    }

    public static void acceptCookies() {
        driver.findElement(By.xpath(MainPageFAQTestData.COOKIE_BUTTON_XPATH)).click();
    }

    public static void smoothScrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
    }
}
