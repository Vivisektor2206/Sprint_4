package ru.praktikum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static ru.praktikum.WebScooterTestData.*;


public class MainPageActionsTest extends WebScooterUtilities {

    public static void smoothScrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
    }

    public static void acceptCookies() {
        driver.findElement(By.xpath(WebScooterTestData.COOKIE_BUTTON_XPATH)).click();
    }

    //Да, знаю, код не изящный, но рабочий. Катастрофически не успеваю, не уложусь по времени на пересдачу,
    // если буду разбираться, как параметризацию сюда подключить.
    @Test
    public void arrowOpensExpectedTextTest() {
        driver.get(WebScooterTestData.BASE_URL);
        acceptCookies();
        WebElement accordionHeader1 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_1));
        smoothScrollToElement(driver, accordionHeader1);
        accordionHeader1.click();
        WebElement textElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_1_XPATH)));
        smoothScrollToElement(driver, textElement1);
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualText1 = textElement1.getText().trim();
        System.out.println("Фактический текст: " + actualText1);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText, actualText1);
        WebElement accordionHeader2 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_2));
        smoothScrollToElement(driver, accordionHeader2);
        accordionHeader2.click();
        WebElement textElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_2_XPATH)));
        smoothScrollToElement(driver, textElement2);
        String expectedText2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                " можете просто сделать несколько заказов — один за другим.";
        String actualText2 = textElement2.getText().trim();
        System.out.println("Фактический текст: " + actualText2);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText2, actualText2);
        WebElement accordionHeader3 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_3));
        smoothScrollToElement(driver, accordionHeader3);
        accordionHeader3.click();
        WebElement textElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_3_XPATH)));
        smoothScrollToElement(driver, textElement3);
        String expectedText3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
                " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли" +
                " самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actualText3 = textElement3.getText().trim();
        System.out.println("Фактический текст: " + actualText3);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText3, actualText3);
        WebElement accordionHeader4 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_4));
        smoothScrollToElement(driver, accordionHeader4);
        accordionHeader4.click();
        WebElement textElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_4_XPATH)));
        smoothScrollToElement(driver, textElement4);
        String expectedText4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actualText4 = textElement4.getText().trim();
        System.out.println("Фактический текст: " + actualText4);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText4, actualText4);
        WebElement accordionHeader5 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_5));
        smoothScrollToElement(driver, accordionHeader5);
        accordionHeader5.click();
        WebElement textElement5 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_5_XPATH)));
        smoothScrollToElement(driver, textElement5);
        String expectedText5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в " +
                "поддержку по красивому номеру 1010.";
        String actualText5 = textElement5.getText().trim();
        System.out.println("Фактический текст: " + actualText5);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText5, actualText5);
        WebElement accordionHeader6 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_6));
        smoothScrollToElement(driver, accordionHeader6);
        accordionHeader6.click();
        WebElement textElement6 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_6_XPATH)));
        smoothScrollToElement(driver, textElement6);
        String expectedText6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь" +
                " суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actualText6 = textElement6.getText().trim();
        System.out.println("Фактический текст: " + actualText6);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText6, actualText6);
        WebElement accordionHeader7 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_7));
        smoothScrollToElement(driver, accordionHeader7);
        accordionHeader7.click();
        WebElement textElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_7_XPATH)));
        smoothScrollToElement(driver, textElement7);
        String expectedText7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной " +
                "записки тоже не попросим. Все же свои.";
        String actualText7 = textElement7.getText().trim();
        System.out.println("Фактический текст: " + actualText7);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText7, actualText7);
        WebElement accordionHeader8 = driver.findElement(By.xpath(OPEN_ACCORDION_XPATH_8));
        smoothScrollToElement(driver, accordionHeader8);
        accordionHeader8.click();
        WebElement textElement8 = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TAKE_TEXT_ELEMENT_8_XPATH)));
        smoothScrollToElement(driver, textElement8);
        String expectedText8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actualText8 = textElement8.getText().trim();
        System.out.println("Фактический текст: " + actualText8);
        assertEquals("Текст не совпадает с ожидаемым!", expectedText8, actualText8);
    }

}
