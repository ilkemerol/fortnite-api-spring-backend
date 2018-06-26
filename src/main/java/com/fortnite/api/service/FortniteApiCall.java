package com.fortnite.api.service;

import org.springframework.beans.factory.annotation.Value;

import com.fortnite.api.util.ApiKeyUtil;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;


/*
 * ilkemerol
 */
public class FortniteApiCall {
		
	public static void main(String[] args) {
		ApiKeyUtil api = new ApiKeyUtil();
		String fortniteApiKey = api.getFortniteApiKey();
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/users/id")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("username", "Ninja")
				.send();
		
		System.out.println(httpResponse.bodyText());
	}
}
