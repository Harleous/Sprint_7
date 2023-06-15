package OrderTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OrdersListTest {
    @Test
    @DisplayName("Получение списка заказов")
    @Description("Получаем список заказов без courierId")
    public void getOrdersList() {

        List<ArrayList> orders = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://qa-scooter.praktikum-services.ru/api/v1/orders")
                .then()
                .statusCode(200)
                .log().all()
                .extract().jsonPath().get("orders");
    }
}