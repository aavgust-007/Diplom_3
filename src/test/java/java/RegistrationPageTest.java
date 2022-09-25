package java;

import io.restassured.response.ValidatableResponse;
import locator.login.LoginPageButtonPersonalAccount;
import locator.registration.Registration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.*;


public class RegistrationPageTest extends org.my.second.BaseUITest {

    @Test
    @DisplayName("Регистрация пользователя с верными данными")
    public void registrationTest() {
        LoginPageButtonPersonalAccount url = new Registration(driver).
                open().
                waitForButtonAccount().
                enterName(user.getName()).
                enterEmail(user.getEmail()).
                enterPassword(user.getPassword()).
                waitForButton().
                enterLogInButton();
        ValidatableResponse response = userClient.login(user);
        int statusCode = response.extract().statusCode();
        assertEquals(SC_OK, statusCode, "Status code is incorrecr");
        boolean actual = response.extract().path("success");
        assertTrue(actual, "user is not login");
        accessToken = response.extract().path("accessToken");
        assertNotEquals("", accessToken, "accessToken is null"
        );
    }

}
