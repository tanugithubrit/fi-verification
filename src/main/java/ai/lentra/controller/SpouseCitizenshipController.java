package ai.lentra.controller.lookup;

import ai.lentra.modal.lookup.SpouseCitizenship;
import ai.lentra.modal.lookup.SpouseOccupation;
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



