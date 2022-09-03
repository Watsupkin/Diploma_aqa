package test;

import data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class CardMonthPayFieldTest extends UiBaseTest{

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpPayWithCard() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldSuccessPayIfMonthMore12() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthNotInRange(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldInvalidDateAlert();
    }

    @Test
    public void shouldSuccessPayIfLettersMonth() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWitchLetters(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithOneDigit() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWitchOneNum(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithZeros() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWitchZeros(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldInvalidDateAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getMonthWitchSymbols(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getEmptyMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
