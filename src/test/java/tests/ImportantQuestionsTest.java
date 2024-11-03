package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.MainPageConstants;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {
    private final String questionMessage;
    private final String answerMessage;

    public ImportantQuestionsTest(String questionMessage, String answerMessage, String browser) {
        super(browser);
        this.questionMessage = questionMessage;
        this.answerMessage = answerMessage;
    }

    @Parameterized.Parameters
    public static Object[] setTestParameters() {
        return new Object[][]{
                {MainPageConstants.CHARGER_QUESTION, MainPageConstants.CHARGER_ANSWER, "chrome"},
                {MainPageConstants.EXTEND_RETURN_QUESTION, MainPageConstants.EXTEND_RETURN_ANSWER, "chrome"},
                {MainPageConstants.HOW_MUCH_QUESTION, MainPageConstants.HOW_MUCH_ANSWER, "chrome"},
                {MainPageConstants.SEVERAL_ORDER_QUESTION, MainPageConstants.SEVERAL_ORDER_ANSWER, "chrome"},
                {MainPageConstants.RENT_TIME_QUESTION, MainPageConstants.RENT_TIME_ANSWER, "chrome"},
                {MainPageConstants.ORDER_TODAY_QUESTION, MainPageConstants.ORDER_TODAY_ANSWER, "chrome"},
                {MainPageConstants.ORDER_CANSEL_QUESTION, MainPageConstants.ORDER_CANSEL_ANSWER, "chrome"},
                {MainPageConstants.MKAD_LIVE_QUESTION, MainPageConstants.MKAD_LIVE_ANSWER, "chrome"},
                {MainPageConstants.CHARGER_QUESTION, MainPageConstants.CHARGER_ANSWER, "firefox"},
                {MainPageConstants.EXTEND_RETURN_QUESTION, MainPageConstants.EXTEND_RETURN_ANSWER, "firefox"},
                {MainPageConstants.HOW_MUCH_QUESTION, MainPageConstants.HOW_MUCH_ANSWER, "firefox"},
                {MainPageConstants.SEVERAL_ORDER_QUESTION, MainPageConstants.SEVERAL_ORDER_ANSWER, "firefox"},
                {MainPageConstants.RENT_TIME_QUESTION, MainPageConstants.RENT_TIME_ANSWER, "firefox"},
                {MainPageConstants.ORDER_TODAY_QUESTION, MainPageConstants.ORDER_TODAY_ANSWER, "firefox"},
                {MainPageConstants.ORDER_CANSEL_QUESTION, MainPageConstants.ORDER_CANSEL_ANSWER, "firefox"},
                {MainPageConstants.MKAD_LIVE_QUESTION, MainPageConstants.MKAD_LIVE_ANSWER, "firefox"},
        };
    }

    // Бывает такое, что тест падает в firefox из-за наложения элементов при загрузке
    // в chrome таких проблем нет.
    // Можно решить ожиданием через Thread, но как я поняла, такое нельзя использовать
    @Test
    public void testImportantQuestions() {
        MainPage mainPageObject = new MainPage(driver);
        mainPageObject.openMainPage();
        mainPageObject.acceptCookies();
        mainPageObject.clickFAQQuestion(questionMessage);

        assertEquals(answerMessage, mainPageObject.findAnswerElement(answerMessage).getText());
    }
}



