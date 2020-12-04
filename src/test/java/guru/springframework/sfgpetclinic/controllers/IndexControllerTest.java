package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.condition.OS.*;

/**
 * created by kw on 12/3/2020 @ 6:16 PM
 */

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    // @DisplayName is not used a lot, but it can be useful if you want more descriptive test names
    // or you have many tests or one is failing and you want to find it easily
    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");
        assertEquals("index", controller.index(), () -> "Another expensive method - " +
                "make me only if you have to.");
    }

    @DisplayName("Test exception")
    @Test
    void oopsHandler() {
        // JUnit allows using lambdas in messages which would be useful if you were testing very complex/expensive
        // methods - this way, those methods are only run if it fails
//        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This is some " +
//                "message to build for this test.");

        // test to make sure that our controller.oopsHandler() throws the right exception
        assertThrows(ValueNotFoundException.class, () -> {
           controller.oopsHandler();
        });
    }

    @Disabled("Demo of timeout speed test")
    @Test
    void testTimeOut() {
        // speed test - if test takes longer than 100 millis to run, then it should fail

        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout speed test")
    @Test
    void testTimeOutPreempt() {

        // speed test - preemptively means, if Duration has already passed, don't even run the test, just fail it
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("I got here 2");
        });
    }


    @Test
    void testAssumptionTrue() {

        // you might use assumeTrue for environment variables or a test user in a database
        // certain things/variables you assume to be true that are required to be true to properly test the feature
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrue2() {

        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }


    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMacOS() {

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testMeOnLinux() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11() {

    }

//    For WIndwos we have to use
//
//    @EnabledIfEnvironmentVariable(named = "username", matches = "Vlad" )
//
//    And in CMD we have to write
//    echo %username%

    @Test
    @EnabledIfEnvironmentVariable(named="username", matches = "JJ")
//    @EnabledIfEnvironmentVariable(named="USER", matches = "JJ") -- MAC env
    void testIfUserJJ() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named="username", matches = "Fred")
    void testIfUserFred() {

    }




}