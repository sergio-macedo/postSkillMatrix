package com.softwareone.skillMatrix.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate; // to replace org.threeten.bp.LocalDate
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Employee
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-26T10:17:25.614Z[GMT]")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("birthDate")
  private LocalDate birthDate = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("mobileNumber")
  private String mobileNumber = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("aboutMe")
  private String aboutMe = null;

  @JsonProperty("jobTitle")
  private String jobTitle = null;

  @JsonProperty("department")
  private String department = null;

  @JsonProperty("skills")
  @Valid
  private List<Skill> employeeSkills = new ArrayList<Skill>();

  @JsonProperty("languages")
  @Valid
  private List<Language> employeeLanguages = new ArrayList<Language>();

  public Employee id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Employee firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Employee lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Employee birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Employee email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Employee password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Employee mobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * @return mobileNumber
   **/
  @Schema(description = "")
  
    public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public Employee location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @Schema(description = "")
  
    public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Employee aboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
    return this;
  }

  /**
   * Get aboutMe
   * @return aboutMe
   **/
  @Schema(description = "")
  
    public String getAboutMe() {
    return aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

  public Employee jobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

  /**
   * Get jobTitle
   * @return jobTitle
   **/
  @Schema(description = "")
  
    public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public Employee department(String department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * @return department
   **/
  @Schema(description = "")
  
    public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Employee employeeSkills(List<Skill> employeeSkills) {
    this.employeeSkills = employeeSkills;
    return this;
  }
//TODO use this function.

  public Employee addSkill(Skill employeeSkillItem) {
    this.employeeSkills.add(employeeSkillItem);
    return this;
  }

  public Employee removeSkill(String skillId) {
    Optional<Skill> skillRemove = this.employeeSkills.stream().filter(skil -> skil.getId().equals(skillId)).findFirst();
    this.employeeSkills.remove(skillRemove.get());
    return this;
  }

  /**
   * Get employeeSkills
   * @return employeeSkills
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Skill> getEmployeeSkills() {

    return employeeSkills;
  }

  public void setEmployeeSkills(List<Skill> employeeSkills) {
    this.employeeSkills = employeeSkills;
  }

  public Employee employeeLanguages(List<Language> employeeLanguages) {
    this.employeeLanguages = employeeLanguages;
    return this;
  }

  public Employee addEmployeeLanguagesItem(Language employeeLanguageItem) {
    this.employeeLanguages.add(employeeLanguageItem);
    return this;
  }

  public Employee removeEmployeeLanguageItem(String languageId) {
    Optional<Language> languageRemove = this.employeeLanguages.stream().filter(language -> language.getId().equals(languageId)).findFirst();
    this.employeeLanguages.remove(languageRemove.get());
    return this;
  }

  /**
   * Get employeeLanguages
   * @return employeeLanguages
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<Language> getEmployeeLanguages() {
    return employeeLanguages;
  }

  public void setEmployeeLanguages(List<Language> employeeLanguages) {
    this.employeeLanguages = employeeLanguages;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) &&
        Objects.equals(this.firstName, employee.firstName) &&
        Objects.equals(this.lastName, employee.lastName) &&
        Objects.equals(this.birthDate, employee.birthDate) &&
        Objects.equals(this.email, employee.email) &&
        Objects.equals(this.password, employee.password) &&
        Objects.equals(this.mobileNumber, employee.mobileNumber) &&
        Objects.equals(this.location, employee.location) &&
        Objects.equals(this.aboutMe, employee.aboutMe) &&
        Objects.equals(this.jobTitle, employee.jobTitle) &&
        Objects.equals(this.department, employee.department) &&
        Objects.equals(this.employeeSkills, employee.employeeSkills) &&
        Objects.equals(this.employeeLanguages, employee.employeeLanguages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, birthDate, email, password, mobileNumber, location, aboutMe, jobTitle, department, employeeSkills, employeeLanguages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    aboutMe: ").append(toIndentedString(aboutMe)).append("\n");
    sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    employeeSkills: ").append(toIndentedString(employeeSkills)).append("\n");
    sb.append("    employeeLanguages: ").append(toIndentedString(employeeLanguages)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}
