package com.example.mongoDBRestApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// Schema  of server Object.
@Setter
@Getter
@AllArgsConstructor
@Document(collection="Servers")
public class Servers {

	@Id
	public String id;			// Server Id
	public String name;			// Server Name
	public String language;		// Server in which Language
	public String framework;	// Server based on which frame work

	
	
}
