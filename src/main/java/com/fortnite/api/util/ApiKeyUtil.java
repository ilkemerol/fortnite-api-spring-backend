package com.fortnite.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyUtil {

	@Autowired
	private Environment env;
	
	private String fortniteApiKey;

	public String getFortniteApiKey() {
		fortniteApiKey = env.getProperty("fortnite.ilkemerolApiKey");
		return fortniteApiKey;
	}

	public void setFortniteApiKey(String fortniteApiKey) {
		this.fortniteApiKey = fortniteApiKey;
	}
	
}
