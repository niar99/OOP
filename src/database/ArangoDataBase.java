package database;

import util.*;
import java.util.ArrayList;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionType;
import com.arangodb.model.CollectionCreateOptions;

public class ArangoDataBase implements IDatabaseManager {
	protected ArangoDB arangoDB;

	public ArangoDataBase() {
		this("root", "0000");
	}

	public ArangoDataBase(String name, String pwd) {
		this.setArangoDB(name, pwd);
	}

	protected void setArangoDB(String name, String pwd) {
		this.arangoDB = new ArangoDB.Builder().user(name).password(pwd).build();
	}

	@Override
	public boolean createDataBase(String dbName) {
		try {
			this.arangoDB.createDatabase(dbName);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}

	@Override
	public boolean createDocumentCollection(String dbName, String collectionName) {
		try {
			this.arangoDB.db(dbName).createCollection(collectionName);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}
	
	@Override
	public boolean createEdgeCollection(String dbName, String collectionName) {
		try {
			CollectionCreateOptions options = new CollectionCreateOptions();
			this.arangoDB.db(dbName).createCollection(collectionName, options.type(CollectionType.EDGES));
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}

	@Override
	public boolean createDocument(String dbName, String collectionName, Object object) {
		try {
			BaseDocument document = AppUtility.ToBaseDocument(object);
			this.arangoDB.db(dbName).collection(collectionName).insertDocument(document);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}

	@Override
	public boolean dropDatabase(String dbName) {
		try {
			this.arangoDB.db(dbName).drop();
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}

	@Override
	public boolean dropCollection(String dbName, String collectionName) {
		try {
			this.arangoDB.db(dbName).collection(collectionName).drop();
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}

	@Override
	public boolean createDocument(String dbName, String collectionName, ArrayList<?> objects) {
		try {
			ArrayList<BaseDocument> documents = AppUtility.ToBaseDocument(objects);
			this.arangoDB.db(dbName).collection(collectionName).insertDocument(documents);
			return true;
		} catch (ArangoDBException e) {
			return false;
		}
	}

	@Override
	public ArrayList<String> executeQuery(String dbName, String query) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			ArangoCursor<String> cursor = this.arangoDB.db(dbName).query(query, null, null, String.class);
			cursor.forEachRemaining(aDocument -> {
				result.add(aDocument);
			});
			return result;
		} catch (ArangoDBException e) {
			return null;
		}
	}
}
