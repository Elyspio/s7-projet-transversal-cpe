package project.grp3.simulator.web.data;


import java.util.Date;

public class Fire
{

    private final Long id;
    private final Date detectionDate;
    private final Date endDate;
    private final Integer typeId;
    private final Integer sensorId;

    public Fire(Long id, Date detectionDate, Date endDate, Integer typeId, Integer sensorId)
    {
        this.id = id;
        this.detectionDate = detectionDate;
        this.endDate = endDate;
        this.typeId = typeId;
        this.sensorId = sensorId;
    }

    public Long getId()
    {
        return id;
    }

    public Date getDetectionDate()
    {
        return detectionDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public Integer getTypeId()
    {
        return typeId;
    }

    public Integer getSensorId()
    {
        return sensorId;
    }
}
