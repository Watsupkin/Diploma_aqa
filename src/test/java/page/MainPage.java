package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private static final SelenideElement payWitchCardButton = $$("button").find(Condition.exactText("Купить"));
    private static final SelenideElement payWitchCreditButton = $$("button").find(Condition.exactText("Купить в кредит"));
    private static final SelenideElement formOfPayment = $("#root > div > h3");

    public void PayWitchCard() {
        payWitchCardButton.click();
        formOfPayment.shouldHave(Condition.text("Оплата по карте"));
    }

    public void PayWitchCredit() {
        payWitchCreditButton.click();
        formOfPayment.shouldHave(Condition.text("Кредит по данным карты"));
    }
}
