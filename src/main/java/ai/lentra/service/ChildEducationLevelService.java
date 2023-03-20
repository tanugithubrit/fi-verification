package ai.lentra.service;

import ai.lentra.dto.ResponseDTO;
import ai.lentra.modal.lookup.ChildEducationLevel;
import ai.lentra.repository.lookup.ChildEducationLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ChildEducationLevelService {
    @Autowired
            ChildEducationLevelRepository childEducationLevelRepository;
    public ResponseEntity newChildEducationLevelType(ChildEducationLevel childEducationLevel)
    {
        if (childEducationLevel!=null) {
            childEducationLevel.setActive(true);
            childEducationLevelRepository.save(childEducationLevel);
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Success");
            responseDTO.setCode(HttpStatus.CREATED);
            responseDTO.setMessage("Successfully created child education type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        }
        else {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Failed");
            responseDTO.setCode(HttpStatus.BAD_REQUEST);
            responseDTO.setMessage("Failed to create child education data");
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    public ResponseEntity<List<Object>> getChildEducationLevelType() {
        List<ChildEducationLevel> childEducationLevel= childEducationLevelRepository.findAll();
        if (childEducationLevel!= null) {
            return ResponseEntity.ok(Collections.singletonList(childEducationLevel));
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


