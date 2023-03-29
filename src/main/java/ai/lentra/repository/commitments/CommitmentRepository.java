package ai.lentra.repository.commitments;


import ai.lentra.modal.Commitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitmentRepository extends JpaRepository<Commitment, Integer> {
}
