package loginCourierTests;

public class NotValidLoginPasswordLoginTest {
    private Integer id;
    private clients.CourierClient courierClient = new clients.CourierClient();
    pojoClasses.CreateCourier createCourier = dataProvider.RandomCreateCourierDataProvider.getRandomCourierData();
    @org.junit.Test
    public void courierNotValidLoginPasswordLoginTest(){


        //Создание курьера

        courierClient.create(createCourier)
                .log().all()
                .statusCode(201)
                .body("ok", org.hamcrest.Matchers.equalTo(true));

        //Логин
        pojoClasses.NotValidLoginPassword notValidLoginPassword = pojoClasses.NotValidLoginPassword.fromCreateCourierData(createCourier);
        id = clients.CourierClient.loginNotValidLoginPassword(notValidLoginPassword)
                .log().all()
                .statusCode(404)
                .body("message", org.hamcrest.Matchers.equalTo("Учетная запись не найдена"))
                .extract().jsonPath().get("id");



    }
    @org.junit.After
    public void tearDown() {
        pojoClasses.LoginCourier loginCourier = pojoClasses.LoginCourier.fromCreateCourierData(createCourier);
        id = clients.CourierClient.login(loginCourier)
                .log().all()
                .statusCode(200)
                .extract().jsonPath().get("id");
        if (id != 0) {
            courierClient.delete(id).log().all().statusCode(200);
        }
    }



}

