package ai.lentra.service.configuration.roles;

import ai.lentra.dto.configuration.RolesDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.configuration.RolesEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface RolesConfigService {
    public ResponseEntity<ResponseDTO> saveRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<ResponseDTO> updateRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<Object>getAllRoles() throws ResourceNotFoundException, DuplicateResourceException;

    public ResponseEntity<Object> getRole(Long applicantId) throws ResourceNotFoundException, DuplicateResourceException;


}
