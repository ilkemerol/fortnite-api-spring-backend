package com.fortnite.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortnite.api.repository.DbOperationsDailyItemShopRepository;

@Service
public class DbOperationServiceImpl implements DbOperationService{
	
	@Autowired
	private DbOperationsDailyItemShopRepository dbOperationDailyItemShop;

	@Override
	public String getDataWithDate(String date) {
		String response = dbOperationDailyItemShop.findData(date);
		return response;
	}

}
