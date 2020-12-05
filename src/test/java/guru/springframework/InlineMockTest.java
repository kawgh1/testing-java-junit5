package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by kw on 12/5/2020 @ 12:49 PM
 */
public class InlineMockTest {

    @Test
    void testInlineMock() {
        // create a mock of a Java Map object
        Map mapMock = mock(Map.class);

        assertEquals(mapMock.size(), 0);
    }
}
