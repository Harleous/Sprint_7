package createCourierTests;

import clients.CourierClient;
import dataProvider.RandomCreateCourierDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import pojoClasses.CreateCourier;
import pojoClasses.LoginCourier;

public class CreateCourierTest {
private Integer id;
   private CourierClient courierClient = new CourierClient();
    @Test
    @DisplayName("Cоздание курьера")
    @Description("Нормальное создание курьера с заполнением всех полей")
    public void courierShouldBeCreatedTest(){


        //Создание курьера
        CreateCourier createCourier = RandomCreateCourierDataProvider.getRandomCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(201)
                .body("ok", Matchers.equalTo(true));

        //Логин
        LoginCourier loginCourier = LoginCourier.fromCreateCourierData(createCourier);
         id = CourierClient.login(loginCourier)
                 .log().all()
                .statusCode(200)
                .extract().jsonPath().get("id");



    }
    //Удаление
    @After
    public void tearDown() {
        if (id != 0) {
            courierClient.delete(id).log().all().statusCode(200);
        }
    }
}
