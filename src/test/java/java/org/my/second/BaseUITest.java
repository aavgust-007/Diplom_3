package java.org.my.second;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import locator.registration.api.User;
import locator.registration.api.UserClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseUITest {

    protected WebDriver driver;
    protected User user;
    protected String email;
    protected String password;
    protected UserClient userClient;
    protected String accessToken = "";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)/Google/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C://Users/MagicBook/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        WebDriver driver = new ChromeDriver(options);
        user = new User("rwf1sew", "rwefwwe", "Qwsfeedrty@yandex.com");
        userClient = new UserClient();
        ValidatableResponse response = userClient.create(user);
        email = response.extract().path("email");
        password = response.extract().path("password");
        accessToken = response.extract().path("accessToken");

    }

    @AfterEach
    public void teatDown() {
        if (!accessToken.isEmpty()) {
            userClient.delete(user, accessToken);
        }
        driver.quit();
    }

}
