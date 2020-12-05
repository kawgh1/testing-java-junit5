package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * created by kw on 12/5/2020 @ 1:08 PM
 */
@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

//    mockito tries to inject the objects  marked with @Mock into the object marked with @InjectMocks
//
//    The one with @InjectMock is object you want to test.
//    @Mocks are (should be) dependencies  of the latter.
//    When the class under test (that one marked with @InjectMock) triggers a @mock  object you can drive his behaviour
    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void findByIdTest() {
        // create new speciality object - the object that our mock will return back
        Speciality speciality = new Speciality();

        // conditional when findById() method is called, then return an optional of specialty
        when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));

        // call the method
        Speciality foundSpeciality = service.findById(1L);

        // imported assertJ method, assert that we got the object back (that it is not null)
        assertThat(foundSpeciality).isNotNull();

        // verify that the method was actually called
        verify(specialtyRepository).findById(1L);

        // verify that the method was actually called on *ANY* Long value
        verify(specialtyRepository).findById(anyLong());
    }

    @Test
    void testDeleteByObject() {

        Speciality speciality = new Speciality();

        service.delete(speciality);

        // verify the delete() method was called by *ANY* object of the Speciality class
        verify(specialtyRepository).delete(any(Speciality.class));
    }

    @Test
    void deleteByIdOnce() {
        service.deleteById(1l);

        // verify mock interactions - invoke mock service 1 time only
        verify(specialtyRepository).deleteById(1l);

    }

    @Test
    void deleteByIdTwice() {

        service.deleteById(1l);
        service.deleteById(1l);

        // verify mock interactions - invoke mock service twice exactly
        verify(specialtyRepository, times(2)).deleteById(1l);

    }

    @Test
    void deleteByIdAtLeastOnce() {
        service.deleteById(1l);
        service.deleteById(1l);

        // verify mock interactions - invoke mock service at least 1 time
        verify(specialtyRepository, atLeastOnce()).deleteById(1l);

    }

    @Test
    void deleteByIdAtMostOnce() {
        service.deleteById(1l);
        service.deleteById(1l);
        service.deleteById(1l);
        service.deleteById(1l);

        // verify mock interactions - invoke mock service at least 1 time
        verify(specialtyRepository, atMost(5)).deleteById(1l);

    }

    @Test
    void deleteByIdNever() {
        service.deleteById(1l);
        service.deleteById(1l);

        // verify mock interactions - invoke mock service at least 1 time
        verify(specialtyRepository, atLeastOnce()).deleteById(1l);

        // verify mock interactions - deleteById() method is never called on an "id" of 5L
        verify(specialtyRepository, never()).deleteById(5L);

    }



    @Test
    void delete() {
        service.delete(new Speciality());
    }


}