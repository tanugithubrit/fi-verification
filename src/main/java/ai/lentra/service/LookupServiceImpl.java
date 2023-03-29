package ai.lentra.service;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.lookups.SimCardType;
import ai.lentra.repository.lookups.SimCardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class LookupServiceImpl implements LookupService {
    @Autowired
    SimCardTypeRepository simCardTypeRepository;
    @Override
    public ResponseEntity newSimCardType(SimCardType simCardType)
    {
        if (simCardType!=null) {
            simCardType.setActive(true);
            simCardTypeRepository.save(simCardType);
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Success");
            ResponseDTO.setCode(HttpStatus.CREATED);
            ResponseDTO.setMessage("Successfully created sim card type.");
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

    @Override
    public ResponseEntity<List<Object>> getSimType() {
        List<SimCardType> simCardType = simCardTypeRepository.findAll();
        if (simCardType!= null) {
            return ResponseEntity.ok(Collections.singletonList(simCardType));
        }
        else {
            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setStatus("Failed");
            ResponseDTO.setCode(HttpStatus.NOT_FOUND);
            ResponseDTO.setMessage("Failed to retrieve sim card type.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(ResponseDTO));
        }
    }
}
