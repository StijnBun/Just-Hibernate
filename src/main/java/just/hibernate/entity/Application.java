package just.hibernate.entity;



import javax.persistence.*;
import java.util.List;


public class Application {
    private EntityManagerFactory entityManagerFactory;

    public static void main(String[] args){
    Application app = new Application();
    app.setUp();
    app.testBasicUsage(args);
    app.tearDown();
    }

    protected void setUp() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("just.hibernate.entity.jpa");
        }catch (PersistenceException e){
            System.out.println("Persisting went wrong");
        }
    }

    protected void tearDown(){
        entityManagerFactory.close();
    }

    public void testBasicUsage(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new Eenheid("test"));
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Eenheid> result = entityManager.createQuery( "from Eenheid", Eenheid.class ).getResultList();
        for ( Eenheid eenheid : result ) {
            System.out.println(eenheid.getEenheid());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

