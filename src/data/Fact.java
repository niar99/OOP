package data;

public class Fact {
	private String id;
	private String subjectID;
	private String objectID;
	private String relationship;
	private String date;
	
	public Fact() {
		
	}
	
	public Fact(String id, String subjectID, String objectID, String relationship, String date) {
		this.setId(id);
		this.setSubjectID(subjectID);
		this.setObjectID(objectID);
		this.setRelationship(relationship);
		this.setDate(date);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
    
	public String getDate() {
		return this.date;
	}
}
