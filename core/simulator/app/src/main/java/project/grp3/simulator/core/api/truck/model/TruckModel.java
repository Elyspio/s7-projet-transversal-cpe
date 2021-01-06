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
 * TruckModel
 */


public class TruckModel
{
    @SerializedName("id")
    private BigDecimal id = null;

    @SerializedName("speed")
    private BigDecimal speed = null;

    @SerializedName("travelState")
    private BigDecimal travelState = null;

    public TruckModel id(BigDecimal id)
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

    public TruckModel speed(BigDecimal speed)
    {
        this.speed = speed;
        return this;
    }

    /**
     * Get speed
     *
     * @return speed
     **/
    @Schema(description = "")
    public BigDecimal getSpeed()
    {
        return speed;
    }

    public void setSpeed(BigDecimal speed)
    {
        this.speed = speed;
    }

    public TruckModel travelState(BigDecimal travelState)
    {
        this.travelState = travelState;
        return this;
    }

    /**
     * Get travelState
     *
     * @return travelState
     **/
    @Schema(description = "")
    public BigDecimal getTravelState()
    {
        return travelState;
    }

    public void setTravelState(BigDecimal travelState)
    {
        this.travelState = travelState;
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
        TruckModel truckModel = (TruckModel) o;
        return Objects.equals(this.id, truckModel.id) &&
                Objects.equals(this.speed, truckModel.speed) &&
                Objects.equals(this.travelState, truckModel.travelState);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, speed, travelState);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class TruckModel {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
        sb.append("    travelState: ").append(toIndentedString(travelState)).append("\n");
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