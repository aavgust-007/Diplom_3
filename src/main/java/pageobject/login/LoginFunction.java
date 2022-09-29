package pageobject.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginFunction extends LoginPageButtonPersonalAccount {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    public LoginFunction(WebDriver driver) {
        super(driver);
    }

    @Step("Логирование пользователя")
    public String enterLogInButtonAccount(String email, String password) {
        String url = new LoginPageButtonPersonalAccount(driver).open().waitForfieldEmail().enterEmail(email).enterPassword(password).waitForButton().
                enterLogInButton().
                waitForLoadMain().
                isMainPage();
        return url;
    }
}
