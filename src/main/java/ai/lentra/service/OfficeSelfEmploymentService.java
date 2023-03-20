package ai.lentra.service;


import ai.lentra.exceptions.ResidenceException;
import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfficeSelfEmploymentService {
    List<OfficeSelfEmployment> findAll();

    ResponseEntity<?> addOffice(OfficeSelfEmployment offices);

    OfficeSelfEmployment findOfficeById(Integer applicantId)throws ResidenceException;

    OfficeSelfEmployment updateOffice(OfficeSelfEmployment newOffice, OfficeSelfEmployment officeSelfEmployment);
}
