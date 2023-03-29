package ai.lentra.service.familyDetails;

import ai.lentra.dto.FamilyDetailsRequest;
import ai.lentra.modal.famil_info.FamilyDetail;

import java.util.List;
import java.util.Optional;

public interface FamilyDetailsService {
    FamilyDetail insertFamilyDetails(FamilyDetailsRequest familyDetailsRequest);

        List<FamilyDetail> findAll();

    Optional<FamilyDetail> getFamilyDetailsById(Integer familyDetailsId);

    FamilyDetail familyDetailsUpdate(FamilyDetailsRequest familyDetailsRequest);

   // FamilyDetails updateFamilyDetails(FamilyDetailsRequest familyDetailsRequest);

    //FamilyDetails familyDtailsById(int i);
}
