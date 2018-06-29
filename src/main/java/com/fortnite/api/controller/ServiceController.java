package com.fortnite.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fortnite.api.service.FortniteApisService;


@RestController
public class ServiceController {
	
	@Autowired
	private FortniteApisService service;
	
	@RequestMapping("/userId")
	public String userId(@RequestParam(value="name", defaultValue="Ninja") String name) {
        return service.getUserId(name);
    }
	
	@RequestMapping("/brDailyStore")
	public String brDailyStore(){
		return service.getStore();
	}
	
	@RequestMapping("/upComingItems")
	public String upComingItems(){
		return service.getUpcomingItems();
	}
	
	@RequestMapping("/playerStats")
	public String playerStats(@RequestParam(value = "id",defaultValue = "1") String id) {
		return service.getPlayerStats(id);
	}

}
