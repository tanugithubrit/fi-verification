package ai.lentra.service;


import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.lookups.SpouseOccupation;
import ai.lentra.repository.lookups.SpouseOccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class SpouseOccupationService {
    @Autowired

    SpouseOccupationRepository spouseOccupationRepository;
    public ResponseEntity newSpouseOccupationType(SpouseOccupation spouseOccupationType)
    {
        if (spouseOccupationType!=null) {
            spouseOccupationType.setActive(true);
            spouseOccupationRepository.save(spouseOccupationType);
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Success");
            ResponseDTO.setCode(HttpStatus.CREATED);
            ResponseDTO.setMessage("Successfully created spouse occupation type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO);
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
            ResponseDTO.setMessage("Failed to create sim Data");
            return ResponseEntity.badRequest().body(ResponseDTO);
        }
    }

    public ResponseEntity<List<Object>> getSpouseOccupationType() {
        List<SpouseOccupation> spouseOccupationType = spouseOccupationRepository.findAll();
        if (spouseOccupationType!= null) {
            return ResponseEntity.ok(Collections.singletonList(spouseOccupationType));
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.NOT_FOUND);
            ResponseDTO.setMessage("Failed to retrieve spouse occupation type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(ResponseDTO));
        }
    }

}


