package ru.netology.test;

import ru.netology.data.Data;
import ru.netology.data.SQL;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;
import ru.netology.page.PayPage;

import static ru.netology.data.Data.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HappyPathPayTest extends UiBaseTest {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    void setUpForPayCard() {
        mainPage.PayWitchCard();
    }

    @Test
    void shouldSuccessPayIfValidApprovedCards() {
        val cardData = new Data.CardData(getApprovedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldSuccessAlert();

        assertEquals("APPROVED", SQL.getPaymentStatus());
    }


    @Test
    void shouldFailurePayIfValidDeclinedCards() {
        val cardData = new Data.CardData(getDeclinedCardNumber(), getValidMonth(), getValidYear(), getValidName(), getCvv());
        payPage.fillCardDate(cardData);
        payPage.shouldFailAlert();

        assertEquals("DECLINED", SQL.getPaymentStatus());
    }
}
