package locator.login;

import locator.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPersonalAccount extends BasePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private final By personalAccountButtonInput = By.xpath("//p[starts-with(text(),'Личный Кабинет')]");

    public LoginPersonalAccount(WebDriver driver) {

        super(driver);
    }

    public LoginPersonalAccount open() {
        driver.get(URL);
        return this;
    }

    public LoginPageButtonPersonalAccount enterLogInButton() {

        WebElement element = driver.findElement(personalAccountButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }

    public LoginPersonalAccount waitForButtonAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(personalAccountButtonInput));
        return this;
    }
}
