package database;

import java.util.ArrayList;
import java.util.Map;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

public class ArangoDataBase{
	protected ArangoDB arangoDB;
	protected ArangoDatabase db;
	protected ArangoCollection collection;

	/** Constructs an ArangoDataBase with name = "root" and password = "0000"
	 * 
	 */
	protected ArangoDataBase() {
		this("root", "0000");
	}
	
	/** Constructs an ArangoDataBase with given name and password
	 * 
	 * @param name
	 * @param pwd
	 */
	protected ArangoDataBase(String name, String pwd) {
		this.setArangoDB(name, pwd);
	}
	
	protected void setArangoDB(String name, String pwd) {
		this.arangoDB = new ArangoDB.Builder().user(name).password(pwd).build();
	}

	public void setDb(String dbName) {
		this.db = this.arangoDB.db(dbName);
	}

	public void setCollection(String collectionName) {
		this.collection = this.db.collection(collectionName);
	}

	/** Creates a database with given name
	 * 
	 * @param dbName
	 * @return true if successful, false if failure
	 */
	protected boolean createDataBase(String dbName) {
		try {
			this.arangoDB.createDatabase(dbName);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}
	
	/** Create a collection from database dbName with given name
	 * 
	 * @param dbName
	 * @param collectionName
	 * @return true if successful, false if failure
	 */
	protected boolean createCollection(String dbName, String collectionName) {
		try {
			this.arangoDB.db(dbName).createCollection(collectionName);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}
	
	/** Inserts a document to collection collectionName in database dbName
	 * 
	 * @param dbName
	 * @param collectionName
	 * @param document
	 * @return true if successful, false if failure
	 */
	protected boolean createDocument(String dbName, String collectionName, BaseDocument document) {
		try {
			this.arangoDB.db(dbName).collection(collectionName).insertDocument(document);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}
	
	/** Inserts a list of document to collection collectionName in database dbName
	 * 
	 * @param dbName
	 * @param collectionName
	 * @param documents
	 * @return true if successful, false if failure
	 */
	protected boolean createDocument(String dbName, String collectionName, ArrayList<BaseDocument> documents) {
		try {
			this.arangoDB.db(dbName).collection(collectionName).insertDocument(documents);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}
	
	/** Executes a query
	 * 
	 * @param dbName
	 * @param query
	 * @param bindVars
	 * @return ArrayList of String for Json of the results
	 */
	protected ArrayList<String> executeAQLQuery(String dbName, String query, Map<String, Object> bindVars) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			ArangoCursor<String> cursor = this.arangoDB.db(dbName).query(query, bindVars, null, String.class);
			cursor.forEachRemaining(aDocument -> {
				result.add(aDocument);
			});
			return result;
		} catch (ArangoDBException e) {
			return null;
		}
	}
}
