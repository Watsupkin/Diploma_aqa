package ru.netology.test;

import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardYearPayFieldTest extends UiBaseTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayCard() {
        mainPage.PayWitchCard();
    }

    @Test
    void shouldSuccessPayIfPastYear() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getPastYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldExpiredDateAlert();
    }

    @Test
    void shouldSuccessPayIfLettersYear() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getLettersYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayIfYearWithOneDigit() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getOneNumYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayIfLastYear() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getFutureYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldExpiredDateAlert();
    }

    @Test
    void shouldSuccessPayIf23Year() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getNextYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
        payPage.shouldSuccessAlertHidden();
    }

    @Test
    void shouldSuccessPayIf27Year() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.get27Year(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
        payPage.shouldSuccessAlertHidden();
    }

    @Test
    void shouldSuccessPayIfYearWithSigns() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getSymbolsYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayIfYearEmptyField() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getEmptyYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
