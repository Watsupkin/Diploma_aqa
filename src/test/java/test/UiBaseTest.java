package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.SQL;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class UiBaseTest {

    static String appUrl = System.getProperty("sut.url");

    @BeforeEach
    public void openSource() {
        open(appUrl);
        SQL.cleanTable();
    }

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("Allure");
    }
}
