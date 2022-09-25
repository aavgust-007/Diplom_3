package java;

import locator.MainPage;
import locator.login.LoginFunction;
import locator.login.LoginPageButtonPersonalAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.my.second.BaseUITest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoToPageTest extends BaseUITest {
    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    public void goToAccountPageTest() {

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.enterLogInButtonAccount(email, password);
        String urlPersonalAccount = new MainPage(driver).
                logInToYourAccountButtonInputAuth().
                isPersonalAccountPage();
        assertEquals("https://stellarburgers.nomoreparties.site/account/profile", urlPersonalAccount, "the transition to the personal account does not work");

    }

    @Test
    @DisplayName("Проверка перехода в конструктор")
    public void goToDesignerTest() {
        String url = new LoginPageButtonPersonalAccount(driver).
                open().
                enterDesignerButton().
                waitForLoadMain().
                isMainPage();
        assertEquals("https://stellarburgers.nomoreparties.site/", url, "the transition to the personal account does not work");

    }

    @Test
    @DisplayName("Проверка перехода по label")
    public void goToLabelTest() {
        String url = new LoginPageButtonPersonalAccount(driver).
                open().
                enterLabelButton().
                waitForLoadMain().
                isMainPage();
        assertEquals("https://stellarburgers.nomoreparties.site/", url, "the transition to the personal account does not work");

    }
}