package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.LenientStubber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * created by kw on 12/6/2020 @ 9:02 PM
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    // introduce private testing strings to make tests more robust
    // this is especially helpful when many developers are using the same tests who may not have written the initial code
    // keeps things orderly, separated and less likely to result in duplication of work or re-work

    // ideally by the point of testing, these URL paths won't change and shouldn't change
    private static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private static final String REDIRECT_OWNERS_5 = "redirect:/owners/5";


    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @InjectMocks
    OwnerController controller;

    //fauxSpring
    @Mock
    BindingResult bindingResult;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;


    // using Mockito Answers to prepare objects for testing
    // helpful to create cleaner, less cluttered, more readable tests
    @BeforeEach
    void setUp() {
        given(ownerService.findAllByLastNameLike(stringArgumentCaptor.capture()))
                .willAnswer(invocation -> {
                    List<Owner> owners = new ArrayList<>();

                    String name = invocation.getArgument(0);

                    if(name.equals("%Buck%")) {
                        owners.add(new Owner(1l, "Joe", "Buck"));
                        return owners;
                    } else if (name.equals("%DontFindMe%")) {
                        return owners;
                    } else if (name.equals("%FindMe%")) {
                        owners.add(new Owner(1l, "Joe", "Buck"));
                        owners.add(new Owner(2l, "Joe2", "Buck2"));
                        return owners;
                    }

                    throw new RuntimeException("Invalid Argument");
                });
    }



    /// Mockito Argument Capture
    // in the OwnerController class, processFindForm() method, it does a ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
    // using % signs for wildcard searches

    // here we want to test that those wildcards are actually being passed in correctly
//    @Test
//    void processFindFormWildcardString() {
//
//        //given
//
//        Owner owner = new Owner(1l, "Joe", "Buck");
//        // handled with setUp() method
//        List<Owner> ownerList = new ArrayList<>();
//        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//        given(ownerService.findAllByLastNameLike(captor.capture())).willReturn(ownerList);
//
//        //when
//        // "binding to model"
//        String viewName = controller.processFindForm(owner, bindingResult, null);
//
//        //then
//        assertThat("%Buck%").isEqualToIgnoringCase(captor.getValue());
//
//    }

    // same test with Mockito String Annotation at top -> @Captor = stringArgumentCaptor
    @Test
    void processFindFormWildcardStringAnnotation() {

        //given
        Owner owner = new Owner(1l, "Joe", "Buck");
        // handled with setUp() method
//        List<Owner> ownerList = new ArrayList<>();
//        given(ownerService.findAllByLastNameLike(stringArgumentCaptor.capture())).willReturn(ownerList);

        //when
        // "binding to model"
        String viewName = controller.processFindForm(owner, bindingResult, null);

        //then
        assertThat("%Buck%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("redirect:/owners/1").isEqualToIgnoringCase(viewName);
        // since we're passing a null to model above, this test should have no interaction with our mock model object
        verifyZeroInteractions(model);

    }

    // test successful search (owner found)
    @Test
    void processFindFormWildcardFound() {

        //given
        Owner owner = new Owner(1l, "Joe", "FindMe");
        // Mockito verify Order of Interactions - that ownerService is called before the model is called
        InOrder inOrder = Mockito.inOrder(ownerService, model);

        //when
        // "binding to (Mock) model"
        String viewName = controller.processFindForm(owner, bindingResult, model);

        //then
        assertThat("%FindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("owners/ownersList").isEqualToIgnoringCase(viewName);

        // inOrder assertions
        inOrder.verify(ownerService).findAllByLastNameLike(anyString());
        // verify model called only once
        inOrder.verify(model, times(1)).addAttribute(anyString(), anyList());
        // and no more
        verifyNoMoreInteractions(model);

    }

    // test unsuccessful search (owner NOT found)
    @Test
    void processFindFormWildcardNotFound() {

        //given
        Owner owner = new Owner(1l, "Joe", "DontFindMe");

        //when
        // "binding to model"
        String viewName = controller.processFindForm(owner, bindingResult, null);

        verifyNoMoreInteractions(ownerService);

        //then
        assertThat("%DontFindMe%").isEqualToIgnoringCase(stringArgumentCaptor.getValue());
        assertThat("owners/findOwners").isEqualToIgnoringCase(viewName);

        // since we're passing a null to model above, this test should have no interaction with our mock model object
        verifyZeroInteractions(model);

    }


    //



    @Test
    @MockitoSettings(strictness = Strictness.LENIENT) // lenient to ignore BeforeEach setup
    void processCreationFormHasErrors() {

        //given
        Owner owner = new Owner(1l, "Jim", "Bob");
        given(bindingResult.hasErrors()).willReturn(true);
        // since it has errors, we don't want to mimic saving it as below

        //when
        // "binding to model"
        String viewName = controller.processCreationForm(owner, bindingResult);

        //then
//        assertThat(viewName).isEqualToIgnoringCase("owners/createOrUpdateOwnerForm");

        // IntelliJ   left click -> Refactor -> Extract -> Constant or Introduce Constant...
        assertThat(viewName).isEqualToIgnoringCase(OWNERS_CREATE_OR_UPDATE_OWNER_FORM);


    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT) // lenient to ignore BeforeEach setup
    void processCreationFormNoErrors() {

        //given - id=5
        Owner owner = new Owner(5l, "Jim", "Bob");
        given(bindingResult.hasErrors()).willReturn(false);
        given(ownerService.save(any())).willReturn(owner); // no errors = save owner

        //when
        // "binding to model"
        String viewName = controller.processCreationForm(owner, bindingResult);

        //then
//        assertThat(viewName).isEqualToIgnoringCase("redirect:/owners/5");

        // IntelliJ   left click -> Refactor -> Extract -> Constant or Introduce Constant...
        assertThat(viewName).isEqualToIgnoringCase(REDIRECT_OWNERS_5);

    }


}