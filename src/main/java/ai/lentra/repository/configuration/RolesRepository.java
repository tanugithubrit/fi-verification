package ai.lentra.repository.configuration;

import ai.lentra.modal.configuration.RolesEntity;
import ai.lentra.modal.contact_info.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository  extends JpaRepository<RolesEntity, Integer> {

    RolesEntity findByRoleId(Long applicantId);
    RolesEntity findByRoleName(String RoleName);
}
