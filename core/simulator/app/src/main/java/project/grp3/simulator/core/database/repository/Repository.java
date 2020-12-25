package project.grp3.simulator.core.database.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import java.util.List;

abstract public class Repository<Entity> {

    private static StandardServiceRegistry registry = null;
    private static EntityManager manager = null;
    private final Class<Entity> entity;

    private static void init() {
        registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            manager = sessionFactory.createEntityManager();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected Repository(Class<Entity> cls) {
        this.entity = cls;
        if (registry == null || manager == null) {
           init();
        }
    }

    protected static EntityManager getManager() {
        return manager;
    }

    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    protected List<Entity> getAll() {
        var cq = manager.getCriteriaBuilder().createQuery(entity);
        var all = cq.select(cq.from(entity));
        return manager.createQuery(all).getResultList();
    }

    protected Entity get(Object primaryKey) {
        return manager.find(entity, primaryKey);
    }

}