package com.learning.projects.jobsearchapp;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@ActiveProfiles("jordan-test")
public class LoginIntegrationTests {
    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:16-alpine");

    @LocalServerPort
    private Integer port;
    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        postgreSQLContainer.start();


    }
    @Test
    void loginSuccessfulTest(){
        String requestBody = "{\n" +
                "  \"username\": \"john_doe\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";

        String url = "/api/v1/auth/login";
        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .statusCode(200)
                .body("jwtToken",notNullValue());

    }
    @Test
    void loginUnsuccessfulTest(){
        String requestBody = "{\n" +
                "  \"username\": \"john_doe\",\n" +
                "  \"password\": \"1234562\"\n" +
                "}";

        String url = "/api/v1/auth/login";
        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .statusCode(403);

    }
}
