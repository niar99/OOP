package data;

public class Person extends Entity{
    private String gender;
    private String nationality;
    
	public Person() {
		
	}
	
	public Person(String id, String name, String description, String gender, String nationality) {
		super(id, name, description);
        this.setGender(gender);
        this.setNationality(nationality);
	}
    
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getNationality() {
        return this.nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
