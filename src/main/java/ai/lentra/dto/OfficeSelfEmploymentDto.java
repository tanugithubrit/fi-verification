package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)

public class OfficeSelfEmploymentDto {


    @JsonProperty("id")
    private Long id;

    @JsonProperty("out_of_geo_limit")
    private boolean outOfGeoLimit;

    @JsonProperty("metro_location")
    private boolean metroLocation;

    @JsonProperty("negative_location")
    private boolean negativeLocation;

    @JsonProperty("office_construction")
    private Integer office_construction;
    @JsonProperty("office_area")
    private Integer officeArea;
    @JsonProperty("office_exterior")
    private Integer officeExterior;
    @JsonProperty("office_interior")
    private Integer officeInterior;
    @JsonProperty("no_of_storey")
    private Integer noOfStorey;
    @JsonProperty("ease_of_office_location")
    private Integer easeOfOfficeLocation;

    @JsonProperty("items_sighted_in_office")
    private Integer itemsSightedInOffice;
    @JsonProperty("no_of_employees")
    private String noOfEmplyees;

    @JsonProperty("employment_type")
    private Integer employmentType;
    @JsonProperty("designation")
    private Integer designation;

    @JsonProperty("company_type")
    private Integer company_type;

    @JsonProperty("job_domain")
    private Integer jobDomain;

    @JsonProperty("last_month_salary")
    private Long last_monthSalary;

    @JsonProperty("nature_of_business")
    private Integer natureOfBusiness;

    @JsonProperty("avg_monthly_turn_over")
    private Integer avgMonthlyTurnOver;

    @JsonProperty("business_board_sighted")
    private boolean businessBoardSighted;

    @JsonProperty("office_email_verified")
    private boolean officeEmailVerified;

    @JsonProperty("entry_allowed_in_office")
    private boolean entryAllowedInOffice;

    @JsonProperty("domain_check")
    private boolean domainCheck;

    @JsonProperty("office_name")
    private String officeName;

    @JsonProperty("office_telephone_no")
    private Long officeTelephoneNo;
    @JsonProperty("extension_no")
    private Integer extensionNo;

    @JsonProperty("office_email")
    private String officeEmail;
    @JsonProperty("office_address_line_1")
    private String officeAddressLine1;

    @JsonProperty("office_address_line_2")
    private String officeAddressLine2;

    @JsonProperty("office_address_line_3")
    private String officeAddressLine3;


    @JsonProperty("applicant_id")
    private Integer applicantId;
    @JsonProperty("score")
    private BigDecimal score;

    @JsonProperty("office_address_line_4")
    private String officeAddressLine4;

    @JsonProperty("office_address_pincode")
    private String officeAddressPincode;

    @JsonProperty("office_address_city")
    private String officeAddressCity;
    @Column(name = "office_state_code")
    @JsonProperty("office_state_code")
    private String officeStateCode;

    @JsonProperty("office_address_state")
    private String office_address_state;

    @JsonProperty("office_address_country")
    private Integer officeAddressCountry;

    @JsonProperty("office_city_code")
    private String officeCityCode;

    @JsonProperty("employee_code")
    private String employeeCode;

    @JsonProperty("business_activity_sighted")
    private String businessActivitySighted;

    @JsonProperty("office_locality")
    private Integer officeLocality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOutOfGeoLimit() {
        return outOfGeoLimit;
    }

    public void setOutOfGeoLimit(boolean outOfGeoLimit) {
        this.outOfGeoLimit = outOfGeoLimit;
    }

    public boolean isMetroLocation() {
        return metroLocation;
    }

    public String getOfficeAddressLine3() {
        return officeAddressLine3;
    }

    public void setOfficeAddressLine3(String officeAddressLine3) {
        this.officeAddressLine3 = officeAddressLine3;
    }

    public void setMetroLocation(boolean metroLocation) {
        this.metroLocation = metroLocation;
    }

    public boolean isNegativeLocation() {
        return negativeLocation;
    }

    public void setNegativeLocation(boolean negativeLocation) {
        this.negativeLocation = negativeLocation;
    }

    public Integer getOffice_construction() {
        return office_construction;
    }

    public void setOffice_construction(Integer office_construction) {
        this.office_construction = office_construction;
    }

    public Integer getOfficeArea() {
        return officeArea;
    }

    public void setOfficeArea(Integer officeArea) {
        this.officeArea = officeArea;
    }

    public Integer getOfficeExterior() {
        return officeExterior;
    }

    public void setOfficeExterior(Integer officeExterior) {
        this.officeExterior = officeExterior;
    }

    public Integer getOfficeInterior() {
        return officeInterior;
    }

    public void setOfficeInterior(Integer officeInterior) {
        this.officeInterior = officeInterior;
    }

    public Integer getNoOfStorey() {
        return noOfStorey;
    }

    public void setNoOfStorey(Integer noOfStorey) {
        this.noOfStorey = noOfStorey;
    }

    public Integer getEaseOfOfficeLocation() {
        return easeOfOfficeLocation;
    }

    public void setEaseOfOfficeLocation(Integer easeOfOfficeLocation) {
        this.easeOfOfficeLocation = easeOfOfficeLocation;
    }

    public Integer getItemsSightedInOffice() {
        return itemsSightedInOffice;
    }

    public void setItemsSightedInOffice(Integer itemsSightedInOffice) {
        this.itemsSightedInOffice = itemsSightedInOffice;
    }

    public String getNoOfEmplyees() {
        return noOfEmplyees;
    }

    public void setNoOfEmplyees(String noOfEmplyees) {
        this.noOfEmplyees = noOfEmplyees;
    }

    public Integer getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(Integer employmentType) {
        this.employmentType = employmentType;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public Integer getCompany_type() {
        return company_type;
    }

    public void setCompany_type(Integer company_type) {
        this.company_type = company_type;
    }

    public Integer getJobDomain() {
        return jobDomain;
    }

    public void setJobDomain(Integer jobDomain) {
        this.jobDomain = jobDomain;
    }

    public Long getLast_monthSalary() {
        return last_monthSalary;
    }

    public void setLast_monthSalary(Long last_monthSalary) {
        this.last_monthSalary = last_monthSalary;
    }

    public Integer getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(Integer natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public Integer getAvgMonthlyTurnOver() {
        return avgMonthlyTurnOver;
    }

    public void setAvgMonthlyTurnOver(Integer avgMonthlyTurnOver) {
        this.avgMonthlyTurnOver = avgMonthlyTurnOver;
    }

    public boolean isBusinessBoardSighted() {
        return businessBoardSighted;
    }

    public void setBusinessBoardSighted(boolean businessBoardSighted) {
        this.businessBoardSighted = businessBoardSighted;
    }

    public boolean isOfficeEmailVerified() {
        return officeEmailVerified;
    }

    public void setOfficeEmailVerified(boolean officeEmailVerified) {
        this.officeEmailVerified = officeEmailVerified;
    }

    public boolean isEntryAllowedInOffice() {
        return entryAllowedInOffice;
    }

    public void setEntryAllowedInOffice(boolean entryAllowedInOffice) {
        this.entryAllowedInOffice = entryAllowedInOffice;
    }

    public boolean isDomainCheck() {
        return domainCheck;
    }

    public void setDomainCheck(boolean domainCheck) {
        this.domainCheck = domainCheck;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Long getOfficeTelephoneNo() {
        return officeTelephoneNo;
    }

    public void setOfficeTelephoneNo(Long officeTelephoneNo) {
        this.officeTelephoneNo = officeTelephoneNo;
    }

    public Integer getExtensionNo() {
        return extensionNo;
    }

    public void setExtensionNo(Integer extensionNo) {
        this.extensionNo = extensionNo;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public String getOfficeAddressLine1() {
        return officeAddressLine1;
    }

    public void setOfficeAddressLine1(String officeAddressLine1) {
        this.officeAddressLine1 = officeAddressLine1;
    }

    public String getOfficeAddressLine2() {
        return officeAddressLine2;
    }

    public void setOfficeAddressLine2(String officeAddressLine2) {
        this.officeAddressLine2 = officeAddressLine2;
    }


    public String getOfficeStateCode() {
        return officeStateCode;
    }

    public void setOfficeStateCode(String officeStateCode) {
        this.officeStateCode = officeStateCode;
    }

    public String getOfficeAddressLine4() {
        return officeAddressLine4;
    }

    public void setOfficeAddressLine4(String officeAddressLine4) {
        this.officeAddressLine4 = officeAddressLine4;
    }

    public String getOfficeAddressPincode() {
        return officeAddressPincode;
    }

    public void setOfficeAddressPincode(String officeAddressPincode) {
        this.officeAddressPincode = officeAddressPincode;
    }

    public String getOfficeAddressCity() {
        return officeAddressCity;
    }

    public void setOfficeAddressCity(String officeAddressCity) {
        this.officeAddressCity = officeAddressCity;
    }

    public String getOffice_address_state() {
        return office_address_state;
    }

    public void setOffice_address_state(String office_address_state) {
        this.office_address_state = office_address_state;
    }

    public Integer getOfficeAddressCountry() {
        return officeAddressCountry;
    }

    public void setOfficeAddressCountry(Integer officeAddressCountry) {
        this.officeAddressCountry = officeAddressCountry;
    }

    public String getOfficeCityCode() {
        return officeCityCode;
    }

    public void setOfficeCityCode(String officeCityCode) {
        this.officeCityCode = officeCityCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getBusinessActivitySighted() {
        return businessActivitySighted;
    }

    public void setBusinessActivitySighted(String businessActivitySighted) {
        this.businessActivitySighted = businessActivitySighted;
    }

    public Integer getOfficeLocality() {
        return officeLocality;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public void setOfficeLocality(Integer officeLocality) {
        this.officeLocality = officeLocality;
    }

}
