package pageobject.registration.api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestUser {
    private static final String USER_PATH_REG = "/api/auth/register";
    private static final String USER_PATH_LOGIN = "/api/auth/login ";
    private static final String USER_UPDATE_DELETE = "api/auth/user";

    public ValidatableResponse create(User user) {
        return given().spec(getBaseSpec()).and().body(user).when().post(USER_PATH_REG).then();
    }

    public void delete(User user, String accessToken) {
        given().spec(getBaseSpecWitnToken(accessToken)).delete(USER_UPDATE_DELETE).then();
    }

    public ValidatableResponse login(User user) {
        return given().spec(getBaseSpec()).body(user).when().post(USER_PATH_LOGIN).then();
    }
}
