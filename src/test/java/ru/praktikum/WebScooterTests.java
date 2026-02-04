package ru.praktikum;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class WebScooterTests extends MainPageActionsTest {

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

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[] getTestParameters() {
        return WebScooterTestData.getTestParameters();
    }


    @Test
    public void scooterOrderPositiveWithThreeParametersTest() {
        driver.get(WebScooterTestData.BASE_URL);
        OrderFormActions orderForm = new OrderFormActions();
        orderForm.wait = this.wait;
        orderForm.performFullOrder(name, surname, address, phoneNumber);
    }
}
