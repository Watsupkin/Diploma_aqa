package test;

import data.Data;
import data.SQL;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PayPage;

import static data.Data.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HappyPathPayTest extends UiBaseTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayCard() {
        mainPage.PayWitchCard();
    }

    @Test
    void shouldSuccessPayIfApprovedCard() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldSuccessAlert();

        assertEquals("APPROVED", SQL.getPaymentStatus());
    }


    @Test
    void shouldFailPayIfDeclinedCard() {
        val cardData = new Data.CardData(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();

        assertEquals("DECLINED", SQL.getPaymentStatus());
    }
}
