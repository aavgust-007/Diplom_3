package locator.registration;

import locator.BasePage;
import locator.login.LoginPageButtonPersonalAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration extends BasePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/register";
    private final By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By registrationButtonInput = By.xpath("//button[starts-with(text(),'Зарегистрироваться')]");

    private final By errorMessagePassword = By.xpath("//p[starts-with(text(),'Некорректный пароль')]");

    public Registration(WebDriver driver) {
        super(driver);
    }

    public LoginPageButtonPersonalAccount enterLogInButton() {

        WebElement element = driver.findElement(registrationButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    public Registration open() {
        driver.get(URL);
        return this;
    }

    public Registration waitForButtonAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        return this;
    }

    public Registration enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public Registration enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public Registration enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public Registration waitForButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(registrationButtonInput));
        return this;
    }

    public boolean waitForErrorPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(errorMessagePassword));
        return true;
    }

    public Registration enterLogInButtonErrorPassword() {

        WebElement element = driver.findElement(registrationButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new Registration(driver);
    }
}
