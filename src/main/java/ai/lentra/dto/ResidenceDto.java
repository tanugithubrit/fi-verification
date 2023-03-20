package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.id.IntegralDataTypeHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResidenceDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("residence_category")
    private Integer residenceCategory;


    @JsonProperty("ownership_type")
    private Integer ownershipType;

    @JsonProperty("property_age")
    private Integer propertyAge;

    @JsonProperty("living_with")
    private String livingWIth;

    @JsonProperty("residence_type")
    private Integer residenceType;

    @JsonProperty("no_of_storey")
    private Integer noOfStorey;

    @JsonProperty("classification")
    private Integer classification;

    @JsonProperty("house_condition")
    private Integer houseCondition;

    @JsonProperty("property_make_type")
    private Integer propertyMAkeType;

    @JsonProperty("property_interior")
    private Integer propertyInterior;

    @JsonProperty("name_plate_visible")
    private boolean namePlateVisible;

    @JsonProperty("appliances")
    private Integer appliances;

    @JsonProperty("appliances_total_value")
    private BigDecimal appliancesTotalValue;

    @JsonProperty("commute_options")
    private Integer commuteOptions;

    @JsonProperty("neighbourhood_type")
    private Integer neighbourhoodType;

    @JsonProperty("community_dominated")
    private boolean communityDominated;

    @JsonProperty("residency")
    private Integer residency;

    @JsonProperty("country")
    private Integer country;

    @JsonProperty("years_of_stay")
    private BigDecimal yearsOfStay;

    @JsonProperty("months_of_stay")
    private BigDecimal monthsOfStay;

    @JsonProperty("distance_from_address_to_actual_loaction")
    private BigDecimal distanceFromAddressToActualLoaction;

    @JsonProperty("negative_location")
    private boolean negativeLocation;
    @JsonProperty("monthly_amortization")
    private BigDecimal monthlyAmortization;

    @JsonProperty("rent_per_month")
    private BigDecimal rentPerMonth;

    @JsonProperty("landline_num")
    private BigDecimal landlineNum;

    @JsonProperty("address_line_1")
    private String addressLine1;

    @JsonProperty("address_line_2")
    private String addressLine2;
    @JsonProperty("address_line_3")
    private String addressLine3;
    @JsonProperty("address_line_4")
    private String addressLine4;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("pincode")
    private String pincode;

    @JsonProperty("country_code")
    private BigDecimal country_code;

    @JsonProperty("lattitue")
    private BigDecimal lattitue;

    @JsonProperty("longitude")
    private BigDecimal longitude;

    @JsonProperty("mail_delivery_status")
    private boolean mailDeliveryStatus;

    @JsonProperty("address_proof_id")
    private Integer addressProofId;

    @JsonProperty("owned_by")
    private String ownedBy;

    @JsonProperty("mortagagor_name")
    private String mortagagorName;

    @JsonProperty("rented_from")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")

    private Date rentedFrom;


    @JsonProperty("residence_landmark")
    private String residenceLandmark;

    @JsonProperty("applicant_id")
    private Integer applicant_id;

    @JsonProperty("pers_met")
    private String persMet;

    public Long getId() {
        return id;
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

    public Integer getPropertyAge() {
        return propertyAge;
    }

    public void setPropertyAge(Integer propertyAge) {
        this.propertyAge = propertyAge;
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

    public BigDecimal getYearsOfStay() {
        return yearsOfStay;
    }

    public void setYearsOfStay(BigDecimal yearsOfStay) {
        this.yearsOfStay = yearsOfStay;
    }

    public BigDecimal getMonthsOfStay() {
        return monthsOfStay;
    }

    public void setMonthsOfStay(BigDecimal monthsOfStay) {
        this.monthsOfStay = monthsOfStay;
    }

    public BigDecimal getDistanceFromAddressToActualLoaction() {
        return distanceFromAddressToActualLoaction;
    }

    public void setDistanceFromAddressToActualLoaction(BigDecimal distanceFromAddressToActualLoaction) {
        this.distanceFromAddressToActualLoaction = distanceFromAddressToActualLoaction;
    }

    public boolean isNegativeLocation() {
        return negativeLocation;
    }

    public void setNegativeLocation(boolean negativeLocation) {
        this.negativeLocation = negativeLocation;
    }

    public BigDecimal getMonthlyAmortization() {
        return monthlyAmortization;
    }

    public void setMonthlyAmortization(BigDecimal monthlyAmortization) {
        this.monthlyAmortization = monthlyAmortization;
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

    public BigDecimal getCountry_code() {
        return country_code;
    }

    public void setCountry_code(BigDecimal country_code) {
        this.country_code = country_code;
    }

    public BigDecimal getLattitue() {
        return lattitue;
    }

    public void setLattitue(BigDecimal lattitue) {
        this.lattitue = lattitue;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
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

    public Integer getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(Integer applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getPersMet() {
        return persMet;
    }

    public void setPersMet(String persMet) {
        this.persMet = persMet;
    }
}
