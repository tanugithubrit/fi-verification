package ai.lentra.controller;

import ai.lentra.modal.lookups.SpouseCitizenship;
import ai.lentra.modal.lookups.SpouseOccupation;
import ai.lentra.service.SpouseCitizenshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookups")

public class SpouseCitizenshipController {
    @Autowired
    SpouseCitizenshipService spouseCitizenshipService;
    @PostMapping("/citizenship-type")
    public ResponseEntity<?> addSpouseCitizenshipType(@RequestBody SpouseCitizenship spouseCitizenship){
        return spouseCitizenshipService.newSpouseCitizenshipType(spouseCitizenship);

    }
    @GetMapping("/citizenship-type/List")
    public ResponseEntity<?> getSpouseCitizenshipType(){
        return spouseCitizenshipService.getSpouseCitizenshipType();

    }
}



