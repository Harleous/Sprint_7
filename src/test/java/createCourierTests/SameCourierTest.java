package createCourierTests;

public class SameCourierTest {
    private Integer id;
    private clients.CourierClient courierClient = new clients.CourierClient();
    @org.junit.Test
    @io.qameta.allure.junit4.DisplayName("Создание курьера с повторным логином")
    @io.qameta.allure.Description("Курьер с уже существующим Login не должен быть создан")
    public void courierShouldNotBeCreatedTest(){


        //Создание курьера
        pojoClasses.CreateCourier createCourier = dataProvider.SameCourierDataProvider.getFixedCourierData();
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
        //Создание курьера с повторными данными
        pojoClasses.CreateCourier createSameCourier = dataProvider.SameCourierDataProvider.getFixedCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(409)
                .body("message", org.hamcrest.Matchers.equalTo("Этот логин уже используется. Попробуйте другой."));




    }
    //Удаление
    @org.junit.After
    public void tearDown() {
        if (id != 0) {
            courierClient.delete(id).log().all().statusCode(200);
        }
    }
}

