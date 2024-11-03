package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookiesButtonLocator = By.xpath(".//button[@id='rcc-confirm-button']");
    public final By headerOrderButtonLocator = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[contains(@class, 'Button_Button')]");
    public final By middleOrderButtonLocator = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button[contains(@class, 'Button_Button')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void openMainPage() {
        driver.get(MainPageConstants.MAIN_PAGE_URL);
    }

    public void clickFAQQuestion(String questionMessage) {
        By questionLocator = By.xpath(String.format(MainPageConstants.FAQ_QUESTION_PATTERN, questionMessage));
        wait.until(ExpectedConditions.elementToBeClickable(questionLocator));

        WebElement questionElement = driver.findElement(questionLocator);
        scrollToElement(questionElement);

        questionElement.click();
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public WebElement findAnswerElement(String answerMessage) {
        By answerLocator = By.xpath(String.format(MainPageConstants.FAQ_ANSWER_PATTERN, answerMessage));
        wait.until(ExpectedConditions.visibilityOfElementLocated((answerLocator)));

        return driver.findElement(answerLocator);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookiesButtonLocator));

        driver.findElement(cookiesButtonLocator).click();
    }

    public void clickHeaderOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(headerOrderButtonLocator));
        driver.findElement(headerOrderButtonLocator).click();
    }

    public void clickMiddleOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(middleOrderButtonLocator));

        WebElement middleOrderButton = driver.findElement(middleOrderButtonLocator);
        scrollToElement(middleOrderButton);
        middleOrderButton.click();
    }
}
