package com.softwareone.skillMatrix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Skills
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-26T10:17:25.614Z[GMT]")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Skill {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("skillName")
  private String skillName = null;

  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    SOFT_SKILLS("soft skills"),
    
    HARD_SKILLS("hard skills");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("category")
  private CategoryEnum category = null;

  /**
   * Gets or Sets proficiency
   */
  public enum ProficiencyEnum {
    BEGINNER("beginner"),
    
    INTERMEDIATE("intermediate"),
    
    EXPERT("expert");

    private String value;

    ProficiencyEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProficiencyEnum fromValue(String text) {
      for (ProficiencyEnum b : ProficiencyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("proficiency")
  private ProficiencyEnum proficiency = null;

  public Skill id(String id) {
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

  public Skill skillName(String skillName) {
    this.skillName = skillName;
    return this;
  }

  /**
   * Get skillName
   * @return skillName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getSkillName() {
    return skillName;
  }

  public void setSkillName(String skillName) {
    this.skillName = skillName;
  }

  public Skill category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @Schema(required = true, description = "")
      @NotNull



  public Skill proficiency(ProficiencyEnum proficiency) {
    this.proficiency = proficiency;
    return this;
  }

  /**
   * Get proficiency
   * @return proficiency
   **/
  @Schema(required = true, description = "")
      @NotNull

    public ProficiencyEnum getProficiency() {
    return proficiency;
  }

  public void setProficiency() {
    this.proficiency = proficiency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Skill skill = (Skill) o;
    return Objects.equals(this.id, skill.id) &&
        Objects.equals(this.skillName, skill.skillName) &&
        Objects.equals(this.category, skill.category) &&
        Objects.equals(this.proficiency, skill.proficiency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, skillName, category, proficiency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Skills {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    skillName: ").append(toIndentedString(skillName)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    proficiency: ").append(toIndentedString(proficiency)).append("\n");
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
