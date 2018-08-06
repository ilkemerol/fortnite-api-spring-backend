package com.fortnite.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.fortnite.api.entity.ItemHistoryEntity;

public interface DbOperationItemHistoryRepository extends CrudRepository<ItemHistoryEntity, Integer> {

}
