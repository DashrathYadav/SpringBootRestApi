package com.example.mongoDBRestApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Document(collection="Servers")
public class Servers {

	@Id
	public String id;
	public String name;
	public String language;
	public String framework;

	
	
}


//{
//“name”: ”my centos”,
//“id”: “123”,
//“language”:”java”,
//“framework”:”django”
//}