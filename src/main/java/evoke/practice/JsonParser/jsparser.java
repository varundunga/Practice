package evoke.practice.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsparser {

	public static void main(String[] args) throws IOException, ParseException {
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
		
		//HashMap<String, Object> obj=new HashMap<String, Object>();
		//obj=Recursion.jsonToMap(jb);
		
		Recursion.jsonToMap(jb).forEach((k,v)->{
			System.out.println(k+v);			
		});
		
		
		
		
	}

}
