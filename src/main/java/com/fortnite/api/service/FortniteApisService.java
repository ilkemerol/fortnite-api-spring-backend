package com.fortnite.api.service;

import com.fortnite.api.model.JsonObject;

public interface FortniteApisService {
	
	public String getUserId(String username);
	
	public String getStore();
	
	public String getUpcomingItems();
	
	public String getPlayerStats(String userId);
	
	public String getNews();
	
	public String getServerStatus();
	
	public String getTopTen();
	
	public String getPatchNotes();
}
