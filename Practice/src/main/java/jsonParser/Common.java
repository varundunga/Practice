package jsonParser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Common {
	
	public static JSONObject stringtojson(String str) throws ParseException{
		JSONParser p=new JSONParser();
		JSONObject jb=(JSONObject) p.parse(str);
		return jb;
		
	}

}