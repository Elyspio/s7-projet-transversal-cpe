/*
 * Api documentation
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package project.grp3.simulator.core.api.truck.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * FiremanModel
 */


public class FiremanModel
{
    @SerializedName("id")
    private BigDecimal id = null;

    @SerializedName("fireTruckId")
    private BigDecimal fireTruckId = null;

    public FiremanModel id(BigDecimal id)
    {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @Schema(description = "")
    public BigDecimal getId()
    {
        return id;
    }

    public void setId(BigDecimal id)
    {
        this.id = id;
    }

    public FiremanModel fireTruckId(BigDecimal fireTruckId)
    {
        this.fireTruckId = fireTruckId;
        return this;
    }

    /**
     * Get fireTruckId
     *
     * @return fireTruckId
     **/
    @Schema(description = "")
    public BigDecimal getFireTruckId()
    {
        return fireTruckId;
    }

    public void setFireTruckId(BigDecimal fireTruckId)
    {
        this.fireTruckId = fireTruckId;
    }


    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        FiremanModel firemanModel = (FiremanModel) o;
        return Objects.equals(this.id, firemanModel.id) &&
                Objects.equals(this.fireTruckId, firemanModel.fireTruckId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, fireTruckId);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class FiremanModel {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    fireTruckId: ").append(toIndentedString(fireTruckId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}