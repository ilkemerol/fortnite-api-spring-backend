package com.fortnite.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortnite.api.db.DbOperationsDailyItemShop;
import com.fortnite.api.entity.DailyItemShop;

@Service
public class DbOperationServiceImpl implements DbOperationService{
	
	@Autowired
	private DbOperationsDailyItemShop dbOperationDailyItemShop;

	@Override
	public String getDataWithDate(String date) {
		String response = dbOperationDailyItemShop.findData(date);
		return response;
	}

}
