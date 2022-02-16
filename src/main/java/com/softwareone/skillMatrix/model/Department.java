package com.softwareone.skillMatrix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Departments
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-26T10:17:25.614Z[GMT]")


public class Department {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("department")
  private String department = null;

  public Department id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Department department(String department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * @return department
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Department department = (Department) o;
    return Objects.equals(this.id, department.id) &&
        Objects.equals(this.department, department.department);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, department);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Departments {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
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
