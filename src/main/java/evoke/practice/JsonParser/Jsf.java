package evoke.practice.JsonParser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bsh.ParseException;



public class Jsf {

	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
	
		// TODO Auto-generated method stub

		String baseUrl="https://core.redlion.com/api/windsurfer/availability?_format=json&Quantity=1&Start=2020-01-07&End=2020-01-10&Adults=1&HotelCode=WAABDN%2cWATWTR%2cBC1663%2cWAENUM";

				URL url=new URL(baseUrl);
				HttpURLConnection req = (HttpURLConnection)url.openConnection();
				req.setRequestMethod("GET");
				Scanner sc = new Scanner(url.openStream());
				String inline="";
				while(sc.hasNext())
				{
				inline+=sc.nextLine();
				}
				sc.close();
				JSONParser p=new JSONParser();
				JSONObject jb=(JSONObject) p.parse(inline);
				//System.out.println(jb);
				
				
				
				HashMap<String,JSONObject> hotellist=new HashMap<String,JSONObject>();
				HashMap<String,JSONObject> hotelroom=new HashMap<String,JSONObject>();
				Iterator i=jb.keySet().iterator();
				while(i.hasNext())
				{
					
					String key=(String)i.next();
					JSONObject value=(JSONObject) jb.get(key);
					hotellist.put(key, value);
					
					
				}
				
			
				/*hotellist.forEach((k,v)->{
					System.out.println(k+"-"+v);});*/
			
				try
				{
				hotellist.forEach((k,v)->{
					Iterator j=v.keySet().iterator();
					
						while(j.hasNext())
						{
							//JSONObject l=(JSONObject) v;
							
							String key=(String)j.next();
							System.out.println(v.get(key));
							System.out.println(v.get(key).getClass().getName());
						
							//JSONObject value=(JSONObject) v.get(key);
							//hotelroom.put(key, value);
							
							
						}});
				}
				catch(Exception e)
				{
					System.out.println("stringexception");
				
				
				}
				
					
					
					
					
				
				
				//hotelroom.forEach((k,v)->{
				//	System.out.println(k+"-"+v);});
				

		
	}
	}
	
	/*public static HashMap<String, Object> jsonToMap(JSONObject json) throws JSONException {
	    HashMap<String, Object> retMap = new HashMap<String, Object>();

	    if(json != JSONObject) {
	        retMap = toMap(json);
	    }
	    return retMap;
	}

	public static HashMap<String, Object> toMap(JSONObject object) throws JSONException {
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

	public static ArrayList<Object> toList(JSONArray array) throws JSONException {
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
*/

 


