import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class JsonTest {
    @org.junit.Before
    public void setUp() {
        io.restassured.RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }
    @org.junit.Test
    public void createNewPlaceAndCheckResponse(){
        java.io.File json = new java.io.File("src/test/resources/newCard.json");
        io.restassured.response.Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDBjZTBlNDU0ZTE0NjAwM2QyZDgxYWMiLCJpYXQiOjE2ODQ5NTYyNTcsImV4cCI6MTY4NTU2MTA1N30.s_0uzEXleriuI5nydEWAnO6cW03AIHcHvqsy9ac9f4c")
                        .and()
                        .body(json)
                        .when()
                        .post("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
        System.out.println(response.asString());
    }
}

