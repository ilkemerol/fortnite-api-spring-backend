package com.fortnite.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortnite.api.repository.DbOperationItemHistoryRepository;
import com.fortnite.api.repository.DbOperationItemRepository;
import com.fortnite.api.repository.DbOperationsDailyItemShopRepository;

@Service
public class DbOperationServiceImpl implements DbOperationService{
	
	@Autowired
	private DbOperationsDailyItemShopRepository dbOperationDailyItemShop;
	
	@Autowired
	private DbOperationItemRepository dbOperationItem;
	
	@Autowired
	private DbOperationItemHistoryRepository dbOperationItemHistory;

	@Override
	public String getDataWithDate(String date) {
		String response = dbOperationDailyItemShop.findData(date);
		return response;
	}

	@Override
	public String checkItemWithName(String itemName) {
		String response = dbOperationItem.findName(itemName);
		return response;
	}
}
