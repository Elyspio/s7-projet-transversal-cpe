package project.grp3.simulator.web.data;


import java.util.List;

public class FireType
{

    private Long id;

    private String label;

    private String description;

    private List<Long> fireIds;

    private List<Long> sensors;

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
