package pl.lodz.uni.math.dao.model;
/**
 * Model class represents a row from data source.
 * 
 * @author radekkania7@wp.pl
 *
 */
public class User {
	
	private int id;
	
	private String name;
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
