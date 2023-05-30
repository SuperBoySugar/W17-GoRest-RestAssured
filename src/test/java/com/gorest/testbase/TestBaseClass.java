package com.gorest.testbase;

import com.gorest.utiils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBaseClass extends TestUtils {



    @BeforeClass
    public static void initialize() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "/public/v2";


    }

}
