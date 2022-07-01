package test;

import data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class CardNumberFieldTest extends UiBaseTest{

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpPayWithCard() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldFailPayIfLongCardNumber() {
        val cardData = new Data.CardData(getLongCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailPayIfLettersCardNumber() {
        val cardData = new Data.CardData(getLettersCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailPayIfShortCardNumber() {
        val cardData = new Data.CardData(getShortCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailPayIfUnknownCardNumber() {
        val cardData = new Data.CardData(getUnknownCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailPayIfZerosCardNumber() {
        val cardData = new Data.CardData(getZerosCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailPayIfSymbolsCardNumber() {
        val cardData = new Data.CardData(getSymbolsCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailPayIfEmptyCardNumber() {
        val cardData = new Data.CardData(getEmptyCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
