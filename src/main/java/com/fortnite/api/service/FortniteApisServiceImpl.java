package com.fortnite.api.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fortnite.api.repository.DbOperationItemHistoryRepository;
import com.fortnite.api.repository.DbOperationItemRepository;
import com.fortnite.api.repository.DbOperationsDailyItemShopRepository;
import com.fortnite.api.repository.DbOperationsServerStatusRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortnite.api.entity.DailyItemShop;
import com.fortnite.api.entity.ItemHistoryEntity;
import com.fortnite.api.entity.ItemsEntity;
import com.fortnite.api.entity.ServerStatus;
import com.fortnite.api.itemshop.Items;
import com.fortnite.api.model.ItemShopDTO;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

@Service
@CacheConfig (cacheNames = "apiService")
public class FortniteApisServiceImpl implements FortniteApisService{
	
	@Autowired
	private DbOperationService dbService;
	
	@Autowired
	private DbOperationsServerStatusRepository serverStatus;
	
	@Autowired
	private DbOperationsDailyItemShopRepository dailyItemShop;
	
	@Autowired
	private DbOperationItemRepository itemDb;
	
	@Autowired
	private DbOperationItemHistoryRepository itemHistory;
	
	static final Logger logger = LoggerFactory.getLogger(FortniteApisServiceImpl.class.getName());
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	@Value("${fortnite.ilkemerolApiKey}")
	private String fortniteApiKey;
	
	@Override
	@Cacheable("getStore")
	public String getStore() throws JsonParseException, JsonMappingException, IOException {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/store/get")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data")
				.header("boundary", "----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("language", "en")
				.send();
		
		insertDailyStore(httpResponse.bodyText());
		insertDailyStoreItems(httpResponse.bodyText());
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
	public String getPlayerStats(String userId, String season) {
		
		HttpResponse httpResponse = HttpRequest
				.post("https://fortnite-public-api.theapinetwork.com/prod09/users/public/br_stats")
				.header("Authorization", fortniteApiKey)
				.contentType("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
				.form("user_id", userId)
				.form("platform", "pc")
				.form("window", season)
				.send();
		
		logger.info("APIs getPlayerStats triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		logger.info(httpResponse.bodyText());
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
	public void clearCache() {	
		logger.info("Cache Clean! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}

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

	@Override
	public void insertDailyStore(String responseBody) {
		logger.info("Response Body ### Value - {}", responseBody);
		DailyItemShop dailyItemShopEntity = new DailyItemShop();
		dailyItemShopEntity.setDate(dateTimeFormatter.format(LocalDateTime.now()).toString());
		dailyItemShopEntity.setData(responseBody);
		dailyItemShop.save(dailyItemShopEntity);
		logger.info("DB stored getStore triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}

	@Override
	@Scheduled(cron = "0 0 6 * * *", zone="Europe/Istanbul")
	public void insertServerStatus() {
		String responseBody = getServerStatus();
		logger.info("Response Body ### Value - {}", responseBody);
		
		ServerStatus serverStatusEntity = new ServerStatus();
		serverStatusEntity.setDate(dateTimeFormatter.format(LocalDateTime.now()).toString());
		serverStatusEntity.setData(responseBody);
		serverStatus.save(serverStatusEntity);
		logger.info("DB stored getServerStatus triggered! ### Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		
	}

	@Override
	public void insertDailyStoreItems(String responseBody) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ItemShopDTO itemShopDTO = mapper.readValue(responseBody, ItemShopDTO.class);
		
		for( Items item : itemShopDTO.getItems()) {
			ItemsEntity itemsEntity = new ItemsEntity();
			String dbCheckId = dbService.checkItemWithName(item.getName());
			if(dbCheckId != null){
				ItemHistoryEntity itemHistoryEntity = new ItemHistoryEntity();
				itemHistoryEntity.setName(item.getName());
				itemHistoryEntity.setDate(itemShopDTO.getDate());
				itemHistory.save(itemHistoryEntity);
				logger.info("Item existed in Items Table ### Insert only ItemHistory Table ###");
			} else {
				itemsEntity.setName(item.getName());
				itemsEntity.setCost(item.getCost());
				itemsEntity.setImage(item.getItem().getImage());
				itemsEntity.setType(item.getItem().getType());
				itemsEntity.setRarity(item.getItem().getRarity());
				itemDb.save(itemsEntity);
				logger.info("New Item ### Insert in Items Table ###");
				ItemHistoryEntity itemHistoryEntity = new ItemHistoryEntity();
				itemHistoryEntity.setName(item.getName());
				itemHistoryEntity.setDate(itemShopDTO.getDate());
				itemHistory.save(itemHistoryEntity);
				logger.info("New Item Date ### Insert in Item History Table ###");
			}
		}
	}

}
