package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.PastOrPresent;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)

public class SummaryDto {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("ref_id")
    private Integer refId;

    @JsonProperty("other_findings")
    private Integer otherFindings;

    @JsonProperty("final_score")
    private Integer finalScore;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("remark_date_time")
//        @PastOrPresent
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String remarkDateTime;

    @JsonProperty("prepared_by")
    private String preparedBy;

    @JsonProperty("date_and_time_performed")
//        @PastOrPresent
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String dateAndTimePerformed;

    @JsonProperty("reviewed_by")
    private String reviewedBy;

    @JsonProperty("agency_name")
    private String agencyName;

    @JsonProperty("applicant_id")
    private Integer applicantId;

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public Integer getOtherFindings() {
        return otherFindings;
    }

    public void setOtherFindings(Integer otherFindings) {
        this.otherFindings = otherFindings;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkDateTime() {
        return remarkDateTime;
    }

    public void setRemarkDateTime(String remarkDateTime) {
        this.remarkDateTime = remarkDateTime;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getDateAndTimePerformed() {
        return dateAndTimePerformed;
    }

    public void setDateAndTimePerformed(String dateAndTimePerformed) {
        this.dateAndTimePerformed = dateAndTimePerformed;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public SummaryDto(Long id, Integer refId, Integer otherFindings, Integer finalScore, String remark, String remarkDateTime, String preparedBy, String dateAndTimePerformed, String reviewedBy, String agencyName, Integer applicantId) {
        this.id = id;
        this.refId = refId;
        this.otherFindings = otherFindings;
        this.finalScore = finalScore;
        this.remark = remark;
        this.remarkDateTime = remarkDateTime;
        this.preparedBy = preparedBy;
        this.dateAndTimePerformed = dateAndTimePerformed;
        this.reviewedBy = reviewedBy;
        this.agencyName = agencyName;
        this.applicantId = applicantId;
    }

    public SummaryDto() {
    }
}
