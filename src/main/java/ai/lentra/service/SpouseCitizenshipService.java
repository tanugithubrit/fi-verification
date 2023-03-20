package ai.lentra.service;

import ai.lentra.dto.ResponseDTO;
import ai.lentra.modal.lookup.SpouseCitizenship;
import ai.lentra.repository.lookup.SpouseCitizenshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SpouseCitizenshipService {
    @Autowired

    SpouseCitizenshipRepository spouseCitizenshipRepository;

    public ResponseEntity newSpouseCitizenshipType(SpouseCitizenship spouseCitizenshipType)
    {
        if (spouseCitizenshipType!=null) {
            spouseCitizenshipType.setActive(true);
            spouseCitizenshipRepository.save(spouseCitizenshipType);
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Success");
            responseDTO.setCode(HttpStatus.CREATED);
            responseDTO.setMessage("Successfully created spouse citizenship type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.BAD_REQUEST);
            responseDTO.setMessage("Failed to create citizenship Data");
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    public ResponseEntity<List<Object>> getSpouseCitizenshipType() {
        List<SpouseCitizenship> spouseCitizenshipType = spouseCitizenshipRepository.findAll();
        if (spouseCitizenshipType!= null) {
            return ResponseEntity.ok(Collections.singletonList(spouseCitizenshipType));
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.NOT_FOUND);
            responseDTO.setMessage("Failed to retrieve citizenship type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(responseDTO));
        }
    }


}




