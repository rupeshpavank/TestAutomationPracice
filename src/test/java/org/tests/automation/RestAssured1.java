package org.tests.automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class RestAssured1 {

	
	  @Test public void restAssured() {
	  
	  
	  Response response= RestAssured.get("https://reqres.in/api/users?page=2");
	  
	  System.out.println(response.getStatusCode());
	  
	  System.out.println(response.getTime());
	  
	  String str=response.getBody().asString();
	  
	  System.out.println(response.getHeader("content-type"));
	  
	  System.out.println(str);
	  
	  }
	 

	
	  @Test public void restAssuredBDDGet() {
	  
	  given().when().get("https://reqres.in/api/users?page=2").then().
	  assertThat(). statusCode(200).
	  and().body("data.id[0]",equalTo(7)).and().body("data.email[1]",
	  equalTo("lindsay.ferguson@reqres.in")).and().assertThat().body("total",
	  equalTo(12)) .log().all();
	  
	  
	  }
	  
	  
	  
	  @Test public void restAssuredBDDGet1() {
	  
	  baseURI="https://reqres.in/api/";
	  
	  given().when().get("users?page=2").then(). assertThat(). statusCode(200).
	  and().body("data.id[0]",equalTo(7)).and().body("data.email[1]",
	  equalTo("lindsay.ferguson@reqres.in")).and().assertThat().body("total",
	  equalTo(12)). body("data.first_name", hasItem("Michael")) .log().all();
	  
	  }
	 

	@Test
	public void restAssuredBDDPost() {

		baseURI = "https://reqres.in/";

		File jsonDataInFile = new File(
				"C:\\Users\\hi\\eclipse-workspace\\RestAssuredAutomation\\src\\test\\java\\org\\tests\\automation\\Test.json");

		given().contentType(ContentType.JSON).body(jsonDataInFile).post("/api/users").then().assertThat().and()
				.statusCode(201).assertThat().and().body("name", equalTo("morpheus")).log().all();

		System.out.println("***********************");
	}

}
