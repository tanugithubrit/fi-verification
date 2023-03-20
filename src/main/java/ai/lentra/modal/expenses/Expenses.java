package ai.lentra.modal.expenses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "expenses_fi")
//@TypeDef(name = "JsonDataUserType", typeClass = JsonDataUserType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;
	@Column(name = "other_exp")
	@JsonProperty("other_exp")
	private BigDecimal otherExp;

	@Column(name = "college_fees_amt")
	@JsonProperty("college_fees_amt")
	private BigDecimal collegeFeesAmt;

	@Column(name = "school_fees_amt")
	@JsonProperty("school_fees_amt")
	private BigDecimal schoolFeesAmt;

	@Column(name = "electric_bill_amt")
	@JsonProperty("electric_bill_amt")
	private BigDecimal electricBillAmt;

	@Column(name = "office_transportation_cost")
	@JsonProperty("office_transportation_cost")
	private BigDecimal officeTransportationCost;

	@Column(name = "cable_net_bill_amt")
	@JsonProperty("cable_net_bill_amt")
	private BigDecimal cableNetBillAmt;

	@Column(name = "broadband_bill_amt")
	@JsonProperty("broadband_bill_amt")
	private BigDecimal broadbandBillAmt;

	@Column(name = "avg_fuel_cost")
	@JsonProperty("avg_fuel_cost")
	private BigDecimal avgFuelCost;

	@Column(name = "applicant_id")
	@JsonProperty("applicant_id")
	private Integer applicantId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getOtherExp() {
		return otherExp;
	}

	public void setOtherExp(BigDecimal otherExp) {
		this.otherExp = otherExp;
	}

	public BigDecimal getCollegeFeesAmt() {
		return collegeFeesAmt;
	}

	public void setCollegeFeesAmt(BigDecimal collegeFeesAmt) {
		this.collegeFeesAmt = collegeFeesAmt;
	}

	public BigDecimal getSchoolFeesAmt() {
		return schoolFeesAmt;
	}

	public void setSchoolFeesAmt(BigDecimal schoolFeesAmt) {
		this.schoolFeesAmt = schoolFeesAmt;
	}

	public BigDecimal getElectricBillAmt() {
		return electricBillAmt;
	}

	public void setElectricBillAmt(BigDecimal electricBillAmt) {
		this.electricBillAmt = electricBillAmt;
	}

	public BigDecimal getOfficeTransportationCost() {
		return officeTransportationCost;
	}

	public void setOfficeTransportationCost(BigDecimal officeTransportationCost) {
		this.officeTransportationCost = officeTransportationCost;
	}

	public BigDecimal getCableNetBillAmt() {
		return cableNetBillAmt;
	}

	public void setCableNetBillAmt(BigDecimal cableNetBillAmt) {
		this.cableNetBillAmt = cableNetBillAmt;
	}

	public BigDecimal getBroadbandBillAmt() {
		return broadbandBillAmt;
	}

	public void setBroadbandBillAmt(BigDecimal broadbandBillAmt) {
		this.broadbandBillAmt = broadbandBillAmt;
	}

	public BigDecimal getAvgFuelCost() {
		return avgFuelCost;
	}

	public void setAvgFuelCost(BigDecimal avgFuelCost) {
		this.avgFuelCost = avgFuelCost;
	}

	public BigDecimal getWaterBillAmt() {
		return waterBillAmt;
	}

	public void setWaterBillAmt(BigDecimal waterBillAmt) {
		this.waterBillAmt = waterBillAmt;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	@Column(name = "water_bill_amt")
	@JsonProperty("water_bill_amt")
	private BigDecimal waterBillAmt;

	@Column(name = "score")
	@JsonProperty("score")
	private BigDecimal score;

	public Expenses(Long id, BigDecimal otherExp, BigDecimal collegeFeesAmt, BigDecimal schoolFeesAmt, BigDecimal electricBillAmt, BigDecimal officeTransportationCost, BigDecimal cableNetBillAmt, BigDecimal broadbandBillAmt, BigDecimal avgFuelCost, Integer applicantId, BigDecimal waterBillAmt, BigDecimal score) {
		this.id = id;
		this.otherExp = otherExp;
		this.collegeFeesAmt = collegeFeesAmt;
		this.schoolFeesAmt = schoolFeesAmt;
		this.electricBillAmt = electricBillAmt;
		this.officeTransportationCost = officeTransportationCost;
		this.cableNetBillAmt = cableNetBillAmt;
		this.broadbandBillAmt = broadbandBillAmt;
		this.avgFuelCost = avgFuelCost;
		this.applicantId = applicantId;
		this.waterBillAmt = waterBillAmt;
		this.score = score;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
}
