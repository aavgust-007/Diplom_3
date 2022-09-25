package locator.login;

import locator.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPasswordRecovery extends BasePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By loginButtonInput = By.xpath("//a[starts-with(text(),'Войти')]");


    public LoginPasswordRecovery(WebDriver driver) {
        super(driver);
    }

    public LoginPasswordRecovery open() {
        driver.get(URL);
        return this;
    }

    public LoginPageButtonPersonalAccount enterLogInButton() {

        WebElement element = driver.findElement(loginButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    public LoginPasswordRecovery waitForButtonAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(loginButtonInput));
        return this;
    }
}
