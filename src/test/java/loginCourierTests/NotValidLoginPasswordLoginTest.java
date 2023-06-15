package loginCourierTests;

import clients.CourierClient;
import dataProvider.RandomCreateCourierDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import pojoClasses.CreateCourier;
import pojoClasses.LoginCourier;
import pojoClasses.NotValidLoginPassword;

public class NotValidLoginPasswordLoginTest {
    private Integer id;
    private CourierClient courierClient = new CourierClient();
    CreateCourier createCourier = RandomCreateCourierDataProvider.getRandomCourierData();
    @Test
    @DisplayName("Авторизация с несуществующей парой Login/Password")
    @Description("После нормального создания курьера проводим авторизацию с его логином и другим паролем.")
    public void courierNotValidLoginPasswordLoginTest(){


        //Создание курьера

        courierClient.create(createCourier)
                .log().all()
                .statusCode(201)
                .body("ok", Matchers.equalTo(true));

        //Логин
        NotValidLoginPassword notValidLoginPassword = NotValidLoginPassword.fromCreateCourierData(createCourier);
        id = CourierClient.loginNotValidLoginPassword(notValidLoginPassword)
                .log().all()
                .statusCode(404)
                .body("message", Matchers.equalTo("Учетная запись не найдена"))
                .extract().jsonPath().get("id");



    }
    @After
    public void tearDown() {
        LoginCourier loginCourier = LoginCourier.fromCreateCourierData(createCourier);
        id = CourierClient.login(loginCourier)
                .log().all()
                .statusCode(200)
                .extract().jsonPath().get("id");
        if (id != 0) {
            courierClient.delete(id).log().all().statusCode(200);
        }
    }



}

