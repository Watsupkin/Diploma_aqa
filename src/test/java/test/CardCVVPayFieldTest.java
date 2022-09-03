package test;

import data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class CardCVVPayFieldTest extends UiBaseTest{

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpCvv() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldSuccessPayIfCVCLetters() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvvWitchLetters());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfCVCOneDigit() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvvWitchOneNum());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfCVCTwoDigits() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvvWitchTwoNums());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfCVCWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvvWitchSymbols());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfCVCEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getEmptyCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
