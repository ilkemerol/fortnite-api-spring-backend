package com.fortnite.service;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class FortniteApiCall {
	
	public static void main(String[] args) {
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/users/id")
				.header("Authorization", "ca3437b647c8d90e6a77564ecde1ecee")
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("username", "Ninja")
				.send();
		
		System.out.println(httpResponse.bodyText());
	}
}
