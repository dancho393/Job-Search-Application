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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@ActiveProfiles("jordan-test")
class RegistrationIntegrationTests {

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
    void shouldRegisterCompany(){
        String registerRequest = "{\n" +
                "  \"username\": \"KBClogin\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"email\":\"kbc@abv.bg\",\n" +
                "  \"name\": \"KBC Group\",\n" +
                "  \"address\": \"123 Main St, Cityville\",\n" +
                "  \"phoneNumber\": \"+1234567890\",\n" +
                "  \"city\": \"Cityville\",\n" +
                "  \"employeeCount\":\"1500\"\n" +
                "}";

        String url = "/api/v1/auth/registercompany";

        RestAssured.given()
                .contentType("application/json")
                .body(registerRequest)
                .when()
                .post(url)
                .then()
                .statusCode(201)
                .body("id",notNullValue())
                .body("username",equalTo("KBClogin"))
                .body("name",equalTo("KBC Group"))
                .body("address",equalTo("123 Main St, Cityville"))
                .body("phoneNumber",equalTo("+1234567890"))
                .body("city",equalTo("Cityville"))
                .body("employeeCount",equalTo(1500))
                .body("email",equalTo("kbc@abv.bg"))
                .body("rating",equalTo(0.0F))
                .body("message",equalTo("Company registered successfully"));
    }
    @Test
    void shouldRegisterCompanyGetExceptionForExistingUsername(){
        String registerRequest = "{\n" +
                "  \"username\": \"john_doe\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"email\":\"john.doe@example.com\",\n" +
                "  \"name\": \"John doe\",\n" +
                "  \"address\": \"123 Main St, Cityville\",\n" +
                "  \"phoneNumber\": \"+1234567890\",\n" +
                "  \"city\": \"Cityville\",\n" +
                "  \"employeeCount\":\"1500\"\n" +
                "}";

        String url = "/api/v1/auth/registercompany";
        //doesnt matter if it company or user repetitive usernames
        // should not enter database
        RestAssured.given()
                .contentType("application/json")
                .body(registerRequest)
                .when()
                .post(url)
                .then()
                .statusCode(409);
    }
    @Test
    void shouldRegisterUserGetExceptionForExistingEmail(){
        String registerRequest = "{\n" +
                "  \"username\": \"jane_doe\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"name\": \"Jane Doe\",\n" +
                "  \"address\": \"123 Main St, Cityville\",\n" +
                "  \"phoneNumber\": \"+1234567890\",\n" +
                "  \"city\": \"Cityville\"\n" +
                "}";

        String url = "/api/v1/auth/registeruser";

        RestAssured.given()
                .contentType("application/json")
                .body(registerRequest)
                .when()
                .post(url)
                .then()
                .statusCode(409);
    }


}
