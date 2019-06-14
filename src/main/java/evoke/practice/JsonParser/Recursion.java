package evoke.practice.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Recursion {
	
	public static HashMap<String, Object> jsonToMap(JSONObject json)  {
    HashMap<String, Object> retMap = new HashMap<String, Object>();

    if(json.getClass().getName().contains("json")) {
        retMap = toMap(json);
    }
    return retMap;
}

public static HashMap<String, Object> toMap(JSONObject object)  {
    HashMap<String, Object> map = new HashMap<String, Object>();

    Iterator keysItr = object.keySet().iterator();
    while(keysItr.hasNext()) {
        String key = (String)keysItr.next();
        Object value = object.get(key);

        if(value instanceof JSONArray) {
            value = toList((JSONArray) value);
        }

        else if(value instanceof JSONObject) {
            value = toMap((JSONObject) value);
        }
        map.put(key, value);
    }
    return map;
}

public static ArrayList<Object> toList(JSONArray array)  {
    ArrayList<Object> list = new ArrayList<Object>();
    for(int i = 0; i < array.size(); i++) {
        Object value = array.get(i);
        if(value instanceof JSONArray) {
            value = toList((JSONArray) value);
        }

        else if(value instanceof JSONObject) {
            value = toMap((JSONObject) value);
        }
        list.add(value);
    }
    return list;
}
}








