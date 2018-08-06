package com.fortnite.api.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fortnite.api.entity.ItemsEntity;

public interface DbOperationItemRepository extends CrudRepository<ItemsEntity, Integer> {

	@Query("SELECT i.name FROM ItemsEntity i WHERE i.name = :itemName")
	public String findName(@Param("itemName") String itemName);
}
