package com.fortnite.api.service;

import com.fortnite.api.model.JsonObject;

public interface FortniteApisService {
	
	public String getUserId(String username);
	
	public String getStore();
	
	public String getUpcomingItems();
	
}
