package tobasedocument;

import java.util.ArrayList;
import java.util.HashMap;

import com.arangodb.entity.BaseDocument;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface ToBaseDocument{
	
    /**
     * Convert an object to hashmap
     * @param object
     * @return
     */
    public default HashMap toHashMap(Object object) {
        ObjectMapper oMapper = new ObjectMapper();
        HashMap<String, Object> hmap = oMapper.convertValue(object, HashMap.class);
        return hmap;
    }
    
    /**
     * Convert an object to ArangoDB basedocument
     * @param object
     * @return
     */
    public default BaseDocument toBaseDocument(Object object) {
        HashMap hm = this.toHashMap(object);
        BaseDocument document = new BaseDocument();
        
        hm.forEach((key, value) -> {
            if (key.equals("id")) {
				document.setKey((String) value);
			} else {
				document.addAttribute((String) key, value);
			}
        });
        
        return document;
    }
    
    /**
     * Convert an ArrayList of objects to ArrayList of ArangoDB basedocuments
     * @param objects
     * @return
     */
    public default ArrayList<BaseDocument> toBaseDocument(ArrayList<?> objects) {
        ArrayList<BaseDocument> documents = new ArrayList<>();
        
        objects.forEach((object) -> {
            documents.add(this.toBaseDocument(object));
        });
        
        return documents;
    }
}
