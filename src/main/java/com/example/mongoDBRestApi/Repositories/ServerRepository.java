package com.example.mongoDBRestApi.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.mongoDBRestApi.model.Servers;

@Repository
public interface ServerRepository extends MongoRepository<Servers,String> {

	
	public List<Servers>findByName(String serverName);
}
