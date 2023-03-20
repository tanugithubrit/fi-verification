package ai.lentra.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@ToString
@Table(name = "commitment")
//@TypeDef(name = "JsonDataUserType", typeClass = JsonDataUserType.class)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Commitment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial", name = "commitmentId")
    @JsonProperty("commitmentId")
    private Integer commitmentId;
    @Column(name = "insurance_type")
    @JsonProperty("insurance_type")
    private String insurance_type;
    //@Pattern(regexp = " ^\\d+\\. \\d{3,13}$")
    @Column(name = "life_insurance_amt")
    @JsonProperty("life_insurance_amt")
    @Digits(integer=13,fraction=3)
    private String life_insurance_amt;
    //@Pattern(regexp = "^ ^\\d+\\. \\d{1,3}$")
    @Column(name = "life_insurance_duration")
    @JsonProperty("life_insurance_duration" )
    @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
   // @Digits(integer=3,fraction=1)
    private String life_insurance_duration;
    //@Pattern(regexp = " ^\\d+\\. \\d{3,13}$")
    @Column(name = "car_insurance_amt")
    @JsonProperty("car_insurance_amt")
    @Digits(integer=13,fraction=3)
    private String  car_insurance_amt;
    //@Pattern(regexp = " ^\\d+\\. \\d{1,3}$")
    @Column(name = "car_insurance_duration")
    @JsonProperty("car_insurance_duration")
    @Digits(integer=3,fraction=1)
    private String car_insurance_duration;
    //@Pattern(regexp = " ^\\d+\\. \\d{3,13}$")
    @Column(name = "health_insurance_amt")
    @JsonProperty("health_insurance_amt")
    @Digits(integer=13,fraction=3)
    private String  health_insurance_amt;
    //@Pattern(regexp = " ^\\d+\\. \\d{1,3}$")
    @Column(name = "health_insurance_duration")
    @JsonProperty("health_insurance_duration")
    @Digits(integer=3,fraction=1)
    private String health_insurance_duration;
//    @Pattern(regexp = " ^\\d+\\. \\d{3,13}$")
    @Column(name = "twoWheeler_insurance_amt")
    @JsonProperty("twoWheeler_insurance_amt")
    @Digits(integer=13,fraction=3)
    private String twoWheeler_insurance_amt;
   // @Pattern(regexp = " ^\\d+\\. \\d{1,3}$")
    @Column(name = "twoWheeler_insurance_duration")
    @JsonProperty("twoWheeler_insurance_duration")
    @Digits(integer=3,fraction=1)
    private String twoWheeler_insurance_duration;
   // @Pattern(regexp = " ^\\d+\\. \\d{3,13}$")

    @Column(name = "home_insurance_amt")
    @JsonProperty("home_insurance_amt")
    @Digits(integer=13,fraction=3)
    private String  home_insurance_amt;
    //@Pattern(regexp = " ^\\d+\\. \\d{1,3}$")
    @Column(name = "home_insurance_duration")
    @JsonProperty("home_insurance_duration")
    @Digits(integer=3,fraction=1)
    private String home_insurance_duration;
    //@Pattern(regexp = " ^\\d+\\. \\d{3,13}$")
    @Column(name = "term_insurance_amt")
    @JsonProperty("term_insurance_amt")
    @Digits(integer=13,fraction=3)
    private String  term_insurance_amt;
    //@Pattern(regexp = " ^\\d+\\. \\d{1,3}$")
    @Column(name = "term_insurance_duration")
    @JsonProperty("term_insurance_duration")
    @Digits(integer=3,fraction=1)
    private String term_insurance_duration;
   // @Pattern(regexp = " ^\\d+\\. \\d{3,13}$")

    @Column(name = "loc_amt")
    @JsonProperty("loc_amt")
    @Digits(integer=13,fraction=3)
    private String  loc_amt;

    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",message = "date must be in the format of 'DD/MM/YYYY'")
    @Column(name = "loc_expiry_date")
    @JsonProperty("loc_expiry_date")
    private String loc_expiry_date;
    @Size(min=6, max=50, message=" nps_applicant_name should have 6-50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @Column(name = "nps_applicant_name")
    @JsonProperty("nps_applicant_name")
    private String nps_applicant_name;
   // @Pattern(regexp = " ^\\d+\\. \\d{6,50}$")

    @Column(name = "nps_amt")
    @JsonProperty("nps_amt")
    @Digits(integer=13,fraction=3)
    private String nps_amt;
//    @Pattern(regexp = " ^\\d+\\. \\d{3,13}$")
    @Column(name = "nps_duration")
//    @Pattern(regexp = "^ ^\\d+\\. \\d{1,3}$")
    @JsonProperty("nps_duration")
    @Digits(integer=3,fraction=1, message = "This field should be accept only 3 to 1 digits only not accepted characters")
    private String nps_duration;
   @Size(min=4, max=50, message=" bank_name_loc should have 4-50 characters")
   @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @Column(name = "bank_name_loc")
    @JsonProperty("bank_name_loc")
    private String bank_name_loc;


}
