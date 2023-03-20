package ai.lentra.service;

import ai.lentra.dto.FamilyDetailsRequest;
import ai.lentra.modal.FamilyDetails;

import java.util.List;
import java.util.Optional;

public interface FamilyDetailsService {
    FamilyDetails insertFamilyDetails(FamilyDetailsRequest familyDetailsRequest);

        List<FamilyDetails> findAll();

    Optional<FamilyDetails> getFamilyDetailsById(Integer familyDetailsId);

    FamilyDetails familyDetailsUpdate(FamilyDetailsRequest familyDetailsRequest);

   // FamilyDetails updateFamilyDetails(FamilyDetailsRequest familyDetailsRequest);

    //FamilyDetails familyDtailsById(int i);
}
