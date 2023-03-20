package ai.lentra.service;

import ai.lentra.dto.ResponseDTO;
import ai.lentra.modal.lookup.InsuranceType;
import ai.lentra.repository.lookup.InsuranceTypeRepository;
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
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Success");
            responseDTO.setCode(HttpStatus.CREATED);
            responseDTO.setMessage("Successfully created insurance type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.BAD_REQUEST);
            responseDTO.setMessage("Failed to create insurance data");
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    public ResponseEntity<List<Object>> getInsuranceType() {
        List<InsuranceType> insuranceType= insuranceTypeRepository.findAll();
        if (insuranceType!= null) {
            return ResponseEntity.ok(Collections.singletonList(insuranceType));
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.NOT_FOUND);
            responseDTO.setMessage("Failed to retrieve child education level type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(responseDTO));
        }
    }

}



