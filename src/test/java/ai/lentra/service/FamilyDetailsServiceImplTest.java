package ai.lentra.service;

import ai.lentra.dto.FamilyDetailsRequest;
import ai.lentra.modal.famil_info.FamilyDetail;
import ai.lentra.repository.familyDetails.FamilyDetailsRepository;
import ai.lentra.serviceImpl.familyDetails.FamilyDetailsServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
@Scope("ai.lentra.service.*")
public class FamilyDetailsServiceImplTest {
    @MockBean
    FamilyDetailsRepository familyDetailsRepository;
    @Autowired
    FamilyDetailsServiceImpl familyDetailsServiceImpl;
    FamilyDetailsRequest familyDetailsRequest = new FamilyDetailsRequest();
    FamilyDetail familyDetails = new FamilyDetail();

    @Test
    public void test_insertFamilyDetails() {
        FamilyDetail familyDetails = dummyFamilyDetails();
        FamilyDetailsRequest familyDetailsRequest = dummyFamilyDetailsRequest();
        FamilyDetail response = familyDetailsServiceImpl.insertFamilyDetails(familyDetailsRequest);
        when(familyDetails).thenReturn(response);
        assertNotNull(response);

    }

    public FamilyDetailsRequest dummyFamilyDetailsRequest() {
        /*familyDetailsRequest.setFamilyDetailsId(1);
        familyDetailsRequest.setNo_of_dependants(String.valueOf(2));
        familyDetailsRequest.setNo_of_minor(String.valueOf(2));
        familyDetailsRequest.setChild_educational_level("student");
        familyDetailsRequest.setSpouse_age(25);
        familyDetailsRequest.setFather_age(60);
        familyDetailsRequest.setMother_age(50);
        familyDetailsRequest.setSpouse_citizenship("indian");
        familyDetailsRequest.setEntity_confirmation_spouse(true);
        familyDetailsRequest.setSpouse_working(true);
        familyDetailsRequest.setSpouse_occupation("employee");
        familyDetailsRequest.setEntity_confirmation_father(true);
        familyDetailsRequest.setEntity_confirmation_mother(true);
        familyDetailsRequest.setSpouse_last_name("ringe");
        familyDetailsRequest.setSpouse_first_name("swami");
        familyDetailsRequest.setSpouse_mid_name("rajendra");
        familyDetailsRequest.setSpouse_suffix("mr");
        familyDetailsRequest.setSpouse_alias("golu");
        familyDetailsRequest.setSpouse_birth_date(new Date(22-10-2012));
        familyDetailsRequest.setSpouse_religion("hindu");
        familyDetailsRequest.setFathers_first_name("rajendra");

        familyDetailsRequest.setFathers_middle_name("prabhu");
        familyDetailsRequest.setFathers_last_name("ringe");
        familyDetailsRequest.setFather_religion("hindu");
        familyDetailsRequest.setMothers_first_name("maya");
        familyDetailsRequest.setMothers_middle_name("rajendra");
        familyDetailsRequest.setMothers_last_name("ringe");
        familyDetailsRequest.setMother_religion("maya");

         */
        return familyDetailsRequest;

    }

    public FamilyDetail dummyFamilyDetails() {
        FamilyDetailsRequest familyDetailsRequest = dummyFamilyDetailsRequest();
       /* familyDetails.setFamilyDetailsId(familyDetailsRequest.getFamilyDetailsId());
        familyDetails.setNo_of_dependants(familyDetailsRequest.getNo_of_dependants());
        familyDetails.setNo_of_minor(familyDetailsRequest.getNo_of_minor());
        familyDetails.setChild_educational_level(familyDetailsRequest.getChild_educational_level());
        familyDetails.setSpouse_age(familyDetailsRequest.getSpouse_age());
        familyDetails.setFather_age(familyDetailsRequest.getFather_age());
        familyDetails.setMother_age(familyDetailsRequest.getMother_age());
        familyDetails.setSpouse_citizenship(familyDetailsRequest.getSpouse_citizenship());
        familyDetails.setEntity_confirmation_spouse(familyDetailsRequest.isEntity_confirmation_spouse());
        familyDetails.setSpouse_working(familyDetailsRequest.isSpouse_working());
        familyDetails.setSpouse_occupation(familyDetailsRequest.getSpouse_occupation());
        familyDetails.setEntity_confirmation_father(familyDetailsRequest.isEntity_confirmation_father());
        familyDetails.setEntity_confirmation_mother(familyDetailsRequest.isEntity_confirmation_mother());
        familyDetails.setSpouse_last_name(familyDetailsRequest.getSpouse_last_name());
        familyDetails.setSpouse_first_name(familyDetailsRequest.getSpouse_last_name());
        familyDetails.setSpouse_mid_name(familyDetailsRequest.getSpouse_mid_name());
        familyDetails.setSpouse_suffix(familyDetailsRequest.getSpouse_suffix());
        familyDetails.setSpouse_alias(familyDetailsRequest.getSpouse_alias());
        familyDetails.setSpouse_birth_date(familyDetailsRequest.getSpouse_birth_date());
        familyDetails.setSpouse_religion(familyDetailsRequest.getSpouse_religion());
        familyDetails.setFathers_first_name(familyDetailsRequest.getFathers_first_name());
        familyDetails.setFathers_middle_name(familyDetailsRequest.getFathers_middle_name());
        familyDetails.setFathers_last_name(familyDetailsRequest.getFathers_last_name());
        familyDetails.setFather_religion(familyDetailsRequest.getFather_religion());
        familyDetails.setMothers_first_name(familyDetailsRequest.getMothers_first_name());
        familyDetails.setMothers_middle_name(familyDetailsRequest.getMothers_middle_name());
        familyDetails.setMothers_last_name(familyDetailsRequest.getMothers_last_name());
        familyDetails.setMother_religion(familyDetailsRequest.getMother_religion());
        familyDetailsRepository.save(familyDetails);

        */
        return familyDetails;

    }

    @Test
    public void test_familyDetailsGetById() {
        familyDetails = dummyFamilyDetails();
        Integer id = 1;
        Optional<FamilyDetail> response = familyDetailsServiceImpl.getFamilyDetailsById(1);
        when(familyDetailsRepository.getById(1)).thenReturn(familyDetails);
        Assertions.assertNotNull(familyDetails);
        Assertions.assertNotNull(response);


    }

    @Test
    public void test_findAll() {
        FamilyDetail familyDetails = dummyFamilyDetails();
        List<FamilyDetail> familyDetails1 = familyDetailsRepository.findAll();
        when(familyDetailsRepository.findAll()).thenReturn(familyDetails1);
        List<FamilyDetail> response = familyDetailsServiceImpl.findAll();
        assertNotNull(response);
    }
    @Test
    public void test_familyDetailsUpdate(){
        FamilyDetailsRequest familyDetailsRequest=dummyFamilyDetailsRequest();
        FamilyDetail familyDetails=dummyFamilyDetails();
        when(familyDetailsRepository.save(Mockito.any(FamilyDetail.class))).thenReturn(familyDetails);
        FamilyDetail response = familyDetailsServiceImpl.familyDetailsUpdate(familyDetailsRequest);
        assertNotNull(response);
    }
    FamilyDetail dummyfamilyDetails(){
        FamilyDetail familyDetails=new FamilyDetail();
        familyDetails.setFamilyDetailsId(1);
        familyDetails.setNo_of_dependants(String.valueOf(2));
        familyDetails.setNo_of_minor(String.valueOf(2));
        familyDetails.setChild_educational_level("student");
        familyDetails.setSpouse_age(25);
        familyDetails.setFather_age(60);
        familyDetails.setMother_age(50);
        familyDetails.setSpouse_citizenship("indian");
        familyDetails.setEntity_confirmation_spouse(true);
        familyDetails.setSpouse_working(true);
        familyDetails.setSpouse_occupation("employee");
        familyDetails.setEntity_confirmation_father(true);
        familyDetails.setEntity_confirmation_mother(true);
        familyDetails.setSpouse_last_name("ringe");
        familyDetails.setSpouse_first_name("swami");
        familyDetails.setSpouse_mid_name("rajendra");
        familyDetails.setSpouse_suffix("mr");
        familyDetails.setSpouse_alias("golu");
        familyDetails.setSpouse_birth_date(new Date(21-10-2013));
        familyDetails.setSpouse_religion("hindu");
        familyDetails.setFathers_first_name("rajendra");

        familyDetails.setFathers_middle_name("prabhu");
        familyDetails.setFathers_last_name("ringe");
        familyDetails.setFather_religion("hindu");
        familyDetails.setMothers_first_name("maya");
        familyDetails.setMothers_middle_name("rajendra");
        familyDetails.setMothers_last_name("ringe");
        familyDetails.setMother_religion("maya");
        return familyDetails;

    }

}
