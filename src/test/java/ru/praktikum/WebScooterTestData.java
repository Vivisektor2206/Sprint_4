package ru.praktikum;

public class WebScooterTestData {

    public static final String COOKIE_BUTTON_XPATH = "//button[@class='App_CookieButton__3cvqF']";
    public static final String NAME_INPUT_XPATH = "//input[@placeholder='* Имя']";
    public static final String SURNAME_INPUT_XPATH = "//input[@placeholder='* Фамилия']";
    public static final String ADDRESS_INPUT_XPATH = "//input[@placeholder='* Адрес: куда привезти заказ']";
    public static final String PHONE_INPUT_XPATH = "//input[@placeholder='* Телефон: на него позвонит курьер']";
    public static final String METRO_INPUT_XPATH = "//input[@placeholder='* Станция метро']";
    public static final String ORDER_SMALL_BUTTON_XPATH = "//button[contains(@class, 'Button_Button__ra12g')]";
    public static final String RENTAL_DROPDOWN_XPATH = "//div[@class='Dropdown-control' and @aria-haspopup='listbox']";
    public static final String DATE_INPUT_XPATH = "//input[contains(@placeholder, '* Когда привезти самокат')]";
    public static final String COMMENT_INPUT_XPATH = "//input[contains(@placeholder, 'Комментарий для курьера')]";
    public static final String SAVE_BUTTON_CSS = "button[class*='Button_Middle__1CSJM']";
    public static final String ORDER_BUTTON_XPATH = "/html/body/div/div/div[2]/div[3]/button[2]";
    public static final String DATE_XPATH = "//div[@aria-label='Choose понедельник, 22-е июня 2026 г.']";
    public static final String CHOOSE_COLOR_XPATH = "//input[@id='black']";
    public static final String YES_BUTTON_XPATH = "//button[contains(text(), 'Да')]";
    public static final String ORDER_CONFIRM_XPATH = "/html/body/div/div/div[2]/div[5]/div[1]";
    public static final String LOCATOR_CONTAINS_RIGHT_STATION_XPATH = "//div[contains(text(), 'Войковская')]";
    public static final String LOCATOR_CONTAINS_RIGHT_OPTION_XPATH = "//div[@class='Dropdown-option' and text()='двое суток']";
    public static final String OPEN_ACCORDION_XPATH_1 = "//*[@id= 'accordion__heading-0']";
    public static final String TAKE_TEXT_ELEMENT_1_XPATH = "/html/body/div/div/div/div/div/div/div/div/p";
    public static final String OPEN_ACCORDION_XPATH_2 = "//*[@id='accordion__heading-1']";
    public static final String TAKE_TEXT_ELEMENT_2_XPATH = "/html/body/div/div/div[1]/div[5]/div[2]/div/div[2]/div[2]/p";
    public static final String OPEN_ACCORDION_XPATH_3 = "//*[@id='accordion__heading-2']";
    public static final String TAKE_TEXT_ELEMENT_3_XPATH = "/html/body/div/div/div[1]/div[5]/div[2]/div/div[3]/div[2]/p";
    public static final String OPEN_ACCORDION_XPATH_4 = "//*[@id='accordion__heading-3']";
    public static final String TAKE_TEXT_ELEMENT_4_XPATH = "/html/body/div/div/div[1]/div[5]/div[2]/div/div[4]/div[2]/p";
    public static final String OPEN_ACCORDION_XPATH_5 = "//*[@id='accordion__heading-4']";
    public static final String TAKE_TEXT_ELEMENT_5_XPATH = "/html/body/div/div/div[1]/div[5]/div[2]/div/div[5]/div[2]/p";
    public static final String OPEN_ACCORDION_XPATH_6 = "//*[@id='accordion__heading-5']";
    public static final String TAKE_TEXT_ELEMENT_6_XPATH = "/html/body/div/div/div[1]/div[5]/div[2]/div/div[6]/div[2]/p";
    public static final String OPEN_ACCORDION_XPATH_7 = "//*[@id='accordion__heading-6']";
    public static final String TAKE_TEXT_ELEMENT_7_XPATH = "/html/body/div/div/div[1]/div[5]/div[2]/div/div[7]/div[2]/p";
    public static final String OPEN_ACCORDION_XPATH_8 = "//*[@id='accordion__heading-7']";
    public static final String TAKE_TEXT_ELEMENT_8_XPATH = "/html/body/div/div/div[1]/div[5]/div[2]/div/div[8]/div[2]/p";



    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";



    public static Object[][] getTestParameters() {
        return new Object[][]{
                {"Рома", "Ромкин", "Красная площадь, д. 1", "89111234567"},
                {"Виктор", "Корнеплод", "Садовая ул., 22", "89117654321"},
                {"Магомед", "Хачипурин", "Сущевский вал во все стороны", "89111237645"}
        };
    }
}
