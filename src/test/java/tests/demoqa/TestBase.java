package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.componentsOfCalenderAndAttach.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void beforeAll() {

        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        // Configuration.remote = format("");
        // Configuration.remote = format("https://%s:%s@%s&quot;, credentials.login(), credentials.password(),
        //System.getProperty("url")
         Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
