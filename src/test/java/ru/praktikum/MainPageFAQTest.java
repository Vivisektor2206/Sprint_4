package ru.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


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


    @Parameterized.Parameters(name = "Ожидаемый текст: {2}")
    public static Object[][] getFAQTestParameters() {
        return MainPageFAQTestData.getFAQTestParameters();
    }

    @Test
    public void checkRightAnswersInFAQ() {
        driver.get(MainPageFAQTestData.BASE_URL);
        MainPageFAQTestData checkFAQAnswers = new MainPageFAQTestData();
        checkFAQAnswers.wait = this.wait;
        checkFAQAnswers.arrowOpensExpectedText(questionKey, answer, expectedText);
        assertEquals("Текст не совпадает с ожидаемым! ТЕСТ НЕ ПРОЙДЕН", expectedText, takeActualTextFromElement(answer));
    }
}
