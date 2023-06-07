package loginCourierTests;

public class NoLoginCourierLoginTest {
    private Integer id;
    private clients.CourierClient courierClient = new clients.CourierClient();
    @org.junit.Test
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
