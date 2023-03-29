package ai.lentra.repository.lookups;

import ai.lentra.modal.lookups.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType,Integer> {
}
