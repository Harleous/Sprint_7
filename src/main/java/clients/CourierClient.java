package clients;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import pojoClasses.CreateCourier;
import pojoClasses.LoginCourier;
import pojoClasses.NoLoginCourierLogin;
import pojoClasses.NotValidLoginPassword;

import static io.restassured.RestAssured.given;

public class CourierClient extends BaseClient {
    public static ValidatableResponse login(LoginCourier loginCourier) {
     return   given()
             .spec(getSpec())
                .body(loginCourier)
                .when()
                .post("/api/v1/courier/login")
                .then();

    }
    public static ValidatableResponse loginNologin (NoLoginCourierLogin noLoginCourierLogin) {
        return   given()
                .spec(getSpec())
                .body(noLoginCourierLogin)
                .when()
                .post("/api/v1/courier/login")
                .then();

    }

    public static ValidatableResponse loginNotValidLoginPassword (NotValidLoginPassword notValidLoginPassword) {
        return   given()
                .spec(getSpec())
                .body(notValidLoginPassword)
                .when()
                .post("/api/v1/courier/login")
                .then();

    }
    public static ValidatableResponse delete(int id) {
       return given()
               .spec(getSpec())
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/v1/courier/{id}", id)
                .then();
    }


    public ValidatableResponse create(CreateCourier createCourier) {

       return given()
               .spec(getSpec())
                .contentType(ContentType.JSON)
                .body(createCourier)
                .when()
                .post("/api/v1/courier")
                .then();

    }
}
