package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends BaseTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String rentDate;
    private final String rentPeriod;
    private final String scooterColor;
    private final String comment;

    public OrderPageTest(
            String name,
            String surname,
            String address,
            String metroStation,
            String phoneNumber,
            String rentDate,
            String rentPeriod,
            String scooterColor,
            String comment,
            String browser
    ) {
        super(browser);
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.rentDate = rentDate;
        this.rentPeriod = rentPeriod;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[] setTestParameters() {
        return new Object[][]{
                {"Петр", "Петров", "Рабочая улица 10а", "Спортивная", "+79011456712", "четверг, 28-е ноября 2024 г.", "шестеро суток", "серая безысходность", "Комментарий курьеру", "firefox"},
                {"Анна", "Смотрова", "Улица Пушкина 10а", "Водный стадион", "+79014567812", "среда, 20-е ноября 2024 г.", "двое суток", "чёрный жемчуг", "Еще один комментарий курьеру", "firefox"},
                {"Петр", "Петров", "Рабочая улица 10а", "Спортивная", "+79011456712", "четверг, 28-е ноября 2024 г.", "шестеро суток", "серая безысходность", "Комментарий курьеру", "chrome"},
                {"Анна", "Смотрова", "Улица Пушкина 10а", "Водный стадион", "+79014567812", "среда, 20-е ноября 2024 г.", "двое суток", "чёрный жемчуг", "Еще один комментарий курьеру", "chrome"}
        };
    }

    @Test
    public void testOrderWithHeaderOrderButton() {
        MainPage mainPageObject = new MainPage(driver);
        OrderPage orderPageObject = new OrderPage(driver);
        mainPageObject.openMainPage();
        mainPageObject.acceptCookies();
        mainPageObject.clickHeaderOrderButton();

        orderPageObject.fillPersonForm(name, surname, address, metroStation, phoneNumber);
        orderPageObject.clickNextButton();

        orderPageObject.fillRentForm(rentDate, rentPeriod, scooterColor, comment);
        orderPageObject.clickAcceptOrderButton();

        assertTrue(orderPageObject.findOrderConfirmedHeader().getText().contains("Заказ оформлен"));
    }

    @Test
    public void testOrderWithMiddleOrderButton() {
        MainPage mainPageObject = new MainPage(driver);
        OrderPage orderPageObject = new OrderPage(driver);
        mainPageObject.openMainPage();
        mainPageObject.acceptCookies();
        mainPageObject.clickMiddleOrderButton();

        orderPageObject.fillPersonForm(name, surname, address, metroStation, phoneNumber);
        orderPageObject.clickNextButton();

        orderPageObject.fillRentForm(rentDate, rentPeriod, scooterColor, comment);
        orderPageObject.clickAcceptOrderButton();

        // Бывает такое, что тест падает в firefox из-за наложения элементов при загрузке
        // в chrome таких проблем нет.
        // Можно решить ожиданием через Thread, но как я поняла, такое нельзя использовать
        assertTrue(orderPageObject.findOrderConfirmedHeader().getText().contains("Заказ оформлен"));
    }
}
