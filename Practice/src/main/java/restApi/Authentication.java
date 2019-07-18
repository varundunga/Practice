package restApi;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Authentication {
	
	public static String cookie() {

		RestAssured.baseURI = "http://localhost:8080";

		Response res=given().body("{ \"username\": \"varundunga\", \"password\": \"1234567890\" }").and()
				.header("Content-Type", "application/json").
				when().post("/rest/auth/1/session").
				then().assertThat()
				.statusCode(201).and().extract().response();
		String resp=res.asString();
		JsonPath resj=new JsonPath(resp);

		String cookie = resj.get("session.name")+"-"+resj.get("session.value");
		
		return cookie;
	}

}