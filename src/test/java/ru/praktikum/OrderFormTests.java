package ru.praktikum;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderFormTests extends OrderFormPage {

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
    public static Object[][] getTestParameters() {
        return OrderFormPage.getTestParameters();
    }


    @Test
    public void scooterOrderPositiveWithThreeParametersSmallButtonTest() {
        driver.get(OrderFormPage.BASE_URL);
        OrderFormPage orderForm = new OrderFormPage();
        orderForm.wait = this.wait;
        orderForm.performFullOrderWithSmallButton(name, surname, address, phoneNumber);
        orderForm.expectedText = "Заказ оформлен";
        assertTrue("Текст не содержит ожидаемую подстроку", orderForm.isCheckOrderConfirmed());
        System.out.println("ТЕСТ ЗАВЕРШЕН УСПЕШНО");
    }

    @Test
    public void scooterOrderPositiveWithThreeParametersBigButtonTest() {
        driver.get(OrderFormPage.BASE_URL);
        OrderFormPage orderForm = new OrderFormPage();
        orderForm.wait = this.wait;
        orderForm.performFullOrderWithBigButton(name, surname, address, phoneNumber);
        orderForm.expectedText = "Заказ оформлен";
        assertTrue("Текст не содержит ожидаемую подстроку", orderForm.isCheckOrderConfirmed());
        System.out.println("ТЕСТ ЗАВЕРШЕН УСПЕШНО");
    }
}
