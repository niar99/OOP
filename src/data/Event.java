package data;

public class Event extends Entity{
    private String date;
	public Event() {
		
	}
	
	public Event(String id, String name, String description) {
		super(id, name, description);
	} 
    
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
}
