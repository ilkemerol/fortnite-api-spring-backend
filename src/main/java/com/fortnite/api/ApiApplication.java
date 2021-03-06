package com.fortnite.api;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

@SpringBootApplication
@ComponentScan
@EnableCaching
@EnableScheduling
public class ApiApplication {

	@PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Istanbul"));
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}