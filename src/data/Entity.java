package data;

public class Entity {
	protected String id;
	protected String name;
	protected String description;
	
	public Entity() {
		
	}
	
	public Entity(String id, String name, String description) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
