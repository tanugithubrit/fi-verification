package ai.lentra.controller.familyDetails;

import ai.lentra.dto.FamilyDetailsRequest;
import ai.lentra.modal.famil_info.FamilyDetail;
import ai.lentra.service.familyDetails.FamilyDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
@Validated
public class FamilyDetailsController {
    @Autowired
    FamilyDetailsService familyDetailsService;
    @Operation(summary = "Save familyDetails record")
    @PostMapping("/familyDetails")
    @ResponseStatus(HttpStatus.CREATED)

    public FamilyDetail insertFamilyDetails(@Valid @RequestBody FamilyDetailsRequest familyDetailsRequest)  {
        return new ResponseEntity<>(familyDetailsService.insertFamilyDetails(familyDetailsRequest),HttpStatus.CREATED).getBody();
    }
    @Operation(summary = "Get familyDetails record by using id")
    @GetMapping("/familyDetails/{familyDetailsId}")
    public Optional<FamilyDetail>getFamilyDetailsById(@PathVariable Integer familyDetailsId){
        return  familyDetailsService.getFamilyDetailsById(familyDetailsId);

    }

    @Operation(summary = "Get All familyDetails record")
    @GetMapping("/familyDetailsData")
    public List<FamilyDetail> getFamilyDetailsList()throws IOException {
        return familyDetailsService.findAll();

    }
    @Operation(summary = "Update familyDetails record")
    @PutMapping("/familyDetails")
    public FamilyDetail familyDetailsUpdate(@RequestBody FamilyDetailsRequest familyDetailsRequest) {
        return	familyDetailsService.familyDetailsUpdate(familyDetailsRequest);
    }

}
