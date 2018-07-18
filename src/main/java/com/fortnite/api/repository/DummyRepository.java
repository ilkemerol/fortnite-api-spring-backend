package com.fortnite.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fortnite.api.model.Dummy;

@Repository
public interface DummyRepository extends CrudRepository<Dummy,Long>{
	
}
