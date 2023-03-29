package ai.lentra.controller.OfficeSelfEmploymentDetails;




import ai.lentra.commons.EndPointReferer;
import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.OfficeSelfEmploymentDto;
import ai.lentra.exceptions.ResidenceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import ai.lentra.service.officeSelfEmploymentDetails.OfficeSelfEmploymentService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static ai.lentra.commons.EndPointReferer.*;
import static ai.lentra.commons.ErrorMessage.OFFICE_NOT_FOUND;


@RestController
@RequestMapping(
        value = EndPointReferer.OFFICE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeSelfEmploymentController {
    private static final Logger logger =  LoggerFactory.getLogger(OfficeSelfEmploymentController.class);

    @Autowired
    private JsonUtils1 jsonUtils;
    @Autowired
    OfficeSelfEmploymentService officeSelfEmploymentService;

    @Operation(summary = "Get all office/employment details")
    @GetMapping(OFFICE_ALL)
    public ResponseEntity<List<OfficeSelfEmploymentDto>> getAllOffices() {
        logger.info("Started API call to get all office/employment details");
        List<OfficeSelfEmployment> offices = officeSelfEmploymentService.findAll();
        List<OfficeSelfEmploymentDto> officeSelfEmploymentDtoList=

                offices.stream()
                        .map(addr -> jsonUtils.mapper().convertValue(addr, OfficeSelfEmploymentDto.class)).collect(Collectors.toList());
        if (!offices.isEmpty()) {

            return  ResponseEntity.status(HttpStatus.OK).body(officeSelfEmploymentDtoList);
        }
        throw new EntityNotFoundException(OFFICE_NOT_FOUND);
    }

    @Operation(summary = "Add office/self employment")
    @PostMapping(OFFICE_ADD)
    public ResponseEntity<?> createOffice(@RequestBody OfficeSelfEmploymentDto officeSelfEmploymentDto) throws ResidenceException {
        logger.info("Started API request for Creating Office details...");
        OfficeSelfEmployment offices = jsonUtils.mapper().convertValue(officeSelfEmploymentDto, OfficeSelfEmployment.class);

        officeSelfEmploymentService.addOffice( offices);
        logger.info("Done Creating Office...");
        return officeSelfEmploymentService.addOffice( offices);
    }


    @Operation(summary = "Get Single office details by ID")
    @GetMapping(OFFICE_ID)

    public ResponseEntity<OfficeSelfEmploymentDto> getExpenses(@PathVariable Integer applicantId)throws ResourceNotFoundException {
        logger.info("Started API call to get office details for Id {} ...", applicantId);
        OfficeSelfEmployment offices = officeSelfEmploymentService.findOfficeById(applicantId);
        OfficeSelfEmploymentDto officeSelfEmploymentDto = jsonUtils.mapper().convertValue(offices, OfficeSelfEmploymentDto.class);
        return new ResponseEntity<>(officeSelfEmploymentDto, HttpStatus.OK);
    }


    @Operation(summary = "Update Single office/self employment")
    @PutMapping(OFFICE_ID + UPDATE)
    public ResponseEntity<OfficeSelfEmploymentDto> updateOffices(@PathVariable Integer applicantId,  @RequestBody OfficeSelfEmploymentDto officeSelfEmploymentDto) {
        logger.info("Started API call to get office details for Id {} ...", applicantId);
        OfficeSelfEmployment officeSelfEmployment = officeSelfEmploymentService.findOfficeById(applicantId);
        OfficeSelfEmployment newOffice = jsonUtils.mapper().convertValue(officeSelfEmploymentDto, OfficeSelfEmployment.class);
        OfficeSelfEmployment officeUpdated = officeSelfEmploymentService.updateOffice(newOffice,officeSelfEmployment);
        OfficeSelfEmploymentDto officeDtoNew = jsonUtils.mapper().convertValue(officeUpdated, OfficeSelfEmploymentDto.class);
        return new ResponseEntity<>(officeDtoNew, HttpStatus.OK);
    }
}
