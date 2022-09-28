package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.login.LoginPageButtonPersonalAccount;

import java.time.Duration;

public class MainPage extends BasePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final By logInToYourAccountButtonInput = By.xpath("//button[starts-with(text(),'Войти в аккаунт')]");
    private final By rollsInput = By.xpath(".//span[starts-with(text(),'Булки')]");
    private final By personalAccountButtonInput = By.xpath("//p[starts-with(text(),'Личный Кабинет')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие главной страницы")
    public MainPage open() {
        driver.get(URL);
        return this;
    }

    @Step("Ожидание отображения главной страницы")
    public MainPage waitForLoadMain() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("AppHeader_header__nav__g5hnF")));
        return this;
    }

    @Step("Ожидание раздела Булки")
    public String isMainPage() {
        WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(rollsInput));
        return driver.getCurrentUrl();
    }

    @Step("Нажатие на кнопку Войти")
    public LoginPageButtonPersonalAccount enterLogInButton() {
        WebElement element = driver.findElement(logInToYourAccountButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    @Step("Нажатие на кнопку Личный кабинет")
    public PersonalAccountPage logInToYourAccountButtonInputAuth() {
        WebElement element = driver.findElement(personalAccountButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new PersonalAccountPage(driver);
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public LoginPageButtonPersonalAccount logInToYourAccountButtonInputNoAuth() {
        WebElement element = driver.findElement(personalAccountButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    @Step("Нажатие на разделы Булки, Соусы, Начинки")
    public String enterRollsInput(String ingredient) {
        String str = "//span[starts-with(text(),'" + ingredient + "')]";
        By elementDeigner = By.xpath(str);
        System.out.println(elementDeigner);
        WebElement element = driver.findElement(elementDeigner);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementDeigner));
        WebElement parentElement = element.findElement(By.xpath("./.."));
        return parentElement.getAttribute("class");
    }
}
