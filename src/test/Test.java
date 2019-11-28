package test;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.arangodb.entity.BaseDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import collections.Collections;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import data.*;
import database.ArangoDataBase;
import database.DataBase;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Random;
import tobasedocument.ToBaseDocument;

public class Test implements ToBaseDocument{
    Random ran = new Random();
//	public static void main(String[] args) throws IOException {
//		new Test();
//	}
	
	public Test() throws IOException {
//		Person entity1 = new Person("1", "name", "description", "male", "Vietnamese");
//		Person entity2 = new Person("2", "name", "description", "male", "Vietnamese");
//		entity2.setName("name2");
//		entity2.setDescription("description2");
//		ArrayList<Person> people = new ArrayList<>();
//		ArrayList<Entity> entities = new ArrayList<>();
//		people.add(entity1);
//		people.add(entity2);
//		entities.addAll(people);
        Collections collections = new Collections();
        try {
            collections.generateCollections(10, 20, 0, 0);
            ArrayList<Fact> facts = collections.getFacts();
    		DataBase db = new ArangoDataBase();
    		String dbName = "mydb";
    		String collectionName = "firstCollection";
    		db.createDataBase(dbName);
    		db.createCollection(dbName, collectionName);
    		db.createDocument(dbName, collectionName, facts);

//            ArrayList<BaseDocument> documents = this.toBaseDocument(facts);
//            Field[] attrs = entity1.getClass().getDeclaredFields();
//            for (Field attr: attrs) {
//                System.out.println(attr.getName());
//            }
//    		ArrayList<BaseDocument> documents = toBaseDocument(entities);

//            System.out.println(documents);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
