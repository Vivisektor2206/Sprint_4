package ru.praktikum;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderFormTests extends MainPageFAQTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;

    public OrderFormTests(String name, String surname, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }



    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3}")
    public static Object[] getTestParameters() {
        return OrderFormActions.getTestParameters();
    }


    @Test
    public void scooterOrderPositiveWithThreeParametersSmallButtonTest() {
        driver.get(WebScooterTestData.BASE_URL);
        OrderFormActions orderForm = new OrderFormActions();
        orderForm.wait = this.wait;
        orderForm.performFullOrderWithSmallButton(name, surname, address, phoneNumber);
    }

    @Test
    public void scooterOrderPositiveWithThreeParametersBigButtonTest() {
        driver.get(WebScooterTestData.BASE_URL);
        OrderFormActions orderForm = new OrderFormActions();
        orderForm.wait = this.wait;
        orderForm.performFullOrderWithBigButton(name, surname, address, phoneNumber);
    }
}
