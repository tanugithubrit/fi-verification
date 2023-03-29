package ai.lentra.service;


import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.lookups.ChildEducationLevel;
import ai.lentra.repository.lookups.ChildEducationLevelRepository;
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
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Success");
            ResponseDTO.setCode(HttpStatus.CREATED);
            ResponseDTO.setMessage("Successfully created child education type.");
            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO);
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.BAD_REQUEST);
            ResponseDTO.setMessage("Failed to create child education data");
            return ResponseEntity.badRequest().body(ResponseDTO);
        }
    }

    public ResponseEntity<List<Object>> getChildEducationLevelType() {
        List<ChildEducationLevel> childEducationLevel= childEducationLevelRepository.findAll();
        if (childEducationLevel!= null) {
            return ResponseEntity.ok(Collections.singletonList(childEducationLevel));
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


