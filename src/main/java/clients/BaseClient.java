package clients;

public class BaseClient {
    protected static io.restassured.specification.RequestSpecification getSpec(){
        return new io.restassured.builder.RequestSpecBuilder()
                .log(io.restassured.filter.log.LogDetail.ALL)
                .setContentType(io.restassured.http.ContentType.JSON)
                .setBaseUri("http://qa-scooter.praktikum-services.ru")
                .build();
    }
}
