package createCourierTests;

import clients.CourierClient;
import dataProvider.SameCourierDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import pojoClasses.CreateCourier;
import pojoClasses.LoginCourier;

public class SameCourierTest {
    private Integer id;
    private CourierClient courierClient = new CourierClient();
    @Test
    @DisplayName("Создание курьера с повторным логином")
    @Description("Курьер с уже существующим Login не должен быть создан")
    public void courierShouldNotBeCreatedTest(){


        //Создание курьера
        CreateCourier createCourier = SameCourierDataProvider.getFixedCourierData();
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
        //Создание курьера с повторными данными
        CreateCourier createSameCourier = SameCourierDataProvider.getFixedCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(409)
                .body("message", Matchers.equalTo("Этот логин уже используется. Попробуйте другой."));




    }
    //Удаление
    @After
    public void tearDown() {
        if (id != 0) {
            courierClient.delete(id).log().all().statusCode(200);
        }
    }
}

