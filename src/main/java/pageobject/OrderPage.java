package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By personFormLocator = By.xpath(".//div[starts-with(@class, 'Order_Form')]");
    private final By nameInputLocator = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameInputLocator = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressInputLocator = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationInputLocator = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneNumberInputLocator = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButtonLocator = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button");
    private final By metroSearchSelectLocator = By.xpath(".//div[@class='select-search__select']");

    private final By orderDateInputLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentPeriodInputLocator = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By commentInputLocator = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By finalOrderButtonLocator = By.xpath(".//button[contains(@class, 'Button_Middle') and text() = 'Заказать']");
    private final By rentFormLocator = By.xpath(".//div[contains(@class, 'Order_Form')]");
    private final By acceptOrderButtonLocator = By.xpath(".//button[contains(@class, 'Button_Middle') and text() = 'Да']");
    private final By orderConfirmedHeaderLocator = By.xpath(".//div[contains(@class, 'Order_ModalHeader') and text() = 'Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void fillPersonForm(String name, String surname, String address, String metroStation, String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(personFormLocator)));

        driver.findElement(nameInputLocator).sendKeys(name);
        driver.findElement(surnameInputLocator).sendKeys(surname);
        driver.findElement(addressInputLocator).sendKeys(address);

        wait.until(ExpectedConditions.elementToBeClickable(metroStationInputLocator));
        driver.findElement(metroStationInputLocator).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(metroSearchSelectLocator)));
        selectMetroStation(metroStation);

        driver.findElement(phoneNumberInputLocator).sendKeys(phoneNumber);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    private void selectMetroStation(String station) {
        By selectMetroStationLocator = By.xpath(String.format(OrderPageConstants.SELECT_METRO_STATION_PATTERN, station));
        wait.until(ExpectedConditions.elementToBeClickable(selectMetroStationLocator));

        WebElement stationElement = driver.findElement(selectMetroStationLocator);
        scrollToElement(stationElement);
        stationElement.click();
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
        driver.findElement(nextButtonLocator).click();
    }

    public void fillRentForm(String date, String period, String scooterColor, String comment) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(rentFormLocator)));
        selectRentDate(date);
        selectOrderRentPeriod(period);
        selectScooterColor(scooterColor);

        driver.findElement(commentInputLocator).sendKeys(comment);

        wait.until(ExpectedConditions.elementToBeClickable(finalOrderButtonLocator));
        driver.findElement(finalOrderButtonLocator).click();
    }

    private void selectRentDate(String orderDate) {
        wait.until(ExpectedConditions.elementToBeClickable(orderDateInputLocator));
        driver.findElement(orderDateInputLocator).click();

        By datePickerDayLocator = By.xpath(String.format(OrderPageConstants.DATE_PICKER_DAY_PATTERN, orderDate));
        wait.until(ExpectedConditions.elementToBeClickable(datePickerDayLocator));
        driver.findElement(datePickerDayLocator).click();
    }

    private void selectOrderRentPeriod(String rentPeriod) {
        wait.until(ExpectedConditions.elementToBeClickable(rentPeriodInputLocator));
        driver.findElement(rentPeriodInputLocator).click();

        By rentPeriodElementLocator = By.xpath(String.format(OrderPageConstants.RENT_PERIOD_ELEMENT_PATTERN, rentPeriod));
        wait.until(ExpectedConditions.elementToBeClickable(rentPeriodElementLocator));

        WebElement rentPeriodElement = driver.findElement(rentPeriodElementLocator);
        scrollToElement(rentPeriodElement);
        rentPeriodElement.click();
    }

    private void selectScooterColor(String color) {
        By scooterColorLocator = By.xpath(String.format(OrderPageConstants.SCOOTER_COLOR_PATTERN, color));
        wait.until(ExpectedConditions.elementToBeClickable(scooterColorLocator));

        driver.findElement(scooterColorLocator).click();
    }

    public void clickAcceptOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptOrderButtonLocator));

        driver.findElement(acceptOrderButtonLocator).click();
    }

    public WebElement findOrderConfirmedHeader() {
        WebElement orderConfirmedHeader = driver.findElement(orderConfirmedHeaderLocator);
        wait.until(ExpectedConditions.visibilityOf(orderConfirmedHeader));

        return orderConfirmedHeader;
    }
}

