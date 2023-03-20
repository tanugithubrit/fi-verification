package ai.lentra;

import ai.lentra.controller.FamilyDetailsController;
import ai.lentra.dto.FamilyDetailsRequest;
import ai.lentra.modal.FamilyDetails;
import ai.lentra.service.FamilyDetailsService;
import ai.lentra.service.FamilyDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FamilyDetailsControllerTest {
    @MockBean
    FamilyDetailsServiceImpl familyDetailsServiceImpl;
    @Autowired
    FamilyDetailsService familyDetailsService;
    @Autowired
    FamilyDetailsController familyDetailsController;
    FamilyDetailsRequest familyDetailsRequest = new FamilyDetailsRequest();
    FamilyDetails familyDetails = new FamilyDetails();

    @Test
    void test_insertFamilyDetails(){
        FamilyDetailsRequest familyDetailsRequest = dummyFamilyDetailsRequest();
        FamilyDetails familyDetails=dummyFamilyDetails();
        when(familyDetailsServiceImpl.insertFamilyDetails(familyDetailsRequest)).thenReturn(familyDetails);
        FamilyDetails response = familyDetailsController.insertFamilyDetails(familyDetailsRequest);
        assertNotNull(response);
    }
    public FamilyDetailsRequest dummyFamilyDetailsRequest() {
        familyDetailsRequest.setFamilyDetailsId(1);
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
        familyDetailsRequest.setSpouse_birth_date(new Date(20-10-2022));
        familyDetailsRequest.setSpouse_religion("hindu");
        familyDetailsRequest.setFathers_first_name("rajendra");

        familyDetailsRequest.setFathers_middle_name("prabhu");
        familyDetailsRequest.setFathers_last_name("ringe");
        familyDetailsRequest.setFather_religion("hindu");
        familyDetailsRequest.setMothers_first_name("maya");
        familyDetailsRequest.setMothers_middle_name("rajendra");
        familyDetailsRequest.setMothers_last_name("ringe");
        familyDetailsRequest.setMother_religion("maya");
        return familyDetailsRequest;

    }

    public FamilyDetails dummyFamilyDetails() {
        FamilyDetailsRequest familyDetailsRequest = dummyFamilyDetailsRequest();
        familyDetails.setFamilyDetailsId(familyDetailsRequest.getFamilyDetailsId());
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
        return familyDetails;

    }
    @Test
    void test_getFamilyDetailsById() throws IOException {
        FamilyDetails familyDetails=dummyFamilyDetails();
        Integer id=1;
        when(familyDetailsServiceImpl.getFamilyDetailsById(id)).thenReturn(Optional.ofNullable(familyDetails));
        Optional<FamilyDetails> response = familyDetailsController.getFamilyDetailsById(1);
        assertNotNull(response);

    }
    @Test
    void test_updateFamilyDetails() throws IOException {
        FamilyDetails familyDetails=dummyFamilyDetails();
        FamilyDetailsRequest familyDetailsRequest=dummyFamilyDetailsRequest();
        when(familyDetailsService.familyDetailsUpdate(familyDetailsRequest)).thenReturn(familyDetails);
        FamilyDetails response=familyDetailsController.familyDetailsUpdate(familyDetailsRequest);
        Assertions.assertNotNull(response);


    }
    @Test
    public void test_getFamilyDetailsList() throws IOException {
        List<FamilyDetails>familyDetailsList=new ArrayList<>();
        FamilyDetails familyDetails=dummyFamilyDetails();
        familyDetailsList.add(familyDetails);
        when(familyDetailsService.findAll()).thenReturn(familyDetailsList);
List<FamilyDetails>response= familyDetailsController.getFamilyDetailsList();
    Assertions.assertNotNull(response);}

}


