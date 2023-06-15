package createCourierTests;

import clients.CourierClient;
import dataProvider.NoLoginCourierDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import pojoClasses.CreateCourier;
import pojoClasses.LoginCourier;

public class NoLoginCreateCourierTest {

    private Integer id;
    private CourierClient courierClient = new CourierClient();

    @Test
    @DisplayName("Создание курьера без логина")
    @Description("Курьер не может быть создан без указания одного из полей. Например, Login.")
    public void courierShouldNotBeCreatedTest() {


        //Создание курьера
        CreateCourier createCourier = NoLoginCourierDataProvider.getNoLoginCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(400)
                .body("message", Matchers.equalTo("Недостаточно данных для создания учетной записи"));

        //Логин
        LoginCourier loginCourier = LoginCourier.fromCreateCourierData(createCourier);
        id = CourierClient.login(loginCourier)
                .log().all()
                .statusCode(400)
                .body("message", Matchers.equalTo("Недостаточно данных для входа"))
                .extract().jsonPath().get("id");


    }

    //Удаление
    @After
    public void tearDown() {
        if (id == null) {
            System.out.println("Курьер не создан. Удалять нечего.");
        } else {courierClient.delete(id).log().all().statusCode(200);}
    }
}

