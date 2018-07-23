package com.fortnite.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fortnite.api.entity.DailyItemShop;

public interface DbOperationsDailyItemShopRepository extends CrudRepository<DailyItemShop, Integer>{

	@Query("SELECT d.data FROM DailyItemShop d WHERE d.date LIKE CONCAT('%',:date,'%')")
	public String findData(@Param("date") String date);
}
