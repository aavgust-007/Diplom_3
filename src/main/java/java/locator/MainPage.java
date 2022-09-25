package locator;

import locator.login.LoginPageButtonPersonalAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final By logInToYourAccountButtonInput = By.xpath("//button[starts-with(text(),'Войти в аккаунт')]");
    private final By rollsInput = By.xpath(".//span[starts-with(text(),'Булки')]");
    private final By personalAccountButtonInput = By.xpath("//p[starts-with(text(),'Личный Кабинет')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(URL);
        return this;
    }

    public MainPage waitForLoadMain() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("AppHeader_header__nav__g5hnF")));
        return this;
    }

    public String isMainPage() {
        WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(rollsInput));
        return driver.getCurrentUrl();
    }


    public LoginPageButtonPersonalAccount enterLogInButton() {

        WebElement element = driver.findElement(logInToYourAccountButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    public PersonalAccountPage logInToYourAccountButtonInputAuth() {

        WebElement element = driver.findElement(personalAccountButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new PersonalAccountPage(driver);
    }

    public LoginPageButtonPersonalAccount logInToYourAccountButtonInputNoAuth() {

        WebElement element = driver.findElement(personalAccountButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    public String enterRollsInput(String ingredient) {
        String str = "//span[starts-with(text(),'" + ingredient + "')]";
        By elementDeigner = By.xpath(str);
        System.out.println(elementDeigner);
        WebElement element = driver.findElement(elementDeigner);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(elementDeigner));
        WebElement parentElement = element.findElement(By.xpath("./.."));
        return parentElement.getAttribute("class");
    }

}
