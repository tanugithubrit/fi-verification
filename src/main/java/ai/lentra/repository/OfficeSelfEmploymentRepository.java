package ai.lentra.repository;

import ai.lentra.modal.employment_info.OfficeSelfEmployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OfficeSelfEmploymentRepository extends JpaRepository<OfficeSelfEmployment, Long> {
    @Query(value = "SELECT o.id,o.out_of_geo_limit,o.metro_location, o.negative_location, o.office_construction," +
            "o.office_area, o.office_exterior, o.office_interior,o.no_of_storey, o.ease_of_office_location," +
            "o.items_sighted_in_office,o.no_of_employees, o.employment_type, o.designation, o.company_type," +
            "o.job_domain,o.last_month_salary, o.nature_of_business,o.avg_monthly_turn_over,o.business_board_sighted," +
            "o.office_email_verified, o.entry_allowed_in_office,o.domain_check, o.office_name, o.office_telephone_no," +
            "o.extension_no,o.office_email,o.office_address_line_1,o.office_address_line_2,o.office_address_line_3," +
            "o.office_address_line_4,o.office_address_pincode,o.office_address_city,o.office_address_state,o.office_address_country," +
            "o.office_city_code, o.office_state_code,o.employee_code,o.business_activity_sighted," +
            "o.office_locality,o.score,o.applicant_id FROM vms_db.office_self_employment_details_fi o WHERE o.applicant_id =?1 " ,nativeQuery = true)
    Optional<OfficeSelfEmployment> findByAppId(Integer applicantId);

}
