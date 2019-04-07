package just.hibernate.entity;

public class Application {


    public static void main(String[] args){
    	PersistenceManager manager = new PersistenceManager();
    	manager.setUpFactory();
    	manager.persistRecipes(new Recipe[] {new Recipe("recipe",new String[] {"ingredient1","ingredient2"})});
    	manager.getPersistedRecipes();
    	manager.tearDownFactory();
    }

  

}

