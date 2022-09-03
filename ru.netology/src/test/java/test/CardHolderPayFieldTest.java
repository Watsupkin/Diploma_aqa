package test;

import data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class CardHolderPayFieldTest extends UiBaseTest{

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpOwner() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldSuccessPayIfNameInRussian() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getRussianName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameWithNumbers() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameWitchNums(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameWithSigns() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getNameWitchSymbols(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameOne() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getOnlyFirstName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfOneLetter() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getOneLetterName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfOwnerNameLong() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getLongName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldImproperFormatAlert();
    }

    @Test
    public void shouldSuccessPayIfNameWithHyphens() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getDoubleName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldSuccessAlert();
    }

    @Test
    public void shouldSuccessPayIfNameEmptyField() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getEmptyName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
    }
}
