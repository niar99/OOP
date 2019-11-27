package database;

import java.util.ArrayList;

import com.arangodb.entity.BaseDocument;

import tobasedocument.ToBaseDocument;

public class DataBase extends ArangoDataBase implements ToBaseDocument{
	public DataBase() {
		super();
	}
	
	public DataBase(String name, String pwd) {
		super(name, pwd);
	}
	
	public boolean createDataBase(String dbName) {
		return super.createDataBase(dbName);
	}
	
	public boolean createCollection(String dbName, String collectionName) {
		return super.createCollection(dbName, collectionName);
	}
	
	public boolean saveDocument(String dbName, String collectionName, Object object) {
		BaseDocument document = this.toBaseDocument(object);
		return super.createDocument(dbName, collectionName, document);
	}
	
	public boolean saveDocument(String dbName, String collectionName, ArrayList<Object> objects) {
		ArrayList<BaseDocument> documents = this.toBaseDocument(objects);
		return super.createDocument(dbName, collectionName, documents);
	}
	
	public ArrayList<String> executeQuery(String dbName, String query) {
		return super.executeAQLQuery(dbName, query, null);
	}
}
