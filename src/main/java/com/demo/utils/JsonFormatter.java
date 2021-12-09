package com.demo.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonFormatter {

	public static JsonPath jsonPathResponse(Response response) {
		return new JsonPath(response.asString());
	}
}
