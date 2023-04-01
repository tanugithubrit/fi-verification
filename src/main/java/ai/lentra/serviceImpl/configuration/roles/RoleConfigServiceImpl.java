package ai.lentra.serviceImpl.configuration.roles;

import ai.lentra.dto.configuration.RolesDTO;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.DuplicateResourceException;
import ai.lentra.exceptions.ResourceNotFoundException;
import ai.lentra.modal.configuration.RolesEntity;
import ai.lentra.modal.contact_info.ContactDetails;
import ai.lentra.repository.configuration.RolesRepository;
import ai.lentra.service.configuration.roles.RolesConfigService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ai.lentra.commons.ResponeGen.getResponse;
@Service
public class RoleConfigServiceImpl implements RolesConfigService {

    @Autowired
    RolesRepository repository;

    @Override
    public ResponseEntity<ResponseDTO> saveRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
            try{
            if(rolesDTO.getRoleName().trim().isEmpty() || rolesDTO.getVmsRoleName().trim().isEmpty() || ( rolesDTO.getStatus() == null) ){
                if(rolesDTO.getStatus() == null ){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Status should not be null / empty ","ERROR"));
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role name / Vms role name should not be blank ","ERROR"));
            }}
            catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role name / Vms role name should not be null ","ERROR"));
            }
            Optional<RolesEntity> optionalRole = Optional.ofNullable(repository.findByRoleName(rolesDTO.getRoleName()));
            if (optionalRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(403,"This Role Already mapped with Another Role ","ERROR"));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            RolesEntity roles = objectMapper.convertValue(rolesDTO, RolesEntity.class);

            repository.save(roles);
            return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"Role has been added successfully ","CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"Role already mapped ","ERROR"));
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> updateRole(RolesDTO rolesDTO) throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
            try{
                if(rolesDTO.getRoleId() == 0){ throw new ArithmeticException("invalid Id"); }
                if(rolesDTO.getRoleName().trim().isEmpty() || rolesDTO.getVmsRoleName().trim().isEmpty() || ( rolesDTO.getStatus() == null) ){
                    if(rolesDTO.getStatus() == null ){
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Status should not be null / empty ","ERROR"));
                    }
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role name / Vms role name should not be blank ","ERROR"));
                }}
            catch (ArithmeticException ae){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"ID should not be 0/null/empty ","ERROR"));
            }
            catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role name / Vms role name should not be null ","ERROR"));
            }
            Optional<RolesEntity> optionalRole = Optional.ofNullable(repository.findByRoleId(rolesDTO.getRoleId()));
            if (!optionalRole.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role Not Found ","ERROR"));
            }
            RolesEntity existingRoles = optionalRole.get();
            if (rolesDTO.getRoleName() != null) {
                existingRoles.setRoleName(rolesDTO.getRoleName());
            }
            if (rolesDTO.getVmsRoleName() != null) {
                existingRoles.setVmsRoleName(rolesDTO.getVmsRoleName());
            }
            if (rolesDTO.getStatus() != null) {
                existingRoles.setStatus(rolesDTO.getStatus());
            }

            repository.save(existingRoles);
            return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"Role has been updated successfully ","CREATED"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"error while updating role config ","ERROR"));
        }
    }

    @Override
    public ResponseEntity<Object> getAllRoles() throws ResourceNotFoundException, DuplicateResourceException
    {
        try{
        List<RolesEntity> rolesEntity =repository.findAll();
            // return  repository.findAll() ; //ResponseEntity.status(HttpStatus.OK).body(a.getData());
           return ( rolesEntity == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404," no results" ,"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(rolesEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse(500,"error while fetching role config data","ERROR"));
        }
    }

    @Override
    public ResponseEntity<Object> getRole(Long applicantId ) throws ResourceNotFoundException, DuplicateResourceException
    {
        RolesEntity rolesEntity = repository.findByRoleId(applicantId);
        return (rolesEntity == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(getResponse(404,"Role Not Found " ,"ERROR")) : ResponseEntity.status(HttpStatus.OK).body(rolesEntity));
    }

}
