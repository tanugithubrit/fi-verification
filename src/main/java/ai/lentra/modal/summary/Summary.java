package ai.lentra.modal.summary;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "summary_fi")
//@TypeDef(name = "JsonDataUserType", typeClass = JsonDataUserType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

	public Summary(Long id, Integer refId, Integer otherFindings, Integer finalScore, String remark, String remarkDateTime, String preparedBy, String dateAndTimePerformed, String reviewedBy, String agencyName, Long applicantId, Integer score) {
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
		this.score = score;
	}

	public Summary() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;
	@Column(name = "ref_id")
	@JsonProperty("ref_id")
	private Integer refId;

	@Column(name = "other_findings")
	@JsonProperty("other_findings")
	private Integer otherFindings;

	@Column(name = "final_score")
	@JsonProperty("final_score")
	private Integer finalScore;

	@Column(name = "remark")
	@JsonProperty("remark")
	private String remark;

	@Column(name = "remark_date_time")
	@JsonProperty("remark_date_time")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//        @PastOrPresent
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String remarkDateTime;

	@Column(name = "prepared_by")
	@JsonProperty("prepared_by")
	private String preparedBy;

	@Column(name = "date_and_time_performed")
	@JsonProperty("date_and_time_performed")
//        @PastOrPresent

//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")

	private String dateAndTimePerformed;

	@Column(name = "reviewed_by")
	@JsonProperty("reviewed_by")
	private String reviewedBy;

	@Column(name = "agency_name")
	@JsonProperty("agency_name")
	private String agencyName;

	@Column(name = "applicant_id")
	@JsonProperty("applicant_id")
	private Long applicantId;



	@Column(name = "score")
	@JsonProperty("score")
	private Integer score;

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
	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
