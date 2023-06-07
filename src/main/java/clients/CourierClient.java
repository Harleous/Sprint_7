package clients;

import static io.restassured.RestAssured.given;

public class CourierClient extends BaseClient {
    public static io.restassured.response.ValidatableResponse login(pojoClasses.LoginCourier loginCourier) {
     return   given()
             .spec(getSpec())
                .body(loginCourier)
                .when()
                .post("/api/v1/courier/login")
                .then();

    }
    public static io.restassured.response.ValidatableResponse loginNologin (pojoClasses.NoLoginCourierLogin noLoginCourierLogin) {
        return   given()
                .spec(getSpec())
                .body(noLoginCourierLogin)
                .when()
                .post("/api/v1/courier/login")
                .then();

    }


    public static io.restassured.response.ValidatableResponse delete(int id) {
       return given()
               .spec(getSpec())
                .contentType(io.restassured.http.ContentType.JSON)
                .when()
                .delete("/api/v1/courier/{id}", id)
                .then();
    }


    public io.restassured.response.ValidatableResponse create(pojoClasses.CreateCourier createCourier) {

       return given()
               .spec(getSpec())
                .contentType(io.restassured.http.ContentType.JSON)
                .body(createCourier)
                .when()
                .post("/api/v1/courier")
                .then();

    }
}
