package test;

import data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class CardYearPayFieldTest extends UiBaseTest{

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayCard() {
        mainPage.PayWitchCard();
    }

    @Test
    void shouldSuccessPayIfPastYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getPastYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldExpiredDateAlert();
    }

    @Test
    void shouldSuccessPayIfLettersYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getLettersYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayIfYearWithOneDigit() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getOneNumYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayIfLastYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getFutureYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldExpiredDateAlert();
    }

    @Test
    void shouldSuccessPayIf23Year() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getNextYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
        payPage.shouldSuccessAlertHidden();
    }

    @Test
    void shouldSuccessPayIf27Year() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), get27Year(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
        payPage.shouldSuccessAlertHidden();
    }

    @Test
    void shouldSuccessPayIfYearWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getSymbolsYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayIfYearEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getEmptyYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
