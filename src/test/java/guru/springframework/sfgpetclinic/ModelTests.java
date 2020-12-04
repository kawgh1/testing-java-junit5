package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * created by kw on 12/3/2020 @ 11:37 PM
 */
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutputer(TestInfo testInfo){
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}