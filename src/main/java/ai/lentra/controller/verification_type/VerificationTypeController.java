package ai.lentra.controller.verification_type;

import ai.lentra.dto.masterconfig.MasterVerificationConfigurationDto;
import ai.lentra.dto.masterconfig.VerificationFormFieldsConfigDto;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import ai.lentra.service.masterconfig.VerificationConfigService;
import ai.lentra.service.verification_type.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verification_types")
public class VerificationTypeController {
    @Autowired
    ProductService productService;
    @Autowired
    VerificationConfigService configService;

    @GetMapping("/{profile_name}/{product_type}")
    public ResponseEntity<ResponseDTO> getVerificationType(@RequestHeader(value="Content-Type",required = true) String contentType  ,
                                                           @RequestHeader(value="token",required = false) String token,
                                                           @RequestHeader(value="user_name",required = true) String userName ,
                                                           @RequestHeader(value="institution_id",required = true) Integer institutionId,
                                                           @RequestHeader(value="role_type",required = true) String roleType ,
                                                           @RequestHeader(value="application_id",required = true) Integer applicationId ,
                                                           @RequestHeader(value="application_type",required = true) String applicationType ,
                                                           @RequestHeader(value="branch_name",required = false) String branchName ,

                                                           @PathVariable String profile,
                                                           @PathVariable String productType) {

//        String profileName = productService.getProductDetails(institutionId,productType,profile);
        return configService.getVerificationType(institutionId,productType,profile);
    }
}
