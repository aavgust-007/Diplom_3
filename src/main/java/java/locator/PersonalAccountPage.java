package locator;

import locator.login.LoginPageButtonPersonalAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage extends BasePage {
    private final By personalAccountPageInput = By.xpath(".//p[starts-with(text(),'В этом разделе вы можете изменить свои персональные данные')]");
    private final By exitButtonInput = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");
    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    public String isPersonalAccountPage() {
        WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(personalAccountPageInput));
        return driver.getCurrentUrl();
    }

    public PersonalAccountPage waitForLoadPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("Profile_buttonBox__1JlBI")));
        return this;
    }

    public LoginPageButtonPersonalAccount exitButton() {

        WebElement element = driver.findElement(exitButtonInput);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return new LoginPageButtonPersonalAccount(driver);
    }
}
