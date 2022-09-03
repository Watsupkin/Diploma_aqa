package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class API {

    static String appUrl = System.getProperty("sut.url");
    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(appUrl)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String PaymentPageForm(Data.CardData cardData) {
    return given()
            .spec(requestSpecification)
            .body(cardData)
            .when()
            .post("/api/v1/pay")
            .then()
            .statusCode(200)
            .extract().response().asString();
    }

    public static String CreditRequestPageForm(Data.CardData cardData) {
        return given()
                .spec(requestSpecification)
                .body(cardData)
                .when()
                .post("/api/v1/credit")
                .then()
                .statusCode(200)
                .extract().response().asString();
    }
}
