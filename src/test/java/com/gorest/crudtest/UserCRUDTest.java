package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBaseClass;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBaseClass {

    //1. verifyUserCreatedSuccessfully()
    @Test
    public void verifyUserCreatedSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Henry");
        userPojo.setEmail(getRandomValue() + "hen13@example.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer 2d471ea93b4e52c80b57e1e8227dea702bb54173c4c781467e9f2b6f9f369a36")
                        .body(userPojo)
                        .when()
                        .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    //2. verifyUserUpdateSuccessfully()
    @Test
    public void verifyUserUpdateSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Henry Smith");
        userPojo.setEmail(getRandomValue() + "hens@example.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer 2d471ea93b4e52c80b57e1e8227dea702bb54173c4c781467e9f2b6f9f369a36")
                        .body(userPojo)
                        .when()
                        .put("/users/2318722");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    //3. VerifyUserDeleteSuccessfully()
    @Test
    public void verifyUserDeleteSuccessfully(){

        UserPojo userPojo = new UserPojo();
        userPojo.setName("Henry Smith");
        userPojo.setEmail(getRandomValue() + "hens@example.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer 2d471ea93b4e52c80b57e1e8227dea702bb54173c4c781467e9f2b6f9f369a36")
                        .body(userPojo)
                        .when()
                        .delete("/users/2318722");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}




