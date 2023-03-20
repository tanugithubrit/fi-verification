package ai.lentra.service;

import ai.lentra.dto.ResponseDTO;
import ai.lentra.modal.lookup.SpouseOccupation;
import ai.lentra.repository.lookup.SpouseOccupationRepository;
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
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Success");
            responseDTO.setCode(HttpStatus.CREATED);
            responseDTO.setMessage("Successfully created spouse occupation type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.BAD_REQUEST);
            responseDTO.setMessage("Failed to create sim Data");
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    public ResponseEntity<List<Object>> getSpouseOccupationType() {
        List<SpouseOccupation> spouseOccupationType = spouseOccupationRepository.findAll();
        if (spouseOccupationType!= null) {
            return ResponseEntity.ok(Collections.singletonList(spouseOccupationType));
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.NOT_FOUND);
            responseDTO.setMessage("Failed to retrieve spouse occupation type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(responseDTO));
        }
    }

}


