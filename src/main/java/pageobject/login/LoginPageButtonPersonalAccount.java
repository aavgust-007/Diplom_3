package pageobject.login;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.BasePage;
import pageobject.MainPage;

import java.time.Duration;

public class LoginPageButtonPersonalAccount extends BasePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";
    private final By emailInput = By.xpath(".//input[@class='text input__textfield text_type_main-default']");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By logInButtonInput = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By designerButtonInput = By.xpath("//p[starts-with(text(),'Конструктор')]");
    private final By labelButtonInput = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public LoginPageButtonPersonalAccount(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы авторизации")
    public LoginPageButtonPersonalAccount open() {
        driver.get(URL);
        return this;
    }

    @Step("Ввод email")
    public LoginPageButtonPersonalAccount enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPageButtonPersonalAccount enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки войти")
    public MainPage enterLogInButton() {
        WebElement element = driver.findElement(logInButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new MainPage(driver);
    }

    @Step("Ожидание доступности поля Email")
    public LoginPageButtonPersonalAccount waitForfieldEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logInButtonInput));
        return this;
    }

    @Step("Ожидание доступности кнопки Войти")
    public LoginPageButtonPersonalAccount waitForButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logInButtonInput));
        return this;
    }

    @Step("Нажатие на кнопку конструктор")
    public MainPage enterDesignerButton() {
        WebElement element = driver.findElement(designerButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new MainPage(driver);
    }

    @Step("Нажатие на логотип Stellar Burgers")
    public MainPage enterLabelButton() {
        WebElement element = driver.findElement(labelButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new MainPage(driver);
    }

    @Step("Отображение кнопки Войти")
    public boolean isEntranceLabel() {
        return driver.findElement(logInButtonInput).isDisplayed();
    }
}
