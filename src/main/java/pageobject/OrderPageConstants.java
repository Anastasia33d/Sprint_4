package pageobject;

public class OrderPageConstants {
    private OrderPageConstants() {
        // закрытый конструктор, чтобы предотвратить создание экземпляра
    }

    public static final String SELECT_METRO_STATION_PATTERN = ".//button[contains(@class, 'Order_Select')]/div[text() = '%s']";
    public static final String DATE_PICKER_DAY_PATTERN = ".//div[contains(@class, 'react-datepicker__day') and contains(@aria-label, '%s')]";
    public static final String RENT_PERIOD_ELEMENT_PATTERN = ".//div[contains(@class, 'Dropdown-option') and text() = '%s']";
    public static final String SCOOTER_COLOR_PATTERN = ".//label[text() = '%s']";
}
