package ai.lentra.repository;

import ai.lentra.modal.vehicle_info.VehicleDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailsHistoryRepository extends JpaRepository<VehicleDetailsHistory,Long> {
}
