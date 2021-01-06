package project.grp3.simulator.web.data;


import java.util.List;

public class FireType
{

    private final Long id;

    private final String label;

    private final String description;

    private final List<Long> fireIds;

    private final List<Long> sensors;

    public FireType(Long id, String label, String description, List<Long> fires, List<Long> sensors)
    {
        this.id = id;
        this.label = label;
        this.description = description;
        this.fireIds = fires;
        this.sensors = sensors;
    }

    public Long getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public String getDescription()
    {
        return description;
    }

    public List<Long> getFireIds()
    {
        return fireIds;
    }

    public List<Long> getSensors()
    {
        return sensors;
    }
}
