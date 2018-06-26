package com.fortnite.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fortnite.api.model.JsonObject;
import com.fortnite.api.util.ApiKeyUtil;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

@Service
public class FortniteApisServiceImpl implements FortniteApisService{
	
	@Value("${fortnite.ilkemerolApiKey}")
	private String fortniteApiKey;
	
	@Override
	public String getStore() {
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/store/get")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("language", "en")
				.send();
		
		return httpResponse.bodyText();
	}
	
	@Override
	public String getUserId(String username) {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/users/id")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("username", username)
				.send();
		
		return httpResponse.bodyText();
	}

}
