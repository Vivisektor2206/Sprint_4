package ru.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By COOKIE_BUTTON = By.id("rcc-confirm-button");
    private static final String FAQ_QUESTION_ID = "accordion__heading-%d";
    private static final String FAQ_ANSWER_ID = "accordion__panel-%d";
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";


    public void acceptCookies() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void clickFaqQuestion(int index) {
        By faqQuestions = By.id(String.format(FAQ_QUESTION_ID, index));
        WebElement element = driver.findElement(faqQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public String getFaqAnswerText(int index) {
        By faqAnswers = By.id(String.format(FAQ_ANSWER_ID, index));
        return driver.findElement(faqAnswers).getText();
    }
}