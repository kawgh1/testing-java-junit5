package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * created by kw on 12/3/2020 @ 11:55 PM
 */
@Tag("repeated")
public interface ModelRepeatedTests {

    // for non-repeated tests the RepetitionInfo parameter is not available, meaning it will fail on non-repeated tests
    // if there are a lot of repeated and non-repeated tests, best to split out into two classes of tests
    // ex. PersonRepeatedTest and PersonTest
    // would also need to make a ModelRepeatedTest Interface to implement from
    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName() + " - " +
                repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
    }
}
