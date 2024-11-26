package stepdef;

import helper.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class hooks extends Utility {
    @BeforeAll
    public static void setUp(){
    }

    @AfterAll
    public static void tearDown(){
    }

    @Before
    public static void beforeTest(){
        startDriver();
    }
    @After
    public static void afterTest(){
        quitDriver();
    }
}
