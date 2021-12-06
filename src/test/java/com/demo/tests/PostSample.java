package com.demo.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class PostSample {

	@Test
	public void sample() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		Map<String, Object> post = new HashMap<String, Object>();
		
//		post.put("name", "Polo");
//		post.put("job", "Analyst");
//		System.out.println(post);
		
		JSONObject request = new JSONObject(post);
		request.put("name", "Polo");
		request.put("job","Testing Engineer");
		
		System.out.println(request.toJSONString());
		
		
	}
}
