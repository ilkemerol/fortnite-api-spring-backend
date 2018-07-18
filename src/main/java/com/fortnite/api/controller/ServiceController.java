package com.fortnite.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fortnite.api.model.Dummy;
import com.fortnite.api.model.UserPojo;
import com.fortnite.api.repository.DummyRepository;
import com.fortnite.api.service.FortniteApisService;
import com.google.gson.Gson;


@RestController
public class ServiceController {
	
	@Autowired
	private FortniteApisService service;
	
	@Autowired
	private DummyRepository dummyRepository;
	
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
	
	@RequestMapping("/saveDummyText")
	public void saveDummyText(){
			Dummy dummy1 = new Dummy();
			dummy1.setTextdummy("emredummy2");
			dummyRepository.save(dummy1);
	}

}
