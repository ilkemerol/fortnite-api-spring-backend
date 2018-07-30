package com.fortnite.api.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fortnite.api.model.JsonObject;

public interface FortniteApisService {
	
	public String getUserId(String username);
	
	public String getStore() throws JsonParseException, JsonMappingException, IOException;
	
	public String getUpcomingItems();
	
	public String getPlayerStats(String userId);
	
	public String getNews();
	
	public String getServerStatus();
	
	public String getTopTen();
	
	public String getPatchNotes();
	
	public String getBrChallenges();
	
	/* Cache Clear */
	public void clearCache();
	
	/* Cron Job Method */
	public void insertDailyStore(String responseBody);
	
	public void insertDailyStoreItems(String responseBody) throws JsonParseException, JsonMappingException, IOException;
	
	public void insertServerStatus();
}
