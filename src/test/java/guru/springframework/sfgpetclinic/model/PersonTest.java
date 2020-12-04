package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by kw on 12/3/2020 @ 6:26 PM
 */
class PersonTest {

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