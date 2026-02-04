package ru.praktikum;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.praktikum.WebScooterTestData.*;


public class OrderFormActions extends WebScooterUtilities {


    private void fillInputField(String xpath, String value) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        input.clear();
        input.sendKeys(value);
    }


    public void performFullOrder(String name, String surname, String address, String phoneNumber) {
        acceptCookies();

        wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("div.Home_FinishButton__1_cWm button.Button_Button__ra12g.Button_Middle__1CSJM")));
        System.out.println("Нижняя кнопка Заказать найдена");
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(ORDER_SMALL_BUTTON_XPATH)));
        System.out.println("Верхняя кнопка Заказать найдена");
        orderButton.click();

        fillInputField(NAME_INPUT_XPATH, name);
        fillInputField(SURNAME_INPUT_XPATH, surname);
        fillInputField(ADDRESS_INPUT_XPATH, address);
        fillInputField(PHONE_INPUT_XPATH, phoneNumber);

        WebElement metroInput = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(METRO_INPUT_XPATH)));
        metroInput.click();
        metroInput.sendKeys("Войковская");

        WebElement checkTextInMetro = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(LOCATOR_CONTAINS_RIGHT_STATION_XPATH)));
        checkTextInMetro.click();

        orderButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector(SAVE_BUTTON_CSS)));
        orderButton.click();

        fillInputField(DATE_INPUT_XPATH, "22.06.2026");
        driver.findElement(By.xpath(DATE_XPATH)).click();
        driver.findElement(By.xpath(CHOOSE_COLOR_XPATH)).click();
        fillInputField(COMMENT_INPUT_XPATH, "Самому на нем не кататься");


        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(RENTAL_DROPDOWN_XPATH)));
        dropdown.click();

        WebElement rentalOption = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(LOCATOR_CONTAINS_RIGHT_OPTION_XPATH)));
        rentalOption.click();


        orderButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(ORDER_BUTTON_XPATH)));
        orderButton.click();


        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(YES_BUTTON_XPATH))).click();

        WebElement orderConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(ORDER_CONFIRM_XPATH)));
        String expectedText = "Заказ оформлен";
        String actualText = orderConfirm.getText().trim();
        System.out.println("Фактический текст: " + actualText);
        assertTrue("Текст не содержит ожидаемую подстроку '" + expectedText + "'!",
                actualText.contains(expectedText));
    }

    private void acceptCookies() {
    }
}

