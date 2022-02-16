package com.softwareone.skillMatrix.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Languages
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-11-26T10:17:25.614Z[GMT]")


public class Language {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("languageName")
  private String languageName = null;

  /**
   * Gets or Sets level
   */
  public enum LevelEnum {
    BEGINNER("beginner"),
    
    INTERMEDIATE("intermediate"),
    
    EXPERT("expert");

    private String value;

    LevelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LevelEnum fromValue(String text) {
      for (LevelEnum b : LevelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("level")
  private LevelEnum level = null;

  public Language id(String id) {
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

  public Language languageName(String languageName) {
    this.languageName = languageName;
    return this;
  }

  /**
   * Get languageName
   * @return languageName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getLanguageName() {
    return languageName;
  }

  public void setLanguageName(String languageName) {
    this.languageName = languageName;
  }

  public Language level(LevelEnum level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
   **/
  @Schema(required = true, description = "")
      @NotNull

    public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Language language = (Language) o;
    return Objects.equals(this.id, language.id) &&
        Objects.equals(this.languageName, language.languageName) &&
        Objects.equals(this.level, language.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, languageName, level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Languages {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    languageName: ").append(toIndentedString(languageName)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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
