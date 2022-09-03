package ru.netology.test;

import ru.netology.data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

public class CardHolderPayFieldTest extends UiBaseTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpOwner() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldSuccessPayIfNameInRussian() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getRussianName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameWithNumbers() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getNameWitchNums(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameWithSigns() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getNameWitchSymbols(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameOne() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getOnlyFirstName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfOneLetter() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getOneLetterName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfOwnerNameLong() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getLongName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameWithHyphens() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getDoubleName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldSuccessAlert();
    }

    @Test
    public void shouldSuccessPayIfNameEmptyField() {
        val cardData = new Data.CardData(Data.getApprovedCardNumber(), Data.getValidMonth(), Data.getValidYear(), Data.getEmptyName(), Data.getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
