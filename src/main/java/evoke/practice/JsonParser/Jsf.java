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





public class Jsf {

	public static void main(String[] args) throws IOException,  org.json.simple.parser.ParseException {
	
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
				jb.get("WAENUM");
				
				
				
				HashMap<String,JSONObject> hotellist=new HashMap<String,JSONObject>();
				HashMap<String,JSONObject> hotelroom=new HashMap<String,JSONObject>();
				Iterator i=jb.keySet().iterator();
				while(i.hasNext())
				{
					
					String key=(String)i.next();
					JSONObject value=(JSONObject) jb.get(key);
					hotellist.put(key, value);
										
				}
			
				
				hotellist.forEach((k,v)->{
					Iterator j=v.keySet().iterator();
					
						while(j.hasNext())
						{
							//JSONObject l=(JSONObject) v;
							
							String key=(String)j.next();
							//System.out.println(v.get(key));
							if((v.get(key).getClass().getName()).contains("json"))
								{
								JSONObject value=(JSONObject) v.get(key);
								
							     hotelroom.put(k+"-"+key, value);	
								};													
							
						}});
				hotelroom.forEach((k,v)->{
				System.out.println(k+"-"+v);});
	}
	}
	
	