package just.hibernate.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
      
	  private EntityManagerFactory entityManagerFactory;
	
	  public void setUpFactory() {
	            entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
	    }

	    public void tearDownFactory(){
	        entityManagerFactory.close();
	    }

	    public void persistRecipes(Recipe[] recipes) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	        for(Recipe recipe :recipes) {
		        entityManager.persist(recipe);
	        }
	        entityManager.getTransaction().commit();
	        entityManager.close();
	    }
	    
	    
	    public void getPersistedRecipes() {
	    	EntityManager entityManager = entityManagerFactory.createEntityManager();
	        entityManager = entityManagerFactory.createEntityManager();
	        entityManager.getTransaction().begin();
	        List<Recipe> result = entityManager.createQuery( "from Recipe", Recipe.class ).getResultList();
	        for ( Recipe recipe : result ) {
	            System.out.println(recipe.getName() + " "+ recipe.getIngredients()[0] + " " + recipe.getIngredients()[1]);
	        }
	        entityManager.getTransaction().commit();
	        entityManager.close();
	    }
	
	
}
