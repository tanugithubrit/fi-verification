package ai.lentra.controller.configuration.roles;



import ai.lentra.dto.configuration.RolesDTO;
import ai.lentra.modal.configuration.RolesEntity;
import ai.lentra.service.configuration.roles.RolesConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;

import java.util.Optional;

@Validated
@RestController
@RequestMapping(value = "/roles")
public class RoleConfigController {
	@Autowired
	RolesConfigService rolesService;
	@PostMapping("/role_config")
	public ResponseEntity<ResponseDTO> saveRole( @RequestBody RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException {

		return rolesService.saveRole(rolesDTO);
	}

	@PatchMapping("/role_config")
	public ResponseEntity<ResponseDTO> updateRole( @RequestBody RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException {

		return rolesService.updateRole(rolesDTO);
	}

	@GetMapping("/master_role_config")
	public ResponseEntity<Object>getAllRoles() throws ResourceNotFoundException, DuplicateResourceException {

		return rolesService.getAllRoles();
	}

	@GetMapping("/role_config/{applicantId}")
	public ResponseEntity<Object> getRole(@PathVariable Long applicantId) throws ResourceNotFoundException, DuplicateResourceException {

		return rolesService.getRole(applicantId);
	}

}
