package pageobject.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BasePage;

import java.time.Duration;

public class LoginRegistration extends BasePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/register";
    private final By loginButtonInput = By.xpath("//a[starts-with(text(),'Войти')]");

    public LoginRegistration(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы регистрации")
    public LoginRegistration open() {
        driver.get(URL);
        return this;
    }

    @Step("Открытие страницы регистрации")
    public LoginPageButtonPersonalAccount enterLogInButton() {
        WebElement element = driver.findElement(loginButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    @Step("Нажатие на кнопку Войти")
    public LoginRegistration waitForButtonAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButtonInput));
        return this;
    }
}
