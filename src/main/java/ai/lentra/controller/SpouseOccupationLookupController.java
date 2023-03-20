package ai.lentra.controller.lookup;

import ai.lentra.modal.lookup.SpouseOccupation;
import ai.lentra.service.SpouseOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookups")

public class SpouseOccupationController {
    @Autowired
    SpouseOccupationService spouseOccupationService;
    @PostMapping("/occupation-type")
    public ResponseEntity<?> addSpouseOccupationType(@RequestBody SpouseOccupation spouseOccupation){
        return   spouseOccupationService.newSpouseOccupationType(spouseOccupation);
    }
    @GetMapping("/occupation-type/List")
    public ResponseEntity<?> getSpouseOccupationType(){
        return spouseOccupationService.getSpouseOccupationType();
    }
}

