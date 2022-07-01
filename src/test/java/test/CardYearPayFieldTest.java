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
    void shouldSuccessPayPastYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getPastYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldExpiredDateAlert();
    }

    @Test
    void shouldSuccessPayLetterYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getLettersYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayOneNumYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getOneNumYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayLastYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getFutureYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldExpiredDateAlert();
    }

    @Test
    void shouldSuccessPayNextYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getNextYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
        payPage.shouldSuccessAlertHidden();
    }

    @Test
    void shouldSuccessPay27Year() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), get27Year(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
        payPage.shouldSuccessAlertHidden();
    }

    @Test
    void shouldSuccessPaySymbolsYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getSymbolsYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    void shouldSuccessPayEmptyYear() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getEmptyYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
