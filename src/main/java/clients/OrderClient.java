package clients;

import static io.restassured.RestAssured.given;

public class OrderClient extends BaseClient {
    public io.restassured.response.ValidatableResponse create(pojoClasses.OrderCreate getOrderCreateData) {

        return given()
                .spec(getSpec())
                .contentType(io.restassured.http.ContentType.JSON)
                .body(getOrderCreateData)
                .when()
                .post("/api/v1/orders")
                .then();

    }
}
