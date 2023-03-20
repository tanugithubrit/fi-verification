package ai.lentra.service;

import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.residence.Residence;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResidenceService {
    List<Residence> findAll()  throws ResourceNotFoundException;

    Residence findResidenceByAppId(Long residenceId) throws ResourceNotFoundException;

    Residence updateExpense(Residence newResidence, Residence residence);

    ResponseEntity<?> addExpense(Residence residence);
}
