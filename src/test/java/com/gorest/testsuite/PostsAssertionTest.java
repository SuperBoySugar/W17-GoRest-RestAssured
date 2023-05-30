package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostsAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/posts")
                .then().statusCode(200);
    }
    //1. Verify the if the total record is 25
    @Test
    public void test001(){
        response = given()
                .when()
                .get("/users?page=1&per_page=25")
                .then().statusCode(200);
        List<Integer> total = response.extract().path("id");
        Assert.assertEquals(total.size(), 25);
    }
    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void test002() {
        response.body("[2].title", equalTo("Conqueror tamisium alo maiores paens consequatur deprecator."));
    }
    //3. Check the single user_id in the Array list (5522)
    @Test
    public void test003() {
        response.body("user_id", hasItem( 2250476));
    }
    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004() {
        response = given()
                .when()
                .get("/posts?page=1&per_page=25")
                .then().statusCode(200);
        response.body("id", hasItems(38978, 38980, 38975));
    }
    //5.
    @Test
    public void test005() {
        response.body("[1].body", equalTo("Fugiat textus et. Dolores suffragium itaque. Thorax substantia constans. Defessus turba verto. Tantillus suasoria cicuta. Adipisci vester defetiscor. Non unde dolorum. Aiunt tristis repellendus. Itaque cedo cogo. Atavus terror antea. Degero antepono cicuta. Adhaero vae animadverto. Auxilium virgo templum."));
    }

}
