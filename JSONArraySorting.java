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

        List<JSONObject> jsonObjectArray = new ArrayList<>();
        jsonArray.forEach(value -> jsonObjectArray.add((JSONObject)value));
        jsonObjectArray.sort((o1, o2) -> {
            String valA = (String) o1.get("ID");
            String valB = (String) o2.get("ID");
            return valA.compareTo(valB);
        });

        JSONArray sortedJsonArray = new JSONArray();
        jsonObjectArray.forEach(sorted -> sortedJsonArray.put(sorted));

        return sortedJsonArray;
    }
}
