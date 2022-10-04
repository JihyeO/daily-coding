package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.*;

/**
 * JSON Array Sorting
 * Reference: https://stackoverflow.com/questions/19543862/how-can-i-sort-a-jsonarray-in-java
 * 
 * id를 기준, 사용자의 정보를 정렬
 *
 */
public class JSONArraySorting {
    public static void main( String[] args ) {
    
        String jsonString = "[ { \"ID\": \"123\", \"Name\": \"User3\", \"Groups\": [\"groupA\", \"groupB\"] },{ \"ID\": \"124\", \"Name\": \"User4\", \"Groups\": [\"groupA\", \"groupB\"] }," +
        "{ \"ID\": \"121\", \"Name\": \"User1\", \"Groups\": [\"groupA\", \"groupB\"]},{ \"ID\": \"125\", \"Name\": \"User5\", \"Groups\": [\"groupC\"]}]";

        JSONArray result = sortJsonArray(jsonString);
        
        for (int j = 0; j < result.length(); j++) {
            System.out.println(result.getJSONObject(j));
        }
    }

    public static JSONArray sortJsonArray(String jsonString) {
        JSONArray jsonArray = new JSONArray(jsonString);
        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonObjectArray = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObjectArray.add(jsonArray.getJSONObject(i));
        }
        Collections.sort(jsonObjectArray, new Comparator<JSONObject>() {   
            @Override
            public int compare(JSONObject a, JSONObject b) {
                String valA = (String) a.get("ID");
                String valB = (String) b.get("ID");
                return valA.compareTo(valB);
            }
        });

        for (int i = 0; i < jsonObjectArray.size(); i++) {
            sortedJsonArray.put(jsonObjectArray.get(i));
        }

        return sortedJsonArray;
    }
}
