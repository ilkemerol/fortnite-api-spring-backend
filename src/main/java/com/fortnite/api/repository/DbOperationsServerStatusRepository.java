package com.fortnite.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.fortnite.api.entity.ServerStatus;

public interface DbOperationsServerStatusRepository extends CrudRepository<ServerStatus, Integer>{

}
