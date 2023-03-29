package ai.lentra.service;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.lookups.SpouseCitizenship;
import ai.lentra.repository.lookups.SpouseCitizenshipRepository;
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
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Success");
            ResponseDTO.setCode(HttpStatus.CREATED);
            ResponseDTO.setMessage("Successfully created spouse citizenship type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO);
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
            ResponseDTO.setMessage("Failed to create citizenship Data");
            return ResponseEntity.badRequest().body(ResponseDTO);
        }
    }

    public ResponseEntity<List<Object>> getSpouseCitizenshipType() {
        List<SpouseCitizenship> spouseCitizenshipType = spouseCitizenshipRepository.findAll();
        if (spouseCitizenshipType!= null) {
            return ResponseEntity.ok(Collections.singletonList(spouseCitizenshipType));
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.NOT_FOUND);
            ResponseDTO.setMessage("Failed to retrieve citizenship type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(ResponseDTO));
        }
    }


}




