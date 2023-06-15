package OrderTests;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;


@RunWith(Parameterized.class)
public class CreateOrderTest {
    private  String firstName;
    private  String lastName;
    private  String address;
    private  String metroStation;
    private  String phone;
    private  int rentTime;
    private  String deliveryDate;
    private  String comment;
    private  String[] color;



    public   CreateOrderTest(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color =  color;
    }
    @Parameters
        public static List<Object[]> orderData() {
         return Arrays.asList( new   Object[][] {
                    {"Vasia", "Vasiliev", "Павлова 7", "Молодежная", "+79261234567", 5, "2025-08-10", "No comments", new String[]{"BLACK"}},
                    {"Ivan", "Ivanov", "Азатяна 17", "Кунцевская", "+79581234567", 3, "2025-08-10", "Faster, harder, Scooter", null},
                    {"Ivan1", "Ivanov1", "Азатяна 171", "Кунцевская", "+79581234567", 3, "2025-08-10", "Faster, harder, Scooter", new String[]{"BLACK", "GREY"}},
            });


    }

        @Test
        @DisplayName("Создание заказа")
        @Description("Проверяем создание заказов с разными цветами : Черный, без указания, Черный и Серый")
        public void createOrder () {

         int track = given()
                    .contentType(ContentType.JSON)
                    .body(orderData())
                    .when()
                    .post("http://qa-scooter.praktikum-services.ru/api/v1/orders")
                    .then()
                    .statusCode(201)
                    .log().all()
                    .extract().jsonPath().get("track");




    }


}