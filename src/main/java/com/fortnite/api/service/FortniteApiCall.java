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
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/users/public/br_stats")
				.header("Authorization", "f7856fe65d309c3bb18a67c36815f88f")
				.contentType("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("user_id", "4735ce9132924caf8a5b17789b40f79c")
				.form("platform", "pc")
				.form("window", "alltime")
				.send();
		
		System.out.println(httpResponse.bodyText());
	}
}
