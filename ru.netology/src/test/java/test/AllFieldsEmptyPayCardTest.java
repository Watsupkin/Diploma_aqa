package test;

import data.Data;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;

public class AllFieldsEmptyPayCardTest extends UiBaseTest{

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpEmpty() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldSuccessPayIfValidApprovedCards() {
        val cardData = new Data.CardData(getEmptyCardNumber(), getEmptyMonth(), getEmptyYear(), getEmptyName(), getEmptyCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
        payPage.shouldImproperFormatAlertHidden();
    }
}