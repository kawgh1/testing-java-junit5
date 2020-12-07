package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import guru.springframework.sfgpetclinic.services.map.PetMapService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * created by kw on 12/6/2020 @ 10:32 PM
 */
@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {

    // Using Mockito Spies

    // A Spy differentiates from a Mock because a Spy allows you to access the underlying object
    // It acts like a wrapper around a real Java Object

    @Mock
    VisitService visitService;

    @Spy
    PetMapService petServiceSpy;

    @Mock
    PetService petServiceMock;

    @InjectMocks
    VisitController visitController;


    @Test
    void loadPetsWithVisitSpy() {
        // given
        Map<String, Object> model = new HashMap<>();
        Pet pet12 = new Pet(12L);
        Pet pet3 = new Pet(3L);
        petServiceSpy.save(pet12);
        petServiceSpy.save(pet3);

        // Spy will call real method
        given(petServiceSpy.findById(anyLong())).willCallRealMethod(); //.willReturn(pet);

        //when
        Visit visit = visitController.loadPetWithVisit(12L, model);

        //then
        assertThat(visit).isNotNull();
        assertThat(visit.getPet()).isNotNull();
        assertThat(visit.getPet().getId()).isEqualTo(12L);
        verify(petServiceSpy,times(1)).findById(anyLong());


    }

    @Test
    void loadPetsWithVisitSpyWithStubbing() {
        // given
        Map<String, Object> model = new HashMap<>();
        Pet pet12 = new Pet(12L);
        Pet pet3 = new Pet(3L);
        petServiceSpy.save(pet12);
        petServiceSpy.save(pet3);

        // So here we're loading pet3 as the given but testing on pet12
        // overriding the real method with willReturn - we're telling it what to return
        given(petServiceSpy.findById(anyLong())).willReturn(pet3);

        //when
        Visit visit = visitController.loadPetWithVisit(12L, model);

        //then
        assertThat(visit).isNotNull();
        assertThat(visit.getPet()).isNotNull();
        assertThat(visit.getPet().getId()).isEqualTo(12L);
        verify(petServiceSpy,times(1)).findById(anyLong());


    }

    // Pure Mock Implementation
    @Test
    void loadPetsWithVisit() {
        // given
        Map<String, Object> model = new HashMap<>();
        Pet pet = new Pet(1L);
        given(petServiceMock.findById(anyLong())).willReturn(pet);

        //when
        Visit visit = visitController.loadPetWithVisit(1L, model);

        //then
        assertThat(visit).isNotNull();
        assertThat(visit.getPet()).isNotNull();
    }
}
