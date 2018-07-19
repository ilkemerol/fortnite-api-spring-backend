package com.fortnite.api.db;

import org.springframework.data.repository.CrudRepository;

import com.fortnite.api.entity.ServerStatus;

public interface DbOperationsServerStatus extends CrudRepository<ServerStatus, Integer>{

}
