package loginCourierTests;

public class NoLoginCourierLoginTest {
    private Integer id;
    private clients.CourierClient courierClient = new clients.CourierClient();
    @org.junit.Test
    @io.qameta.allure.junit4.DisplayName("Авторизация курьера без Login")
    @io.qameta.allure.Description("Сначала нормально создаем курьера. Затем пытаемся авторизоваться без Login")
    public void courierShouldNotLoginTest(){


        //Создание курьера
        pojoClasses.CreateCourier createCourier = dataProvider.RandomCreateCourierDataProvider.getRandomCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(201)
                .body("ok", org.hamcrest.Matchers.equalTo(true));

        //Логин
        pojoClasses.NoLoginCourierLogin noLoginCourierLogin =  pojoClasses.NoLoginCourierLogin.fromCreateCourierData(createCourier);
        id = clients.CourierClient.loginNologin(noLoginCourierLogin)
                .log().all()
                .statusCode(400)
                .body("message", org.hamcrest.Matchers.equalTo("Недостаточно данных для входа"))
                .extract().jsonPath().get("id");



    }


}
