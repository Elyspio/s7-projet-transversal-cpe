package project.grp3.simulator.core.database.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import project.grp3.simulator.config.NetworkConfig;

import javax.persistence.EntityManager;
import java.util.List;

abstract public class Repository<Entity>
{


    private static final StandardServiceRegistry registry = null;
    protected static EntityManager manager = null;
    protected static Session session = null;
    private final Class<Entity> entity;

    protected Repository(Class<Entity> cls)
    {
        this.entity = cls;
        if (registry == null || manager == null)
        {
            init();
        }
    }

    private static void init()
    {

        try
        {
            /**Load the hibernate.cfg.xml from the classpath**/
            Configuration cfg = new Configuration();
            cfg.configure();
            var config = NetworkConfig.getInstance().getDatabase();
            cfg.setProperty("hibernate.connection.url", config.toString());
            cfg.setProperty("hibernate.connection.username", config.getUser());
            cfg.setProperty("hibernate.connection.password", config.getPassword());


            SessionFactory sessionFactory = cfg.buildSessionFactory();


            session = sessionFactory.openSession();
            manager = sessionFactory.createEntityManager();
        }
        catch (Exception e)
        {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected static EntityManager getManager()
    {
        return manager;
    }

    public void close()
    {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    public List<Entity> getAll()
    {
        var cq = manager.getCriteriaBuilder().createQuery(entity);
        var all = cq.select(cq.from(entity));
        return manager.createQuery(cq).getResultList();
    }

    public Entity getById(Long id)
    {
        return manager.find(entity, id);
    }

    public Entity update(Entity item)
    {
        var trans = session.beginTransaction();
        Entity item2 = (Entity) session.merge(item);
        trans.commit();
        return item2;
    }

    public void delete(Entity item)
    {
        var trans = session.beginTransaction();
        session.delete(item);
        trans.commit();
    }

    public Entity create(Entity item)
    {
        var trans = session.beginTransaction();
        var id = session.save(item);
        trans.commit();
        return this.getById((Long) id);
    }

    protected Entity get(Object primaryKey)
    {
        return manager.find(entity, primaryKey);
    }
}
