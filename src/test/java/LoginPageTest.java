import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.my.second.BaseUITest;
import pageobject.MainPage;
import pageobject.login.LoginPasswordRecovery;
import pageobject.login.LoginRegistration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BaseUITest {

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void enterLogInButtonAccount() {

        String url = new MainPage(driver).
                open().
                waitForLoadMain().
                enterLogInButton().
                waitForfieldEmail().
                enterEmail("aavgust-007@yandex.com").
                enterPassword("Qwerty").
                waitForButton().
                enterLogInButton().
                waitForLoadMain().
                isMainPage();
        assertEquals("https://stellarburgers.nomoreparties.site/", url, "the login by the log in to account button on the main page does not work");
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void enterLogInButtonPersonalAccount() {

        String url = new MainPage(driver).
                open().
                waitForLoadMain().
                logInToYourAccountButtonInputNoAuth().
                waitForfieldEmail().
                enterEmail("aavgust-007@yandex.com").
                enterPassword("Qwerty").
                waitForButton().
                enterLogInButton().
                waitForLoadMain().
                isMainPage();
        assertEquals("https://stellarburgers.nomoreparties.site/", url, "Login via the Personal Account button does not work");
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void enterLogInButtonRegistration() {
        String url = new LoginRegistration(driver).
                open().
                waitForButtonAccount().
                enterLogInButton().
                waitForfieldEmail().
                enterEmail("aavgust-007@yandex.com").
                enterPassword("Qwerty").
                waitForButton().
                enterLogInButton().
                waitForLoadMain().
                isMainPage();
        assertEquals("https://stellarburgers.nomoreparties.site/", url, "login via the button in the registration form does not work");
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void enterLoginPasswordRecovery() {

        String url = new LoginPasswordRecovery(driver).
                open().
                waitForButtonAccount().
                enterLogInButton().
                waitForfieldEmail().
                enterEmail("aavgust-007@yandex.com").
                enterPassword("Qwerty").
                waitForButton().
                enterLogInButton().
                waitForLoadMain().
                isMainPage();
        assertEquals("https://stellarburgers.nomoreparties.site/", url, "login via the button in the password recovery form does not work");
    }
}
