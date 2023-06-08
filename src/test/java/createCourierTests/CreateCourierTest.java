package createCourierTests;

import static io.restassured.RestAssured.given;

public class CreateCourierTest {
private Integer id;
   private clients.CourierClient courierClient = new clients.CourierClient();
    @org.junit.Test
    @io.qameta.allure.junit4.DisplayName("Cоздание курьера")
    @io.qameta.allure.Description("Нормальное создание курьера с заполнением всех полей")
    public void courierShouldBeCreatedTest(){


        //Создание курьера
        pojoClasses.CreateCourier createCourier = dataProvider.RandomCreateCourierDataProvider.getRandomCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(201)
                .body("ok", org.hamcrest.Matchers.equalTo(true));

        //Логин
        pojoClasses.LoginCourier loginCourier = pojoClasses.LoginCourier.fromCreateCourierData(createCourier);
         id = clients.CourierClient.login(loginCourier)
                 .log().all()
                .statusCode(200)
                .extract().jsonPath().get("id");



    }
    //Удаление
    @org.junit.After
    public void tearDown() {
        if (id != 0) {
            courierClient.delete(id).log().all().statusCode(200);
        }
    }
}
