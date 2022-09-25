package java;

import locator.MainPage;
import locator.login.LoginFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.my.second.BaseUITest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExitTest extends BaseUITest {
    @Test
    @DisplayName("Проверка выхода из личного кабинета")
    public void goToLabelTest() {
        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.enterLogInButtonAccount(email, password);
        boolean isentranceLabel = new MainPage(driver).
                logInToYourAccountButtonInputAuth().
                waitForLoadPersonalAccount().
                exitButton().
                waitForButton().
                isEntranceLabel();
        assertTrue(isentranceLabel, "the exit button does not work");
    }
}
