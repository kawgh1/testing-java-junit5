package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * created by kw on 12/5/2020 @ 1:39 PM
 */
@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {


    @Mock
    VisitRepository visitRepository;

    //    mockito tries to inject the objects  marked with @Mock into the object marked with @InjectMocks
//
//    The one with @InjectMock is object you want to test.
//    @Mocks are (should be) dependencies  of the latter.
//    When the class under test (that one marked with @InjectMock) triggers a @mock  object you can drive his behaviour
    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAllTest() {
        Set<Visit> visits = new HashSet<>();

        Visit visit1 = new Visit();
        Visit visit2 = new Visit();

        visits.add(visit1);
        visits.add(visit2);

        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();

        verify(visitRepository).findAll();

        assertThat(foundVisits).hasSize(2);


    }

    @Test
    void findById() {
        Visit visit = new Visit();

        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1L);

        verify(visitRepository).findById(anyLong());

        assertThat(foundVisit).isNotNull();
    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(new Visit());

        verify(visitRepository).save(any(Visit.class));

        assertThat(savedVisit).isNotNull();
    }

    @Test
    void delete() {
        Visit visit = new Visit();

        service.delete(visit);

        verify(visitRepository).delete(any(Visit.class));

    }

    @Test
    void deleteById() {

        service.deleteById(1L);

        verify(visitRepository).deleteById(anyLong());
    }
}