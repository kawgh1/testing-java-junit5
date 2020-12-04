package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by kw on 12/3/2020 @ 7:55 PM
 */
class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231321321");

        assertAll("Properties Test",
    () -> assertAll("Person Properties",
            () -> assertEquals("Joe", owner.getFirstName(), "First name didnt match"),
                        () -> assertEquals("Buck", owner.getLastName())),

                () -> assertAll("Owner Properties",
            () -> assertEquals("Key West", owner.getCity(), "City didnt match"),
                        () -> assertEquals("1231321321", owner.getTelephone())

                ));
    }

}