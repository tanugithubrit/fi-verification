package ai.lentra.repository.masteconfig;

import ai.lentra.modal.masterconfig.MasterVerificationConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MasterVerificationConfigurationRepository extends JpaRepository<MasterVerificationConfiguration,Long> {

    @Query(value = "SELECT m.id, m.profile_name , m.v_type, m.user_type, m.multi_verification_allowed," +
            "m.retriger_verification, m.product_level_logic, m.profile_id, m.sub_profile_name FROM master_verification_configuration m WHERE m.profile_name=?1" , nativeQuery = true)
    MasterVerificationConfiguration findByProfile(String profileName);
}
