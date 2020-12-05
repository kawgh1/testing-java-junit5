package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * created by kw on 12/3/2020 @ 9:18 PM
 */
@Disabled("Disabled until add Mockito")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {

        service = new OwnerSDJpaService(null, null, null);
    }

    @Disabled("Disabled until add Mockito")
    @Test
    void findByLastName() {
//         Owner foundOwner = service.findByLastName("Buck");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}
