package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

/**
 * created by kw on 12/5/2020 @ 1:02 PM
 */
public class AnnotationMockTest {

    // good practice to list Mocks first, easier to tell what is Mock and what is not
    @Mock
    Map<String, Object> mapMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");
    }


}
