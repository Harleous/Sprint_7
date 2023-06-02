
    import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

    public class RestAssuredGetAllureTest {

        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDBjZTBlNDU0ZTE0NjAwM2QyZDgxYWMiLCJpYXQiOjE2ODQ5NTYyNTcsImV4cCI6MTY4NTU2MTA1N30.s_0uzEXleriuI5nydEWAnO6cW03AIHcHvqsy9ac9f4c";

        @org.junit.Before
        public void setUp() {
            io.restassured.RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
        }

        @org.junit.Test
        public void getMyInfoStatusCode() {
            given()
                    .auth().oauth2(bearerToken)
                    .get("/api/users/me")
                    .then().statusCode(200);
        }

        @org.junit.Test
        public void checkUserName() {
            given()
                    .auth().oauth2(bearerToken)
                    .get("/api/users/me")
                    .then().assertThat().body("data.name",equalTo("Karion"));
        }

        @org.junit.Test
        public void checkUserNameAndPrintResponseBody() {

            io.restassured.response.Response response =given().auth().oauth2(bearerToken).get("/api/users/me");
            // отправили запрос и сохранили ответ в переменную response - экземпляр класса Response

            response.then().assertThat().body("data.name",equalTo("Karion"));
            // проверили, что в теле ответа ключу name соответствует нужное имя пользователя

            System.out.println(response.body().asString()); // вывели тело ответа на экран

        }

    }

