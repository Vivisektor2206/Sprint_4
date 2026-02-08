package ru.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class MainPageFAQTest extends MainPageFAQTestData {

    private final String questionKey;
    private final String answer;
    private final String expectedText;

    public MainPageFAQTest(String questionKey, String answer, String expectedText) {
        this.questionKey = questionKey;
        this.answer = answer;
        this.expectedText = expectedText;
    }


    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getFAQTestParameters() {
        return MainPageFAQTestData.getFAQTestParameters();
    }

    @Test
    public void checkRightAnswersInFAQ() {
        driver.get(MainPageFAQTestData.BASE_URL);
        MainPageFAQTestData checkFAQAnswers = new MainPageFAQTestData();
        checkFAQAnswers.wait = this.wait;
        checkFAQAnswers.arrowOpensExpectedText(questionKey, answer, expectedText);
    }
}
