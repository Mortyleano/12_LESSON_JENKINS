package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.utils.Attachments;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeEach
    public void settingsTest() {
        Configuration.baseUrl = System.getProperty("BASE_URL");
        Configuration.browser = System.getProperty("BROWSER");
        Configuration.browserVersion = System.getProperty("BROWSER_VERSION");
        Configuration.browserSize = System.getProperty("WINDOW_SIZE");
        Configuration.remote = System.getProperty("REMOTE_URL");
        Configuration.pageLoadStrategy = "eager";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void settingsAfterTest() {
        Attachments.screenshotAs("Изображение последнего события из теста");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        closeWebDriver();
    }
}