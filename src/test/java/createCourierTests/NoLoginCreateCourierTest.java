package createCourierTests;

public class NoLoginCreateCourierTest {

    private Integer id;
    private clients.CourierClient courierClient = new clients.CourierClient();

    @org.junit.Test
    public void courierShouldNotBeCreatedTest() {


        //Создание курьера
        pojoClasses.CreateCourier createCourier = dataProvider.NoLoginCourierDataProvider.getNoLoginCourierData();
        courierClient.create(createCourier)
                .log().all()
                .statusCode(400)
                .body("message", org.hamcrest.Matchers.equalTo("Недостаточно данных для создания учетной записи"));

        //Логин
        pojoClasses.LoginCourier loginCourier = pojoClasses.LoginCourier.fromCreateCourierData(createCourier);
        id = clients.CourierClient.login(loginCourier)
                .log().all()
                .statusCode(400)
                .body("message", org.hamcrest.Matchers.equalTo("Недостаточно данных для входа"))
                .extract().jsonPath().get("id");


    }

    //Удаление
    @org.junit.After
    public void tearDown() {
        if (id == null) {
            System.out.println("Курьер не создан. Удалять нечего.");
        } else {courierClient.delete(id).log().all().statusCode(200);}
    }
}

