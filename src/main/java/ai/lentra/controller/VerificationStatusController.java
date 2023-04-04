package ai.lentra.controller;

import ai.lentra.config.HeaderConfig;
import ai.lentra.dto.HeadersDTO;
import ai.lentra.dto.VerificationStatusDTO;
import ai.lentra.dto.VerifierDetailsDTO;
import ai.lentra.modal.VerifierDetails;
import ai.lentra.service.VerificationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class VerificationStatusController {

        @Autowired
        VerificationStatusService verificationStatusService;

    @PostMapping(value = "verifiers-details",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> verifierDetails(@RequestBody @Valid VerifierDetailsDTO verifierStatus,
                                            @RequestHeader(name = "TOKEN", required = false) String token,
                                            @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                            @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                            @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                            @RequestHeader(name = "USER-NAME", required = true) String userName,
                                            @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                            @RequestHeader(name = "BRANCH-NAME", required = true) String branchName,
                                             @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) {
        HeadersDTO headers = HeaderConfig.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType, applicantType);
        System.out.println(headers);
        return verificationStatusService.verifierStatus(verifierStatus,headers);
    }
    @GetMapping(value = "verifiers-details")
    public ResponseEntity<?> verifierDetailsGet(@RequestBody VerifierDetailsDTO verifierStatus,
                                             @RequestHeader(name = "TOKEN", required = false) String token,
                                             @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                             @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,
                                             @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                             @RequestHeader(name = "USER-NAME", required = true) String userName,
                                             @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                             @RequestHeader(name = "BRANCH-NAME", required = true) String branchName,
                                             @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) {
        HeadersDTO headers = HeaderConfig.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType, applicantType);
        return ResponseEntity.ok().body(new VerifierDetails());
    }



    @PutMapping(value = "verification-status",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> verificationStatus(@RequestBody VerificationStatusDTO verificationStatusDTO,
                                             @RequestHeader(name = "TOKEN", required = false) String token,
                                             @RequestHeader(name = "APPLICATION-ID", required = true) Long applicationId,
                                             @RequestHeader(name = "ROLE-TYPE", required = true) String roleType,
                                                @RequestHeader(name = "APPLICANT-TYPE", required = true) String applicantType,                                                @RequestHeader(name = "USER-NAME", required = true) String userName,
                                             @RequestHeader(name = "INSTITUTION-ID", required = true) String institutionId,
                                             @RequestHeader(name = "BRANCH-NAME", required = true) String branchName,
                                                @RequestHeader(name = "PRODUCT-TYPE", required = true) String productType) {
        HeadersDTO headers = HeaderConfig.headerGenerator(token,applicationId,roleType,userName,institutionId,branchName,productType, applicantType);
        return verificationStatusService.updateVerificationStatus(verificationStatusDTO,headers);
    }

}
