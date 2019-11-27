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
import database.DataBase;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import tobasedocument.ToBaseDocument;

public class Test implements ToBaseDocument{
	public static void main(String[] args) throws IOException {
		new Test();
	}
	
	public Test() throws IOException {
		Person entity1 = new Person("1", "name", "description", "male", "Vietnamese");
		Person entity2 = new Person("2", "name", "description", "male", "Vietnamese");
		entity2.setName("name2");
		entity2.setDescription("description2");
		ArrayList<Person> people = new ArrayList<>();
		ArrayList<Entity> entities = new ArrayList<>();
		people.add(entity1);
		people.add(entity2);
		entities.addAll(people);
        Object entity = entity1;
        
//		Collections collection = new Collections(entities, new ArrayList<Fact>());
		
//		DataBase db = new DataBase();
//		String dbName = "mydb";
//		String collectionName = "firstCollection";
//		db.createDB(dbName);
//		db.createCollection(dbName, collectionName);
//		db.saveDocument(dbName, collectionName, entities);
		
		ArrayList<BaseDocument> documents = this.toBaseDocument(people);
//        Field[] attrs = entity1.getClass().getDeclaredFields();
//        for (Field attr: attrs) {
//            System.out.println(attr.getName());
//        }
//		ArrayList<BaseDocument> documents = toBaseDocument(entities);
        
		System.out.println(documents);
	}
}
