package project.grp3.emergency.web.Entity;

import java.util.List;

public class Fireman
{

    private Long id;
    private String name;
    private String lastname;

    private Long exhaustLevelId;

    private List<Long> ressourcesIds;

    private Long barrackId;

    public Fireman(Long id, String name, String lastname, Long exhaustLevelId, List<Long> ressourcesIds, Long barrackId)
    {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.exhaustLevelId = exhaustLevelId;
        this.ressourcesIds = ressourcesIds;
        this.barrackId = barrackId;
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }


    public Long getBarrackId()
    {
        return barrackId;
    }

    public void setBarrackId(Long barrackId)
    {
        this.barrackId = barrackId;
    }

    public Long getExhaustLevelId()
    {
        return exhaustLevelId;
    }

    public void setExhaustLevelId(Long exhaustLevelId)
    {
        this.exhaustLevelId = exhaustLevelId;
    }

    public List<Long> getRessourcesIds()
    {
        return ressourcesIds;
    }

    public void setRessourcesIds(List<Long> ressourcesIds)
    {
        this.ressourcesIds = ressourcesIds;
    }


}
