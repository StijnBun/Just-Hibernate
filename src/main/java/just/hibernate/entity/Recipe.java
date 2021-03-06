package just.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RECIPES")
public class Recipe {	
    private Long id;
    private String name;
    private String[] ingredients;
	
    Recipe(){
    	
    }
    
	public Recipe(String name, String[] ingredients) {
		super();
		this.name = name;
		this.ingredients = ingredients;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
			this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}


    
}