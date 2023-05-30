package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test001() {
        List<?> listOfIds = response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The All Ids : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");


    }

    //2. Extract the all Names
    @Test
    public void test002() {
        List<String> totalNames = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The All Names : " + totalNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th object
    @Test
    public void test003() {
        String name = response.extract().path("[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of 5 Object : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004() {
        List<String> allNames = response.extract().path("findAll{it.status == 'inactive'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Names of all object whose status = inactive : " + allNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005() {
        List<String> allNames = response.extract().path("findAll{it.status == 'active'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Names of all object whose status = active : " + allNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //6.Print the names of the object whose gender = female
    @Test
    public void test006() {
        List<String> allFemale = response.extract().path("findAll{it.gender == 'female'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Names of  object whose gender = female : " + allFemale);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007(){
        List<String> allEmails = response.extract().path("findAll{it.status == 'inactive'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Emails of the object where status = inactive : " + allEmails);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. Get the ids of the object where gender = male
    @Test
    public void test008(){
        List<String> allIds = response.extract().path("findAll{it.gender == 'male'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Ids of the object where gender = male : " + allIds);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the status
    @Test
    public void test009(){
        List<String> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all Status is : " + status);
        System.out.println("------------------End of Test---------------------------");
    }
    //10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test0010(){
        String email = response.extract().path("find{it.name == 'Daevika Kaur'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The email of object is : " + email);
        System.out.println("------------------End of Test---------------------------");
    }
    //11. Get gender of id = 5471
    @Test
    public void test0011(){
        String gender = response.extract().path("[3].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The gender of id is  : " + gender);
        System.out.println("------------------End of Test---------------------------");
    }
}