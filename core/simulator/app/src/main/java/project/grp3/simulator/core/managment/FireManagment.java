package project.grp3.simulator.core.managment;

import project.grp3.simulator.core.services.Services;

public class FireManagment implements IManagment
{
    @Override
    public void doTurn()
    {
        var fires = Services.fire.getActiveFire();
        System.out.println("There is " + fires.size() + " fire actives");
        for (var fire : fires)
        {
            Long newIntensity = Services.fire.getNewFireIntencity(fire);
            Services.fire.changeFireIntensity(
                    fire,
                    newIntensity
            );
        }

        if (fires.size() == 0)
        {
            Services.fire.createRandomFire();
        }


    }
}
