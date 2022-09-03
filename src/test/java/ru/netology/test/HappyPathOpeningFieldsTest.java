package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.page.MainPage;

public class HappyPathOpeningFieldsTest extends UiBaseTest {

    @Test
    void shouldGetPaymentPage() {
        val mainPage = new MainPage();
        mainPage.PayWitchCard();
    }

    @Test
    void shouldGetCreditPage() {
        val mainPage = new MainPage();
        mainPage.PayWitchCredit();
    }
}
