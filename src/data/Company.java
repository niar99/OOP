package data;

public class Company extends Entity {
    private String address;
    
	public Company() {
		
	}
	
	public Company(String id, String name, String description, String address) {
		super(id, name, description);
        this.setAddress(address);
	} 
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
