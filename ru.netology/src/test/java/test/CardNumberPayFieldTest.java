package test;

import data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class CardNumberPayFieldTest extends UiBaseTest{

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpPayWithCard() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldFailurePaymentIfWrongBigCardNumber() {
        val cardData = new Data.CardData(getLongCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailurePaymentIfLettersCardNumber() {
        val cardData = new Data.CardData(getLettersCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailurePaymentIfShortUnknownCardNumber() {
        val cardData = new Data.CardData(getShortCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailurePaymentIfUnknownCardNumber() {
        val cardData = new Data.CardData(getUnknownCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailurePaymentIfZerosCardNumber() {
        val cardData = new Data.CardData(getZerosCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailurePaymentIfCardNumberWithSigns() {
        val cardData = new Data.CardData(getSymbolsCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailurePaymentIfCardNumberWithEmptyField() {
        val cardData = new Data.CardData(getEmptyCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
