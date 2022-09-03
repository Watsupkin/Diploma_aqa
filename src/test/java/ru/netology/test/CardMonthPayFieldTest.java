package ru.netology.test;

import ru.netology.data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

public class CardMonthPayFieldTest extends UiBaseTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpPayWithCard() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldSuccessPayIfMonthMore12() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getMonthNotInRange(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldInvalidDateAlert();
    }

    @Test
    public void shouldSuccessPayIfLettersMonth() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getMonthWitchLetters(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithOneDigit() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getMonthWitchOneNum(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithZeros() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getMonthWitchZeros(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldInvalidDateAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithSigns() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getMonthWitchSymbols(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfMonthWithEmptyField() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getEmptyMonth(), Data.getValidYear(), Data.getValidName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
