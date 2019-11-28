/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import collections.Collections;
import data.Entity;
import data.Fact;
import database.ArangoDataBase;
import database.DataBase;
import java.util.ArrayList;

/**
 *
 * @author Niar
 */
public class App {
    private static final int NOENTITIES = 100;
    private static final int NOFACTS = 100;
    
    public static void main(String[] args) {
        new App();
    }
    
    public App() {
        int startEntityID = 1;
        int startFactID = 1;
        Collections collections = new Collections();
        collections.generateCollections(NOENTITIES, NOFACTS, startEntityID, startFactID);
        
        ArrayList<Entity> entities = collections.getEntities();
        ArrayList<Fact> facts = collections.getFacts();
        
        String username = "root";
        String password = "0000";
        DataBase db = new ArangoDataBase(username, password);
        String dbName = "mydb";
        String entities_collection = "entities";
        String facts_collection = "facts";
        
        db.createDataBase(dbName);
        db.createCollection(dbName, entities_collection);
        db.createDocument(dbName, entities_collection, entities);
        db.createCollection(dbName, facts_collection);
        db.createDocument(dbName, facts_collection, facts);
    }
}
