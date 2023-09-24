package com.example.mongoDBRestApi.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.mongoDBRestApi.model.Servers;

//Model Repository having query methods for  execution of MongoDB.
@Repository
public interface ServerRepository extends MongoRepository<Servers,String> {

	public List<Servers>findByName(String serverName); //method for fetching server by Name.
}
