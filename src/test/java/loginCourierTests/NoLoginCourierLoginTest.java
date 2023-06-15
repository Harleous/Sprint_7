package loginCourierTests;

import clients.CourierClient;
import dataProvider.RandomCreateCourierDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import pojoClasses.CreateCourier;
import pojoClasses.NoLoginCourierLogin;

public class NoLoginCourierLoginTest {
    private Integer id;
    private CourierClient courierClient = new CourierClient();
    @Test
    @DisplayName("Авторизация курьера без Login")
    @Description("Сначала нормально создаем курьера. Затем пытаемся авторизоваться без Login")
    public void courierShouldNotLoginTest(){


        //Создание курьера
        CreateCourier createCourier = RandomCreateCourierDataProvider.getRandomCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(201)
                .body("ok", Matchers.equalTo(true));

        //Логин
        NoLoginCourierLogin noLoginCourierLogin =  NoLoginCourierLogin.fromCreateCourierData(createCourier);
        id = CourierClient.loginNologin(noLoginCourierLogin)
                .log().all()
                .statusCode(400)
                .body("message", Matchers.equalTo("Недостаточно данных для входа"))
                .extract().jsonPath().get("id");



    }


}
