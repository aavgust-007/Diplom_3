package locator.login;

import org.openqa.selenium.WebDriver;

public class LoginFunction extends LoginPageButtonPersonalAccount {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    public LoginFunction(WebDriver driver) {
        super(driver);
    }

    public String enterLogInButtonAccount(String email, String password) {
        String url = new LoginPageButtonPersonalAccount(driver).
                open().waitForfieldEmail().
                enterEmail("aavgust-007@yandex.com").
                enterPassword("Qwerty").
                waitForButton().
                enterLogInButton().
                waitForLoadMain().
                isMainPage();
        return url;
    }
}
