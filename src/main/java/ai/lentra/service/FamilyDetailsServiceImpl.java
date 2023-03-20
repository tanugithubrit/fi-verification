package ai.lentra.service;

import ai.lentra.dto.FamilyDetailsRequest;
import ai.lentra.modal.FamilyDetails;
import ai.lentra.repository.FamilyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FamilyDetailsServiceImpl implements FamilyDetailsService {
    private final FamilyDetailsRepository familyDetailsRepository;

    @Autowired
    public FamilyDetailsServiceImpl(FamilyDetailsRepository familyDetailsRepository) {
        this.familyDetailsRepository = familyDetailsRepository;
    }

    FamilyDetails familyDetails = new FamilyDetails();

    @Override
    public FamilyDetails insertFamilyDetails(FamilyDetailsRequest familyDetailsRequest) {
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
        familyDetails.setSpouse_first_name(familyDetailsRequest.getSpouse_first_name());
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
        return familyDetails;


    }

    @Override
    public Optional<FamilyDetails> getFamilyDetailsById(Integer familyDetailsId) {
        Optional<FamilyDetails> familyDetails = familyDetailsRepository.findById(familyDetailsId);
        return familyDetails;
    }

    @Override
    public List<FamilyDetails> findAll() {
        return familyDetailsRepository.findAll();
    }

    @Override
    public FamilyDetails familyDetailsUpdate(FamilyDetailsRequest familyDetailsRequest) {
        FamilyDetails familyDetails = new FamilyDetails();
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
        familyDetails.setSpouse_first_name(familyDetailsRequest.getSpouse_first_name());
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
        return familyDetails;


    }
}
