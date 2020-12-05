package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

/**
 * created by kw on 12/5/2020 @ 1:05 PM
 */
@ExtendWith(MockitoExtension.class) // Junit 5 extension for mockito which calls initMocks() to initialize mock objects
public class JUnitExtensionTest {
    // good practice to list Mocks first, easier to tell what is Mock and what is not
    @Mock
    Map<String, Object> mapMock;


    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");

    }
}
