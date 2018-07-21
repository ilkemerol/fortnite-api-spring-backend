package com.fortnite.api.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fortnite.api.entity.DailyItemShop;

public interface DbOperationsDailyItemShop extends CrudRepository<DailyItemShop, Integer>{

	@Query("SELECT d.data FROM DailyItemShop d WHERE d.date LIKE CONCAT('%',:date,'%')")
	public String findData(@Param("date") String date);
}
