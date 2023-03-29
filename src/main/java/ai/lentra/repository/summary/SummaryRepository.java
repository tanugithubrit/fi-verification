package ai.lentra.repository.summary;

import ai.lentra.modal.summary.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    //    @Query(value = "SELECT s.id,s.ref_id, s.other_findings, s.final_score, s.remark, s.remark_date_time, s.prepared_by, s.date_and_time_performed, s.reviewed_by," +
//            "s.agency_name, s.applicant_id FROM vms_db.summary_fi s WHERE s.applicant_id = ?1",nativeQuery = true)
    Optional<Summary> findByApplicantId(Long applicantId);
}
