package com.learning.projects.jobsearchapp;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@ActiveProfiles("jordan-test")
public class JobPosterTests {
    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:16-alpine");


    @LocalServerPort
    private Integer port;

    private String token;
    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        String loginRequest = "{\n" +
                "  \"username\": \"KBC\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(loginRequest)
                .when()
                .post("/api/v1/auth/login");

        token = response.jsonPath().getString("jwtToken");
    }
    static {
        postgreSQLContainer.start();
    }

    @Test
    void createJobPosterSuccessfulTest(){

        String requestBody = "{\n" +
                "    \"title\": \"Java Backend Developer:5\",\n" +
                "    \"description\": \"Random\",\n" +
                "    \"city\": \"Leuven\",\n" +
                "    \"validTill\": \"2024-12-31\",\n" +
                "    \"techStackIds\": [\n" +
                "        \"6eaf1b14-7f1d-468f-b236-1b246d7d7f35\",\n" +
                "        \"32b63b1d-5795-4cc6-9806-91a72f1cdbff\",\n" +
                "        \"779e674b-90d4-4a5a-bdd4-c8a1c036eb92\",\n" +
                "        \"ebc07359-8b85-4fc7-9fa4-173f1dfdcb9c\"\n" +
                "    ]\n" +
                "}";

        String url = "/api/v1/jobposter";
        RestAssured.given()
                .contentType("application/json")
                .header("Authorization","Bearer "+ token)
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .statusCode(201)
                .body("id",notNullValue())
                .body("title",equalTo("Java Backend Developer:5"))
                .body("description",equalTo("Random"))
                .body("city",equalTo("Leuven"))
                .body("techStacks",notNullValue())
                .body("validTill",equalTo("2024-12-31"))
                .body("companyName",equalTo("KBC GROUP"));

    }


}