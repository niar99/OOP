package collections;

import java.util.ArrayList;

import data.*;
import java.util.Random;

public class Collections implements RandomDate{
    enum Relationship {
        GAP_GO,
        TO_CHUC,
        KY_THOA_THUAN,
        THAM_GIA,
        DIEN_GIA_TAI,
        UNG_HO,
        PHAN_DOI,
        PHAT_BIEU_TAI,
        CANG_THANG_VOI,
        HUY_BO,
        DAM_PHAN_VOI
    }
    public static final int CAPACITY = 1000;
    private ArrayList<Entity> agreements;
    private ArrayList<Entity> companies;
    private ArrayList<Entity> events;
    private ArrayList<Entity> locations;
    private ArrayList<Entity> organizations;
    private ArrayList<Entity> people;
    private ArrayList<Fact> facts;
    private int startEntityID = 0;
    private int startFactID = 0;
    private Random ran = new Random();

    public Collections() {
        
    }

    public ArrayList<Entity> getAgreements() {
        return agreements;
    }

    public void setAgreements(ArrayList<Entity> agreements) {
        this.agreements = agreements;
    }

    public ArrayList<Entity> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Entity> companies) {
        this.companies = companies;
    }

    public ArrayList<Entity> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Entity> events) {
        this.events = events;
    }

    public ArrayList<Entity> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Entity> locations) {
        this.locations = locations;
    }

    public ArrayList<Entity> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(ArrayList<Entity> organizations) {
        this.organizations = organizations;
    }

    public ArrayList<Entity> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Entity> people) {
        this.people = people;
    }

    public ArrayList<Entity> getEntities() {
        ArrayList<Entity> entities = new ArrayList<>();
        entities.addAll(this.agreements);
        entities.addAll(this.companies);
        entities.addAll(this.events);
        entities.addAll(this.locations);
        entities.addAll(this.organizations);
        entities.addAll(this.people);
        
        return entities;
    }
    public ArrayList<Fact> getFacts() {
        return facts;
    }
    

    public void setFacts(ArrayList<Fact> facts) {
        this.facts = facts;
    }
    
    public void setStartEntityID(int id) {
        this.startEntityID = id;
    }
    
    public void setStartFactID(int id) {
        this.startFactID = id;
    }

    /**
     * generate collections of entities and facts
     * @param entities_size number of entities of each type
     * @param facts_size number of facts
     * @param startEntityID entity id for starting if each type
     * @param startFactID fact id for starting
     */
    public void generateCollections(int entities_size, int facts_size, int startEntityID, int startFactID) {
        this.setStartEntityID(startEntityID);
        this.setStartFactID(startFactID);
        this.generateAgreements(entities_size);
        this.generateCompanies(entities_size);
        this.generateEvents(entities_size);
        this.generateLocations(entities_size);
        this.generateOrganizations(entities_size);
        this.generatePeople(entities_size);
        this.generateFacts(facts_size);
    }

    public void generateAgreements(int size) {
        ArrayList<Entity> agreements = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringBuffer id = (new StringBuffer("agr")).append(i + this.startEntityID);
            StringBuffer name = (new StringBuffer("Agreement")).append(i + this.startEntityID);
            StringBuffer description = (new StringBuffer("Description of ")).append(name);
            Agreement agreement = new Agreement(id.toString(), name.toString(), description.toString());
            
            agreements.add(agreement);
        }
        this.setAgreements(agreements);
    }

    public void generateCompanies(int size) {
        ArrayList<Entity> companies = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringBuffer id = (new StringBuffer("comp")).append(i + this.startEntityID);
            StringBuffer name = (new StringBuffer("Company")).append(i + this.startEntityID);
            StringBuffer description = (new StringBuffer("Description of ")).append(name);
            StringBuffer address = (new StringBuffer("Address of ")).append(name);
            Company company = new Company(id.toString(), name.toString(), description.toString(), address.toString());
            
            companies.add(company);
        }
        this.setCompanies(companies);
    }

    public void generateEvents(int size) {
        ArrayList<Entity> events  = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringBuffer id = (new StringBuffer("eve")).append(i + this.startEntityID);
            StringBuffer name = (new StringBuffer("Event")).append(i + this.startEntityID);
            StringBuffer description = (new StringBuffer("Description of ")).append(name);
            Event event = new Event(id.toString(), name.toString(), description.toString());
            
            events.add(event);
        }
        this.setEvents(events);
    }

    public void generateLocations(int size) {
        ArrayList<Entity> locations = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringBuffer id = (new StringBuffer("loc")).append(i + this.startEntityID);
            StringBuffer name = (new StringBuffer("Location")).append(i + this.startEntityID);
            StringBuffer description = (new StringBuffer("Description of ")).append(name);
            Location location = new Location(id.toString(), name.toString(), description.toString());
            
            locations.add(location);
        }
        this.setLocations(locations);
    }

    public void generateOrganizations(int size) {
        ArrayList<Entity> organizations = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringBuffer id = (new StringBuffer("org")).append(i + this.startEntityID);
            StringBuffer name = (new StringBuffer("Organization")).append(i + this.startEntityID);
            StringBuffer description = (new StringBuffer("Description of ")).append(name);
            StringBuffer nation = (new StringBuffer("Nation")).append(this.ran.nextInt(50));

            Organization organization = new Organization(id.toString(), name.toString(), description.toString(), nation.toString());
            organizations.add(organization);
        }
        this.setOrganizations(organizations);
    }

    public void generatePeople(int size) {
        ArrayList<Entity> people = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            StringBuffer id = (new StringBuffer("per")).append(i + this.startEntityID);
            StringBuffer name = (new StringBuffer("Person")).append(i + this.startEntityID);
            StringBuffer description = (new StringBuffer("Description of ")).append(name);
            StringBuffer nationality = (new StringBuffer("Nation")).append(this.ran.nextInt(50));
            String dateofbirth = createRandomDate(1990, 2000);
            
            Person person = new Person(id.toString(), name.toString(), description.toString(), dateofbirth, nationality.toString());
            people.add(person);
        }
        this.setPeople(people);
    }

    public void generateFacts(int size) {
        ArrayList<Fact> facts = new ArrayList<>();
        String objectID = "";
        String subjectID = "";
        for (int i = 0; i < size; ++i) {
            // select a random ralationship
            int j = ran.nextInt(11);
            switch (Relationship.values()[j]) {
                case GAP_GO:
                    subjectID = this.randomEntityID(people);
                    objectID = this.randomEntityID(people);
                    break;
                case TO_CHUC:
                    subjectID = this.randomEntityID(organizations, people);
                    objectID = this.randomEntityID(events);
                    break;
                case KY_THOA_THUAN:
                    subjectID = this.randomEntityID(companies);
                    objectID = this.randomEntityID(companies);
                    break;
                case THAM_GIA:
                    subjectID = this.randomEntityID(people, organizations);
                    objectID = this.randomEntityID(organizations, events, agreements);
                    break;
                case DIEN_GIA_TAI:
                    subjectID = this.randomEntityID(events);
                    objectID = this.randomEntityID(locations, companies);
                    break;
                case UNG_HO:
                    subjectID = this.randomEntityID(people, companies);
                    objectID = this.randomEntityID(companies, agreements, events);
                    break;
                case PHAN_DOI:
                    subjectID = this.randomEntityID(people, companies);
                    objectID = this.randomEntityID(companies, agreements, events);
                    break;
                case PHAT_BIEU_TAI:
                    subjectID = this.randomEntityID(people);
                    objectID = this.randomEntityID(events);
                    break;
                case CANG_THANG_VOI:
                    subjectID = this.randomEntityID(companies);
                    objectID = this.randomEntityID(companies);
                    break;
                case HUY_BO:
                    subjectID = this.randomEntityID(people, companies);
                    objectID = this.randomEntityID(agreements, events);
                    break;
                case DAM_PHAN_VOI:
                    subjectID = this.randomEntityID(companies);
                    objectID = this.randomEntityID(companies);
                    break;

            }
            
            //create a fact
            String factID = String.valueOf(i + this.startFactID);
            String date = createRandomDate(2010, 2018);
            Fact fact = new Fact();
            fact.setId(factID);
            fact.setObjectID(objectID);
            fact.setSubjectID(subjectID);
            fact.setDate(date);
            fact.setRelationship(Relationship.values()[j].toString());
            facts.add(fact);
        }
        this.facts = facts;
    }
    
    public String randomEntityID(ArrayList<Entity>...entities_arr) {
        int len = entities_arr.length;
        //select a random entity type
        int type = this.ran.nextInt(len);
        ArrayList<Entity> entities = entities_arr[type];
        //return a random entity id
        int i = this.ran.nextInt(entities.size());
        return entities.get(i).getId();
    }
}
