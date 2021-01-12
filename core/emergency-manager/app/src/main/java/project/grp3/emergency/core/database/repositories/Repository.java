package project.grp3.emergency.core.database.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import project.grp3.emergency.config.NetworkConfig;

import javax.persistence.EntityManager;
import java.util.List;

abstract public class Repository<Entity>
{

    private final Class<Entity> entity;

    protected Repository(Class<Entity> cls)
    {
        this.entity = cls;
    }

    protected static EntityManager getManager()
    {
        return DbAccess.manager;
    }

    public static void close()
    {
        DbAccess.manager.close();
        DbAccess.session.close();
    }

    public List<Entity> getAll()
    {
        var cq = DbAccess.manager.getCriteriaBuilder().createQuery(entity);
        var all = cq.select(cq.from(entity));
        return DbAccess.manager.createQuery(cq).getResultList();
    }

    protected Entity getById(Long id)
    {
        return DbAccess.manager.find(entity, id);
    }

    protected Entity update(Entity item)
    {
        var trans = DbAccess.session.beginTransaction();
        Entity item2 = (Entity) DbAccess.session.merge(item);
        trans.commit();
        return item2;
    }

    public Entity create(Entity item)
    {
        var trans = DbAccess.session.beginTransaction();
        var id = DbAccess.session.save(item);
        trans.commit();
        return this.getById((Long) id);
    }

    protected Entity get(Object primaryKey)
    {
        return DbAccess.manager.find(entity, primaryKey);
    }

    public static class DbAccess
    {
        protected volatile static EntityManager manager = null;
        protected volatile static Session session = null;

        public static void init()
        {
            /* Load the hibernate.cfg.xml from the classpath */
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

    }

}
