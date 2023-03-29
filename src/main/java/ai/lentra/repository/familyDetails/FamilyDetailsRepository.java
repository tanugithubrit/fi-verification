package ai.lentra.repository.familyDetails;


import ai.lentra.modal.famil_info.FamilyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyDetailsRepository extends JpaRepository<FamilyDetail, Integer> {
}
