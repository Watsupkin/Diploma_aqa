package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.Data;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PayPage {

    private final SelenideElement fieldCardNumber = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement fieldNumberOfMonth = $("input[placeholder='08']");
    private final SelenideElement fieldYear = $("input[placeholder='22']");
    private final ElementsCollection fieldSet = $$(".input__control");
    private final SelenideElement fieldOwner = fieldSet.get(3);
    private final SelenideElement fieldCvv = $("input[placeholder='999']");

    private final SelenideElement improperFormat = $(byText("Неверный формат"));
    private final SelenideElement emptyField = $(byText("Поле обязательно для заполнения"));
    private final SelenideElement invalidDate = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement expiredDate = $(byText("Истёк срок действия карты"));
    private final SelenideElement successAlert = $(byText("Операция одобрена Банком."));
    private final SelenideElement failAlert = $(byText("Ошибка! Банк отказал в проведении операции."));

    private final SelenideElement continueButton = $$("button").find(Condition.exactText("Продолжить"));

    public void fillCardDate(Data.CardData cardData) {
        fieldCardNumber.setValue(cardData.getNumber());
        fieldNumberOfMonth.setValue(cardData.getMonth());
        fieldYear.setValue(cardData.getYear());
        fieldOwner.setValue(cardData.getOwner());
        fieldCvv.setValue(cardData.getCvv());
        continueButton.click();
    }

    public void shouldImproperFormatAlert() {improperFormat.shouldBe(Condition.visible);}
    public void shouldImproperFormatAlertHidden() {improperFormat.shouldBe(Condition.hidden);}
    public void shouldEmptyImproperFormatAlert() {emptyField.shouldBe(Condition.visible);}
    public void shouldInvalidDateAlert() {invalidDate.shouldBe(Condition.visible);}
    public void shouldExpiredDateAlert() {expiredDate.shouldBe(Condition.visible);}
    public void shouldSuccessAlert() {successAlert.shouldBe(Condition.visible, Duration.ofSeconds(30));}
    public void shouldSuccessAlertHidden() {successAlert.shouldBe(Condition.hidden, Duration.ofSeconds(30));}
    public void shouldFailAlert() {failAlert.shouldBe(Condition.visible, Duration.ofSeconds(30));}
}
