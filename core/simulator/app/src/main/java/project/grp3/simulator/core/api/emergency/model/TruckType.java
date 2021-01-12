/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package project.grp3.simulator.core.api.emergency.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import project.grp3.simulator.core.api.emergency.model.FireType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * TruckType
 */


public class TruckType {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("label")
  private String label = null;

  @SerializedName("capacity")
  private Integer capacity = null;

  @SerializedName("volume")
  private Float volume = null;

  @SerializedName("speed")
  private Float speed = null;

  @SerializedName("fireTypes")
  private List<FireType> fireTypes = null;

  public TruckType id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TruckType label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @Schema(description = "")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public TruckType capacity(Integer capacity) {
    this.capacity = capacity;
    return this;
  }

   /**
   * Get capacity
   * @return capacity
  **/
  @Schema(description = "")
  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public TruckType volume(Float volume) {
    this.volume = volume;
    return this;
  }

   /**
   * Get volume
   * @return volume
  **/
  @Schema(description = "")
  public Float getVolume() {
    return volume;
  }

  public void setVolume(Float volume) {
    this.volume = volume;
  }

  public TruckType speed(Float speed) {
    this.speed = speed;
    return this;
  }

   /**
   * Get speed
   * @return speed
  **/
  @Schema(description = "")
  public Float getSpeed() {
    return speed;
  }

  public void setSpeed(Float speed) {
    this.speed = speed;
  }

  public TruckType fireTypes(List<FireType> fireTypes) {
    this.fireTypes = fireTypes;
    return this;
  }

  public TruckType addFireTypesItem(FireType fireTypesItem) {
    if (this.fireTypes == null) {
      this.fireTypes = new ArrayList<>();
    }
    this.fireTypes.add(fireTypesItem);
    return this;
  }

   /**
   * Get fireTypes
   * @return fireTypes
  **/
  @Schema(description = "")
  public List<FireType> getFireTypes() {
    return fireTypes;
  }

  public void setFireTypes(List<FireType> fireTypes) {
    this.fireTypes = fireTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TruckType truckType = (TruckType) o;
    return Objects.equals(this.id, truckType.id) &&
        Objects.equals(this.label, truckType.label) &&
        Objects.equals(this.capacity, truckType.capacity) &&
        Objects.equals(this.volume, truckType.volume) &&
        Objects.equals(this.speed, truckType.speed) &&
        Objects.equals(this.fireTypes, truckType.fireTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, label, capacity, volume, speed, fireTypes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TruckType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
    sb.append("    fireTypes: ").append(toIndentedString(fireTypes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}