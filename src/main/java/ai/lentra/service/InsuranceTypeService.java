package ai.lentra.service;


import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.lookups.InsuranceType;
import ai.lentra.repository.lookups.InsuranceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InsuranceTypeService {

    @Autowired
    InsuranceTypeRepository insuranceTypeRepository;
    public ResponseEntity newInsuranceType(InsuranceType insuranceType)
    {
        if (insuranceType!=null) {
            insuranceType.setActive(true);
            insuranceTypeRepository.save(insuranceType);
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Success");
            ResponseDTO.setCode(HttpStatus.CREATED);
            ResponseDTO.setMessage("Successfully created insurance type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO);
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
            ResponseDTO.setMessage("Failed to create insurance data");
            return ResponseEntity.badRequest().body(ResponseDTO);
        }
    }

    public ResponseEntity<List<Object>> getInsuranceType() {
        List<InsuranceType> insuranceType= insuranceTypeRepository.findAll();
        if (insuranceType!= null) {
            return ResponseEntity.ok(Collections.singletonList(insuranceType));
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.NOT_FOUND);
            ResponseDTO.setMessage("Failed to retrieve child education level type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(ResponseDTO));
        }
    }

}



