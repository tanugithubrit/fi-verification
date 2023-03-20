package ai.lentra.controller;

import ai.lentra.modal.lookup.InsuranceType;
import ai.lentra.service.InsuranceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookups")

public class InsuranceTypeLookupController {
    @Autowired
    InsuranceTypeService insuranceTypeService;
    @PostMapping("/insurance-type")
    public ResponseEntity<?> addInsuranceType(@RequestBody InsuranceType insuranceType){
        return insuranceTypeService.newInsuranceType(insuranceType);
    }
    @GetMapping("/insurance-type/List")
    public ResponseEntity<?> getInsuranceType(){
        return insuranceTypeService.getInsuranceType();
    }
}
