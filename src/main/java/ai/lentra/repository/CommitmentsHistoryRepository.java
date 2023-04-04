package ai.lentra.repository;

import ai.lentra.modal.commitment.CommitmentDetails;
import ai.lentra.modal.commitment.CommitmentDetailsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitmentsHistoryRepository extends JpaRepository<CommitmentDetailsHistory,Long> {
}
