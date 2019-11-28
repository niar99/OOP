package database;

import java.util.ArrayList;

public abstract class DataBase{
	public DataBase() {

    }
	
	public abstract boolean createDataBase(String dbName);
	
	public abstract boolean createCollection(String dbName, String collectionName);
	
	public abstract boolean createDocument(String dbName, String collectionName, Object object);
	
	public abstract boolean createDocument(String dbName, String collectionName, ArrayList<?> objects);
	
	public abstract ArrayList<String> executeQuery(String dbName, String query);
}
