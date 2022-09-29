import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageobject.registration.Registration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegistrationParameterizedTest extends org.my.second.BaseUITest {

    @ValueSource(strings = {"fdgdf", "dfgdf", "2"})

    @ParameterizedTest
    @DisplayName("Проверка пароля")

    public void checkPasswordTest(String password) {
        boolean actual = new Registration(driver).
                open().
                waitForButtonAccount().
                enterName("Теdст").
                enterEmail("txssdest@yandex.com").
                enterPassword(password).
                waitForButton().
                enterLogInButtonErrorPassword().
                waitForErrorPassword();
        assertTrue(actual, "incorrect message processing with an incorrect password");
    }
}

