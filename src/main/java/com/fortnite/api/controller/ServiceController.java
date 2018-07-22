package com.fortnite.api.controller;

import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fortnite.api.model.UserPojo;
import com.fortnite.api.service.DbOperationService;
import com.fortnite.api.service.FortniteApisService;
import com.fortnite.api.service.FortniteApisServiceImpl;
import com.google.gson.Gson;


@RestController
public class ServiceController {
	
	@Autowired
	private FortniteApisService service;
	
	@Autowired
	private DbOperationService dbService;
	
	static final Logger logger = LoggerFactory.getLogger(FortniteApisServiceImpl.class.getName());
	static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	@RequestMapping("/userId")
	public String userId(@RequestParam(value="name", defaultValue="Ninja") String name) {
        return service.getUserId(name);
    }
	
	@RequestMapping("/brDailyStore")
	public String brDailyStore(@RequestParam(value = "storeDate", defaultValue = "01-01-1961") String storeDate){
		String dbOperation = dbService.getDataWithDate(storeDate);
		logger.info("DB Operation brDailyStore triggered! ### DB Response - {}", dbOperation);
		if(dbOperation == null) {
			return service.getStore();
		} else {
			return dbOperation;
		}
	}
	
	@RequestMapping("/upComingItems")
	public String upComingItems(){
		return service.getUpcomingItems();
	}
	
	@RequestMapping("/playerStats")
	public String playerStats(@RequestParam(value = "name", defaultValue = "Ninja") String name) {
		Gson gson = new Gson();
	    UserPojo obj  = gson.fromJson(service.getUserId(name), UserPojo.class);
		return service.getPlayerStats(obj.getUid());
	}
	
	@RequestMapping("/news")
	public String news(){
		return service.getNews();
	}
	
	@RequestMapping("/serverStatus")
	public String serverStatus(){
		return service.getServerStatus();
	}
	
	@RequestMapping("/topTen")
	public String topTen(){
		return service.getTopTen();
	}
	
	@RequestMapping("/patchNotes")
	public String patchNotes(){
		return service.getPatchNotes();
	}
	
	@RequestMapping("/BrChallenges")
	public String getBrChallenges(){
		return service.getBrChallenges();
	}
	
	@RequestMapping("/hardResetCache")
	public void clearCache(){
		service.clearCache();
	}
	
}
