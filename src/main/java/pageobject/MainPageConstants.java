package pageobject;

public class MainPageConstants {
    private MainPageConstants() {
        // закрытый конструктор, чтобы предотвратить создание экземпляра
    }

    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public static final String FAQ_QUESTION_PATTERN = ".//div[contains(@id, 'accordion__heading') and contains(text(), '%s')]";
    public static final String FAQ_ANSWER_PATTERN = ".//div[contains(@id, 'accordion__panel') and not(@hidden)]/p[contains(text(), '%s')]";

    public static final String HOW_MUCH_QUESTION = "Сколько это стоит? И как оплатить?";
    public static final String SEVERAL_ORDER_QUESTION = "Хочу сразу несколько самокатов! Так можно?";
    public static final String RENT_TIME_QUESTION = "Как рассчитывается время аренды?";
    public static final String ORDER_TODAY_QUESTION ="Можно ли заказать самокат прямо на сегодня?";
    public static final String EXTEND_RETURN_QUESTION = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String CHARGER_QUESTION = "Вы привозите зарядку вместе с самокатом?";
    public static final String ORDER_CANSEL_QUESTION = "Можно ли отменить заказ?";
    public static final String MKAD_LIVE_QUESTION = "Я жизу за МКАДом, привезёте?";

    public static final String HOW_MUCH_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String SEVERAL_ORDER_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENT_TIME_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ORDER_TODAY_ANSWER ="Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXTEND_RETURN_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String CHARGER_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ORDER_CANSEL_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String MKAD_LIVE_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}
