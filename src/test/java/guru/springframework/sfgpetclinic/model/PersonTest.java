package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by kw on 12/3/2020 @ 6:26 PM
 */
class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {

        // given
        Person person = new Person(1l,"Joe", "Buck");

        // then
        assertAll("Test Properties Set",
                () -> assertEquals( "Joe", person.getFirstName()),
                            () -> assertEquals("Buck", person.getLastName()));
    }

    @Test
    void groupedAssertionsMsgs() {

        // given
        Person person = new Person(1l,"Joe", "Buck");

        // then
        assertAll("Test Properties Set",
                () -> assertEquals("Joe", person.getFirstName(), "First name failed"),
                () -> assertEquals( "Buck", person.getLastName(),"Last name failed"));
    }



}