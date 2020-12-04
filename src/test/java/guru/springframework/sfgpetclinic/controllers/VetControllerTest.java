package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * created by kw on 12/3/2020 @ 9:59 PM
 */
class VetControllerTest implements ControllerTests {

    // Task list

    // Create new test for Vet Controller
    // Test List Vets method
    // Verify return value for view name
    // User VetMapService - add two or more vets
    // Create Model Implementation
    // Verify value List value is added to Model object

    VetController vetController;

    VetService vetService;

    SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1l, "James", "Donovan", null);
        Vet vet2 = new Vet(2l, "Roger", "Staubach", null);
        Vet vet3 = new Vet(3l, "Rebecca", "Stamos", null);

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);
    }

    @Test
    void listVets() {

        Model model = new ModelMapImpl();



        String view = vetController.listVets(model);

        // AssertJ test method (not JUnit)
        assertThat("vets/index").isEqualTo(view);


        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        // assert that the map has 3 vets
        assertThat(modelAttribute.size()).isEqualTo(3);

    }
}