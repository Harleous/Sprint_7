import static io.restassured.RestAssured.given;

public class CourierTest {

    @org.junit.Test
    public void courierShouldBeCreatedTest(){
        pojoClasses.Courier courier = new pojoClasses.Courier();
        courier.setLogin("Vazgen");
        courier.setPassword("12345");
        courier.setFirstName("Antuan");
        //Создание курьера
       given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(courier)
                .when()
                .post("http://qa-scooter.praktikum-services.ru/api/v1/courier")
                .then()
                .statusCode(201)
                .body("ok", org.hamcrest.Matchers.equalTo(true));

        //Логин
        int id =  given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body("{\n" +
                        "    \"login\": \"derek\",\n" +
                        "    \"password\": \"787878\",\n" +
                        "}\n")
                .when()
                .post("http://qa-scooter.praktikum-services.ru/api/v1/courier/login")
                .then()
                .statusCode(200)
                .extract().jsonPath().get("id");
        //Удаление
        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .when()
                .delete("http://qa-scooter.praktikum-services.ru/api/v1/courier/{id}", id)
                .then().statusCode(200);
    }
}
