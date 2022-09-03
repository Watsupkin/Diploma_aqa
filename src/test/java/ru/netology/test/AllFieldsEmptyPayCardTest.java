package ru.netology.test;

import ru.netology.data.Data;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AllFieldsEmptyPayCardTest extends UiBaseTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpEmpty() {
        mainPage.PayWitchCard();
    }

    @Test
    public void shouldSuccessPayIfValidApprovedCards() {
        val cardData = new Data.CardData(Data.getEmptyCardNumber(), Data.getEmptyMonth(), Data.getEmptyYear(), Data.getEmptyName(), Data.getEmptyCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldEmptyImproperFormatAlert();
        payPage.shouldImproperFormatAlertHidden();
    }
}
