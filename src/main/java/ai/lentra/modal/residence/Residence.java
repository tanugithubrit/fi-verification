package ai.lentra.modal.residence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "residence_fi")
//@TypeDef(name = "JsonDataUserType", typeClass = JsonDataUserType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Residence {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;

	@Column(name = "residence_category")
	@JsonProperty("residence_category")
	private Integer residenceCategory;

	@Column(name = "ownership_type")
	@JsonProperty("ownership_type")
	private Integer ownershipType;

	@Column(name = "living_with")
	@JsonProperty("living_with")
	private String livingWIth;

	@Column(name = "residence_type")
	@JsonProperty("residence_type")
	private Integer residenceType;

	@Column(name = "no_of_storey")
	@JsonProperty("no_of_storey")
	private Integer noOfStorey;

	@Column(name = "classification")
	@JsonProperty("classification")
	private Integer classification;

	@Column(name = "house_condition")
	@JsonProperty("house_condition")
	private Integer houseCondition;

	@Column(name = "property_make_type")
	@JsonProperty("property_make_type")
	private Integer propertyMAkeType;

	@Column(name = "property_interior")
	@JsonProperty("property_interior")
	private Integer propertyInterior;

	@Column(name = "name_plate_visible")
	@JsonProperty("name_plate_visible")
	private boolean namePlateVisible;

	@Column(name = "appliances")
	@JsonProperty("appliances")
	private Integer appliances;

	@Column(name = "appliances_total_value")
	@JsonProperty("appliances_total_value")
	private BigDecimal appliancesTotalValue;

	@Column(name = "commute_options")
	@JsonProperty("commute_options")
	private Integer commuteOptions;

	@Column(name = "neighbourhood_type")
	@JsonProperty("neighbourhood_type")
	private Integer neighbourhoodType;

	@Column(name = "community_dominated")
	@JsonProperty("community_dominated")
	private boolean communityDominated;

	@Column(name = "residency")
	@JsonProperty("residency")
	private Integer residency;

	@Column(name = "country")
	@JsonProperty("country")
	private Integer country;

	@Column(name = "years_of_stay")
	@JsonProperty("years_of_stay")
	private Integer yearsOfStay;

	@Column(name = "months_of_stay")
	@JsonProperty("months_of_stay")
	private Integer monthsOfStay;

	@Column(name = "distance_from_address_to_actual_loaction")
	@JsonProperty("distance_from_address_to_actual_loaction")
	private Integer distanceFromAddressToActualLoaction;

	@Column(name = "negative_location")
	@JsonProperty("negative_location")
	private boolean negativeLocation;
	@Column(name = "monthly_amortization")
	@JsonProperty("monthly_amortization")
	private BigDecimal monthlyAmortization;

	@Column(name = "rent_per_month")
	@JsonProperty("rent_per_month")
	private BigDecimal rentPerMonth;

	@Column(name = "landline_num")
	@JsonProperty("landline_num")
	private BigDecimal landlineNum;

	@Column(name = "address_line_1")
	@JsonProperty("address_line_1")
	private String addressLine1;

	@Column(name = "address_line_2")
	@JsonProperty("address_line_2")
	private String addressLine2;
	@Column(name = "address_line_3")
	@JsonProperty("address_line_3")
	private String addressLine3;
	@Column(name = "address_line_4")
	@JsonProperty("address_line_4")
	private String addressLine4;

	@Column(name = "city")
	@JsonProperty("city")
	private String city;

	@Column(name = "state")
	@JsonProperty("state")
	private String state;

	@Column(name = "pincode")
	@JsonProperty("pincode")
	private String pincode;

	@Column(name = "country_code")
	@JsonProperty("country_code")
	private Integer country_code;

	@Column(name = "lattitue")
	@JsonProperty("lattitue")
	private Integer lattitue;

	@Column(name = "longitude")
	@JsonProperty("longitude")
	private Integer longitude;

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	@Column(name = "mail_delivery_status")
	@JsonProperty("mail_delivery_status")
	private boolean mailDeliveryStatus;

	@Column(name = "address_proof_id")
	@JsonProperty("address_proof_id")
	private Integer addressProofId;

	@Column(name = "property_age")
	@JsonProperty("property_age")
	private Integer propertyAge;

	@Column(name = "owned_by")
	@JsonProperty("owned_by")
	private String ownedBy;

	@Column(name = "mortagagor_name")
	@JsonProperty("mortagagor_name")
	private String mortagagorName;

	@Column(name = "rented_from")
	@JsonProperty("rented_from")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

	private Date rentedFrom;

	@Column(name = "residence_landmark")
	@JsonProperty("residence_landmark")
	private String residenceLandmark;

	@Column(name = "pers_met")
	@JsonProperty("pers_met")
	private String persMet;

	@Column(name = "score")
	@JsonProperty("score")
	private BigDecimal score;

	@Column(name = "applicant_id")
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

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getResidenceCategory() {
		return residenceCategory;
	}

	public void setResidenceCategory(Integer residenceCategory) {
		this.residenceCategory = residenceCategory;
	}

	public Integer getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(Integer ownershipType) {
		this.ownershipType = ownershipType;
	}

	public String getLivingWIth() {
		return livingWIth;
	}

	public void setLivingWIth(String livingWIth) {
		this.livingWIth = livingWIth;
	}

	public Integer getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(Integer residenceType) {
		this.residenceType = residenceType;
	}

	public Integer getNoOfStorey() {
		return noOfStorey;
	}

	public void setNoOfStorey(Integer noOfStorey) {
		this.noOfStorey = noOfStorey;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public Integer getHouseCondition() {
		return houseCondition;
	}

	public void setHouseCondition(Integer houseCondition) {
		this.houseCondition = houseCondition;
	}

	public Integer getPropertyMAkeType() {
		return propertyMAkeType;
	}

	public void setPropertyMAkeType(Integer propertyMAkeType) {
		this.propertyMAkeType = propertyMAkeType;
	}

	public Integer getPropertyInterior() {
		return propertyInterior;
	}

	public void setPropertyInterior(Integer propertyInterior) {
		this.propertyInterior = propertyInterior;
	}

	public boolean isNamePlateVisible() {
		return namePlateVisible;
	}

	public void setNamePlateVisible(boolean namePlateVisible) {
		this.namePlateVisible = namePlateVisible;
	}

	public Integer getAppliances() {
		return appliances;
	}

	public void setAppliances(Integer appliances) {
		this.appliances = appliances;
	}

	public BigDecimal getAppliancesTotalValue() {
		return appliancesTotalValue;
	}

	public void setAppliancesTotalValue(BigDecimal appliancesTotalValue) {
		this.appliancesTotalValue = appliancesTotalValue;
	}

	public BigDecimal getMonthlyAmortization() {
		return monthlyAmortization;
	}

	public void setMonthlyAmortization(BigDecimal monthlyAmortization) {
		this.monthlyAmortization = monthlyAmortization;
	}

	public Integer getCommuteOptions() {
		return commuteOptions;
	}

	public void setCommuteOptions(Integer commuteOptions) {
		this.commuteOptions = commuteOptions;
	}

	public Integer getNeighbourhoodType() {
		return neighbourhoodType;
	}

	public void setNeighbourhoodType(Integer neighbourhoodType) {
		this.neighbourhoodType = neighbourhoodType;
	}

	public boolean isCommunityDominated() {
		return communityDominated;
	}

	public void setCommunityDominated(boolean communityDominated) {
		this.communityDominated = communityDominated;
	}

	public Integer getResidency() {
		return residency;
	}

	public void setResidency(Integer residency) {
		this.residency = residency;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getYearsOfStay() {
		return yearsOfStay;
	}

	public void setYearsOfStay(Integer yearsOfStay) {
		this.yearsOfStay = yearsOfStay;
	}

	public Integer getMonthsOfStay() {
		return monthsOfStay;
	}

	public Integer getPropertyAge() {
		return propertyAge;
	}

	public void setPropertyAge(Integer propertyAge) {
		this.propertyAge = propertyAge;
	}

	public void setMonthsOfStay(Integer monthsOfStay) {
		this.monthsOfStay = monthsOfStay;
	}

	public Integer getDistanceFromAddressToActualLoaction() {
		return distanceFromAddressToActualLoaction;
	}

	public void setDistanceFromAddressToActualLoaction(Integer distanceFromAddressToActualLoaction) {
		this.distanceFromAddressToActualLoaction = distanceFromAddressToActualLoaction;
	}

	public boolean isNegativeLocation() {
		return negativeLocation;
	}

	public void setNegativeLocation(boolean negativeLocation) {
		this.negativeLocation = negativeLocation;
	}


	public BigDecimal getRentPerMonth() {
		return rentPerMonth;
	}

	public void setRentPerMonth(BigDecimal rentPerMonth) {
		this.rentPerMonth = rentPerMonth;
	}

	public BigDecimal getLandlineNum() {
		return landlineNum;
	}

	public void setLandlineNum(BigDecimal landlineNum) {
		this.landlineNum = landlineNum;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Integer getCountry_code() {
		return country_code;
	}

	public void setCountry_code(Integer country_code) {
		this.country_code = country_code;
	}

	public Integer getLattitue() {
		return lattitue;
	}

	public void setLattitue(Integer lattitue) {
		this.lattitue = lattitue;
	}

	public boolean isMailDeliveryStatus() {
		return mailDeliveryStatus;
	}

	public void setMailDeliveryStatus(boolean mailDeliveryStatus) {
		this.mailDeliveryStatus = mailDeliveryStatus;
	}

	public Integer getAddressProofId() {
		return addressProofId;
	}

	public void setAddressProofId(Integer addressProofId) {
		this.addressProofId = addressProofId;
	}

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}

	public String getMortagagorName() {
		return mortagagorName;
	}

	public void setMortagagorName(String mortagagorName) {
		this.mortagagorName = mortagagorName;
	}

	public Date getRentedFrom() {
		return rentedFrom;
	}

	public void setRentedFrom(Date rentedFrom) {
		this.rentedFrom = rentedFrom;
	}

	public String getResidenceLandmark() {
		return residenceLandmark;
	}

	public void setResidenceLandmark(String residenceLandmark) {

		this.residenceLandmark = residenceLandmark;
	}

	public String getPersMet() {

		return persMet;
	}

	public void setPersMet(String persMet) {

		this.persMet = persMet;
	}
}
