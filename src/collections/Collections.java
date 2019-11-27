package collections;

import java.util.ArrayList;

import data.*;

public class Collections {
	ArrayList<Agreement> agreements;
	ArrayList<Company> companies;
	ArrayList<Event> events;
	ArrayList<Location> locations;
	ArrayList<Organization> organizations;
	ArrayList<Person> people;
	ArrayList<Fact> facts;
	
	public Collections() {
		this(new ArrayList<Agreement>(), new ArrayList<Company>(), new ArrayList<Event>(), new ArrayList<Location>(), new ArrayList<Organization>(), new ArrayList<Person>(), new ArrayList<Fact>());
	}
	
	public Collections(ArrayList<Agreement> agreements, ArrayList<Company> companies, ArrayList<Event> events, ArrayList<Location> locations, ArrayList<Organization> organizations, ArrayList<Person> people, ArrayList<Fact> facts) {
		this.setAgreements(agreements);
		this.setCompanies(companies);
		this.setEvents(events);
		this.setLocations(locations);
		this.setOrganizations(organizations);
		this.setPeople(people);
		this.setFacts(facts);
	}

	public ArrayList<Agreement> getAgreements() {
		return agreements;
	}

	public void setAgreements(ArrayList<Agreement> agreements) {
		this.agreements = agreements;
	}

	public ArrayList<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}

	public ArrayList<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(ArrayList<Organization> organizations) {
		this.organizations = organizations;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public ArrayList<Fact> getFacts() {
		return facts;
	}

	public void setFacts(ArrayList<Fact> facts) {
		this.facts = facts;
	}
	
	public void generateCollections() {
		this.generateAgreements();
		this.generateCompanies();
		this.generateEvents();
		this.generateLocations();
		this.generateOrganizations();
		this.generatePeople();
		this.generateFacts();
	}
	
	public void generateAgreements() {
		
	}
	
	public void generateCompanies() {
		
	}
	
	public void generateEvents() {
			
		}
	
	public void generateLocations() {
		
	}
	
	public void generateOrganizations() {
		
	}
	
	public void generatePeople() {
		
	}

	public void generateFacts() {
		
	}
}
