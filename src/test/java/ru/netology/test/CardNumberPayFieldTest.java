package ru.netology.test;

import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardNumberPayFieldTest extends UiBaseTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpPayWithCard() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldFailurePaymentIfWrongBigCardNumber() {
        val cardData = new Data.CardData(Data.getLongCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailurePaymentIfLettersCardNumber() {
        val cardData = new Data.CardData(Data.getLettersCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailurePaymentIfShortUnknownCardNumber() {
        val cardData = new Data.CardData(Data.getShortCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailurePaymentIfUnknownCardNumber() {
        val cardData = new Data.CardData(Data.getUnknownCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailurePaymentIfZerosCardNumber() {
        val cardData = new Data.CardData(Data.getZerosCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();
    }

    @Test
    public void shouldFailurePaymentIfCardNumberWithSigns() {
        val cardData = new Data.CardData(Data.getSymbolsCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldFailurePaymentIfCardNumberWithEmptyField() {
        val cardData = new Data.CardData(Data.getEmptyCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
