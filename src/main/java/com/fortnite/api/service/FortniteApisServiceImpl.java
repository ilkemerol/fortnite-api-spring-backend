package com.fortnite.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fortnite.api.model.JsonObject;
import com.fortnite.api.util.ApiKeyUtil;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

@Service
@CacheConfig (cacheNames = "apiService")
public class FortniteApisServiceImpl implements FortniteApisService{
	
	static final Logger logger = LoggerFactory.getLogger(FortniteApisServiceImpl.class.getName());
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	@Value("${fortnite.ilkemerolApiKey}")
	private String fortniteApiKey;
	
	@Override
	@Cacheable("getStore")
	@Scheduled(cron = "0 0/60 * * * ?")
	public String getStore() {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/store/get")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("language", "en")
				.send();
		
		logger.info("APIs getStore triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
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
		
		logger.info("APIs getUserId triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
	}

	@Override
	@Cacheable("getUpcomingItems")
	public String getUpcomingItems() {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/upcoming/get")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("language", "en")
				.send();
		
		logger.info("APIs getUpcomingItems triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
	}

	@Override
	public String getPlayerStats(String userId) {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/users/public/br_stats")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("user_id", userId)
				.form("platform", "pc")
				.form("window", "alltime")
				.send();
		
		logger.info("APIs getPlayerStats triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
	}

	@Override
	@Cacheable("getNews")
	public String getNews() {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/br_motd/get")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.send();
		
		logger.info("APIs getNews triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
	}

	@Override
	@Cacheable("getServerStatus")
	public String getServerStatus() {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/status/fortnite_server_status")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("language", "en")
				.send();
		
		logger.info("APIs getServerStatus triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
		
		//"{\"status\":\"DOWN\",\"message\":\"Fortnite is up.\",\"version\":\"4.5\",\"time\":{\"since\":{\"seconds\":\"1530092223\"},\"duration\":{\"seconds\":859012,\"formated\":\"09 days, 22 hour, 36 minuts and 52 seconds\"}}}
	}

	@Override
	@Cacheable("getTopTen")
	public String getTopTen() {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/leaderboards/get")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("window", "top_10_kills")
				.send();
		
		logger.info("APIs getTopTen triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
	}

	@Override
	@Cacheable("getPatchNotes")
	public String getPatchNotes() {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/patchnotes/get")
				.header("Authorization", fortniteApiKey)
				.send();
		
		logger.info("APIs getPatchNotes triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
	}

	@Override
	@CacheEvict (allEntries = true)
	public void clearCache() {	}

	@Override
	@Cacheable("getBrChallenges")
	public String getBrChallenges() {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/challenges/get")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("season", "season5")
				.form("language", "en")
				.send();
		
		logger.info("APIs getBrChallenges triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		return httpResponse.bodyText();
		
	}

}
