package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
}
