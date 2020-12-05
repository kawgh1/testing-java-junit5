package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * created by kw on 12/5/2020 @ 1:23 PM
 */
@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

    @Mock
    VetRepository vetRepository;

//    mockito tries to inject the objects  marked with @Mock into the object marked with @InjectMocks
//
//    The one with @InjectMock is object you want to test.
//    @Mocks are (should be) dependencies  of the latter.
//    When the class under test (that one marked with @InjectMock) triggers a @mock  object you can drive his behaviour
    @InjectMocks
    VetSDJpaService service;

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(vetRepository).deleteById(1L);
    }
}