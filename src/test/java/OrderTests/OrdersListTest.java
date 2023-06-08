package OrderTests;

import static io.restassured.RestAssured.given;

public class OrdersListTest {
    @org.junit.Test
    @io.qameta.allure.junit4.DisplayName("Получение списка заказов")
    @io.qameta.allure.Description("Получаем список заказов без courierId")
    public void getOrdersList() {

        java.util.List<java.util.ArrayList> orders = given()
                .contentType(io.restassured.http.ContentType.JSON)
                .when()
                .get("http://qa-scooter.praktikum-services.ru/api/v1/orders")
                .then()
                .statusCode(200)
                .log().all()
                .extract().jsonPath().get("orders");
    }
}