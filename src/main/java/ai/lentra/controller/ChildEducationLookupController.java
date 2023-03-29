package ai.lentra.controller;


import ai.lentra.modal.lookups.ChildEducationLevel;
import ai.lentra.modal.lookups.SpouseOccupation;
import ai.lentra.service.ChildEducationLevelService;
import ai.lentra.service.SpouseOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookups")
public class ChildEducationLookupController {
    @Autowired
            ChildEducationLevelService childEducationLevelService;
       @PostMapping("/education-type")
    public ResponseEntity<?> addChildEducationLevelType(@RequestBody ChildEducationLevel childEducationLevel){
        return childEducationLevelService.newChildEducationLevelType(childEducationLevel);
    }
    @GetMapping("/education-type/List")
    public ResponseEntity<?> getChildEducationLevelType(){
        return childEducationLevelService.getChildEducationLevelType();
    }
}

