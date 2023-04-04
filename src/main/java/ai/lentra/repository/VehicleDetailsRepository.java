package ai.lentra.repository;

import ai.lentra.modal.vehicle_info.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,Long> {
    VehicleDetails findByApplicantId(Long applicantId);
}
