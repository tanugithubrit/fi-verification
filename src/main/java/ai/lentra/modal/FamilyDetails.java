package ai.lentra.modal;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString

@Table(name = "Family_Details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FamilyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "serial", name = "familyDetailsId")
   @JsonProperty("familyDetailsId")
    private Integer familyDetailsId;
    @Pattern(regexp = "^\\d{1,2}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 2 digits not accepted characters")
  @Column(name = "no_of_dependants")
   @JsonProperty("no_of_dependants")
    private String no_of_dependants;
    @Pattern(regexp = "^\\d{1,2}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 2 digits not accepted characters")
   @Column(name = "no_of_minor")
   @JsonProperty("no_of_minor")
    private String no_of_minor;
   @Column(name = "child_educational_level")
   @JsonProperty("child_educational_level")
    private String child_educational_level;
    @NotNull @Min(18) @Max(100)
    @DateTimeFormat(pattern="MM/dd/yyyy")
   @Column(name = "spouse_age")
    @JsonProperty("spouse_age")
    private Integer spouse_age;
    @NotNull @Min(18) @Max(100)
    @DateTimeFormat(pattern="MM/dd/yyyy")
   @Column(name = "father_age")
   @JsonProperty("father_age")
    private Integer father_age;
   @NotNull @Min(18) @Max(100)
  @DateTimeFormat(pattern="MM/dd/yyyy")
    @Column(name = "mother_age")
   @JsonProperty("mother_age")
    private Integer mother_age;
@Column(name = "spouse_citizenship")
  @JsonProperty("spouse_citizenship")
    private String spouse_citizenship;
   @Column(name = "entity_confirmation_spouse")
  @JsonProperty("entity_confirmation_spouse")
    private boolean entity_confirmation_spouse;
   @Column(name = "spouse_working")
   @JsonProperty("spouse_working")
    private boolean spouse_working;
  @Column(name = "spouse_occupation")
   @JsonProperty("spouse_occupation")
    private String spouse_occupation;
  @Column(name = "entity_confirmation_father")
  @JsonProperty("entity_confirmation_father")
    private boolean entity_confirmation_father;
  @Column(name = "entity_confirmation_mother")
   @JsonProperty("entity_confirmation_mother")
    private boolean entity_confirmation_mother;
  //@NotNull
  @Size(min=3, max=50, message=" spouse_last_name should have atleast 50 characters")
  @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "spouse_last_name")
   @JsonProperty("spouse_last_name")
    private String spouse_last_name;
   //@NotNull
   @Size(min=3, max=50, message=" spouse_first_name should have atleast 50 characters")
   @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")

   @Column(name = "spouse_first_name")
   @JsonProperty("spouse_first_name")
    private String spouse_first_name;
  //@NotNull
  @Size(min=1, max=50, message=" spouse_mid_name should have atleast 50 characters")
  @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")

   @Column(name = "spouse_mid_name")
    @JsonProperty("spouse_mid_name")
    private String spouse_mid_name;
  //@NotNull
  @Size(min=2, max=10, message=" spouse_suffix should have atleast 10 characters")
  @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @Column(name = "spouse_suffix")
   @JsonProperty("spouse_suffix")
    private String spouse_suffix;
   //@NotNull
   @Size(min=2, max=50, message=" spouse_alias should have atleast 50 characters")
   @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "spouse_alias")
  @JsonProperty("spouse_alias")
    private String spouse_alias;
    //@NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
   @Column(name = "spouse_birth_date")
  @JsonProperty("spouse_birth_date")
    private Date spouse_birth_date;
    //@NotNull
    @Size(min=4, max=10, message=" spouse_religion should have atleast 10 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @Column(name = "spouse_religion")
   @JsonProperty("spouse_religion")
    private String spouse_religion;
   // @NotNull
    @Size(min=3, max=50, message=" Fathers_first_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "Fathers_first_name")
   @JsonProperty("Fathers_first_name")
    private String Fathers_first_name;
   // @NotNull
    @Size(min=1, max=50, message=" Fathers_middle_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "Fathers_middle_name")
    @JsonProperty("Fathers_middle_name")
    private  String Fathers_middle_name;
    //@NotNull
    @Size(min=3, max=50, message=" Fathers_last_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "Fathers_last_name")
    @JsonProperty("Fathers_last_name")
    private  String Fathers_last_name;
   // @NotNull
    //@Pattern(regexp = "^[a-zA-Z]")
    @Size(min=4, max=10, message=" father_religion should have atleast 10 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
  @Column(name = "father_religion")
   @JsonProperty("father_religion")
    private  String father_religion;
    //@NotNull
    @Size(min=3, max=50, message=" Mothers_first_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "Mothers_first_name")
  @JsonProperty("Mothers_first_name")
    private String Mothers_first_name;
   // @NotNull
    @Size(min=1, max=50, message=" Mothers_middle_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "Mothers_middle_name")
   @JsonProperty("Mothers_middle_name")
    private  String Mothers_middle_name;
   // @NotNull
    @Size(min=3, max=50, message=" Mothers_last_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
  @Column(name = "Mothers_last_name")
    @JsonProperty("Mothers_last_name")
    private String Mothers_last_name;
//    @NotNull
   @Size(min=4, max=10, message=" mother_religion should have atleast 10 characters")
@Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
   @Column(name = "mother_religion")
   @JsonProperty("mother_religion")
    private  String mother_religion;


}
