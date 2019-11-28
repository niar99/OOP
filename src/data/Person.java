package data;

public class Person extends Entity{
    private String dateOfBirth;
    private String nationality;
    
	public Person() {
		
	}
	
	public Person(String id, String name, String description, String dateOfBirth, String nationality) {
		super(id, name, description);
        this.setDateOfBirth(dateOfBirth);
        this.setNationality(nationality);
	}
    
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getNationality() {
        return this.nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
