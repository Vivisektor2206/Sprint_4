package ru.praktikum;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OrderFormTestsData extends BaseTest {

    private static final String ORDER_SMALL_BUTTON_XPATH = "//button[contains(@class, 'Button_Button__ra12g')]";
    private static final String NAME_INPUT_XPATH = "//input[@placeholder='* Имя']";
    private static final String SURNAME_INPUT_XPATH = "//input[@placeholder='* Фамилия']";
    private static final String ADDRESS_INPUT_XPATH = "//input[@placeholder='* Адрес: куда привезти заказ']";
    private static final String PHONE_INPUT_XPATH = "//input[@placeholder='* Телефон: на него позвонит курьер']";
    private static final String METRO_INPUT_XPATH = "//input[@placeholder='* Станция метро']";
    private static final String LOCATOR_CONTAINS_RIGHT_STATION_XPATH = "//div[contains(text(), 'Войковская')]";
    private static final String SAVE_BUTTON_CSS = "button[class*='Button_Middle__1CSJM']";
    private static final String DATE_INPUT_XPATH = "//input[contains(@placeholder, '* Когда привезти самокат')]";
    private static final String DATE_XPATH = "//div[@aria-label='Choose понедельник, 22-е июня 2026 г.']";
    private static final String CHOOSE_COLOR_XPATH = "//input[@id='black']";
    private static final String COMMENT_INPUT_XPATH = "//input[contains(@placeholder, 'Комментарий для курьера')]";
    private static final String RENTAL_DROPDOWN_XPATH = "//div[@class='Dropdown-control' and @aria-haspopup='listbox']";
    private static final String LOCATOR_CONTAINS_RIGHT_OPTION_XPATH = "//div[@class='Dropdown-option' and text()='двое суток']";
    private static final String ORDER_BUTTON_XPATH = "//*[@class='Button_Button__ra12g Button_Middle__1CSJM']";
    private static final String YES_BUTTON_XPATH = "//button[contains(text(), 'Да')]";
    private static final String ORDER_CONFIRM_XPATH = "/html/body/div/div/div[2]/div[5]/div[1]";
    protected static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    protected String expectedText;


    protected void performFullOrderWithSmallButton(String name, String surname, String address, String phoneNumber) {

        smallOrderButtonClick();
        fillInputFieldInForm(name, surname, address, phoneNumber);
        typeStationName();
        checkTextInMetroAndClick();
        saveOrderButtonClick();
        chooseYourConditionsAndClick();
        dropDownClick();
        chooseRentalDuration();
        confirmOrder();
        realConfirmOrderClick();
    }

    protected void performFullOrderWithBigButton(String name, String surname, String address, String phoneNumber) {

        acceptCookies();
        bigOrderButtonClick();
        fillInputFieldInForm(name, surname, address, phoneNumber);
        typeStationName();
        checkTextInMetroAndClick();
        saveOrderButtonClick();
        chooseYourConditionsAndClick();
        dropDownClick();
        chooseRentalDuration();
        confirmOrder();
        realConfirmOrderClick();
    }


    protected static Object[][] getTestParameters() {
        return new Object[][]{
                {"Рома", "Ромкин", "Красная площадь, д. 1", "89111234567"},
                {"Виктор", "Корнеплод", "Садовая ул., 22", "89117654321"},
                {"Магомед", "Хачипурин", "Сущевский вал во все стороны", "89111237645"}
        };
    }

    private void fillInputField(String xpath, String value) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        input.clear();
        input.sendKeys(value);
    }

    private static void acceptCookies() {
        driver.findElement(By.xpath(MainPageFAQTestData.COOKIE_BUTTON_XPATH)).click();
    }

    private void smallOrderButtonClick() {
        WebElement smallOrderButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(ORDER_SMALL_BUTTON_XPATH)));
        System.out.println("Верхняя кнопка Заказать найдена");
        smallOrderButton.click();
    }

    private void bigOrderButtonClick() {
        WebElement bigOrderButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("div.Home_FinishButton__1_cWm button.Button_Button__ra12g.Button_Middle__1CSJM")));
        System.out.println("Нижняя кнопка Заказать найдена");
        bigOrderButton.click();
    }

    private void fillInputFieldInForm(String name, String surname, String address, String phoneNumber) {
        fillInputField(NAME_INPUT_XPATH, name);
        fillInputField(SURNAME_INPUT_XPATH, surname);
        fillInputField(ADDRESS_INPUT_XPATH, address);
        fillInputField(PHONE_INPUT_XPATH, phoneNumber);
    }

    private void typeStationName() {
        WebElement metroInput = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(METRO_INPUT_XPATH)));
        metroInput.click();
        metroInput.sendKeys("Войковская");
    }

    private void checkTextInMetroAndClick() {
        WebElement checkTextInMetro = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(LOCATOR_CONTAINS_RIGHT_STATION_XPATH)));
        checkTextInMetro.click();
    }

    private void saveOrderButtonClick() {
        WebElement saveOrderButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector(SAVE_BUTTON_CSS)));
        saveOrderButton.click();
    }

    private void chooseYourConditionsAndClick() {
        fillInputField(DATE_INPUT_XPATH, "22.06.2026");
        driver.findElement(By.xpath(DATE_XPATH)).click();
        driver.findElement(By.xpath(CHOOSE_COLOR_XPATH)).click();
        fillInputField(COMMENT_INPUT_XPATH, "Самому на нем не кататься");
    }

    private void dropDownClick() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(RENTAL_DROPDOWN_XPATH)));
        dropdown.click();
    }

    private void chooseRentalDuration() {
        WebElement rentalOption = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(LOCATOR_CONTAINS_RIGHT_OPTION_XPATH)));
        rentalOption.click();
    }

    private void confirmOrder() {
        WebElement confirmOrderButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(ORDER_BUTTON_XPATH)));
        confirmOrderButton.click();
    }

    private void realConfirmOrderClick() {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(YES_BUTTON_XPATH))).click();
    }

    public boolean isCheckOrderConfirmed() {
        WebElement orderConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(ORDER_CONFIRM_XPATH)));
        String actualText = orderConfirm.getText().trim();
        System.out.println("Фактический текст: " + actualText);
        return actualText.contains(expectedText);
    }
}


