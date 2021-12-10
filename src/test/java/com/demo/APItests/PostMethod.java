package com.demo.APItests;

import static com.demo.resources.Payload.createUser;
import static com.demo.utils.JsonFormatter.jsonPathResponse;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostMethod extends BaseTestURI {

	@Test
	public static void createUserandValidate() {

		String name = "Puni";
		String job = "Analyst";

		Response re = given()
				.when().contentType(ContentType.JSON).body(createUser(name, job)).post("/users")
				.then().extract().response();

		JsonPath jsoPath = jsonPathResponse(re);

		Assert.assertEquals(re.statusCode(), 201);
		Assert.assertNotNull(jsoPath.getInt("id"));
		Assert.assertEquals(jsoPath.getString("name"), "Puni");
		Assert.assertEquals(jsoPath.getString("job"), "Analyst");
		Assert.assertNotNull(jsoPath.getString("createdAt"));
	}

}
