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

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * FireTruck
 */


public class FireTruck
{
    @SerializedName("barrackId")
    private Long barrackId = null;

    @SerializedName("type")
    private TruckType type = null;

    @SerializedName("id")
    private Long id = null;

    public FireTruck barrackId(Long barrackId)
    {
        this.barrackId = barrackId;
        return this;
    }

    /**
     * Get barrackId
     *
     * @return barrackId
     **/
    @Schema(description = "")
    public Long getBarrackId()
    {
        return barrackId;
    }

    public void setBarrackId(Long barrackId)
    {
        this.barrackId = barrackId;
    }

    public FireTruck type(TruckType type)
    {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @Schema(description = "")
    public TruckType getType()
    {
        return type;
    }

    public void setType(TruckType type)
    {
        this.type = type;
    }

    public FireTruck id(Long id)
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
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
        FireTruck fireTruck = (FireTruck) o;
        return Objects.equals(this.barrackId, fireTruck.barrackId) &&
                Objects.equals(this.type, fireTruck.type) &&
                Objects.equals(this.id, fireTruck.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(barrackId, type, id);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class FireTruck {\n");

        sb.append("    barrackId: ").append(toIndentedString(barrackId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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