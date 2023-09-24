package com.example.mongoDBRestApi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mongoDBRestApi.Repositories.ServerRepository;
import com.example.mongoDBRestApi.model.Servers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//Controller Class 
//Consist of all the Api interface for entraction--
//of other program with this server.
// Services Provided : --> 1)Retrive single server by server id
					//  : --> 2)Retrive single server by server name
					// --> 3) Retrive All server 
					// --> 4) Save / add single server 
					// --> 5) Update Server by Id
					// --> 6) Delete Server by Id
@RestController
public class MyController {
	
	
	@Autowired
	private ServerRepository serverRepo;
	
	//Just to check actuly working
	//returning single server obj 
	@GetMapping("/")
	public String homePage() {
		return "Hello Azure Cloud";
	}

	// fetch single server by id
	@CrossOrigin(origins="http://localhost:5173")		// handling cors policy for frontend
	@GetMapping("/Servers/{serverId}")
	public  ResponseEntity<?> getServers(@PathVariable String serverId)
	{
		//fetch server by incoming id.
		try {
			Optional<Servers> server= this.serverRepo.findById(serverId);
			System.out.println("server found is "+ server);
			
			if(server.isPresent())
			return new ResponseEntity<Optional<Servers>>(server,HttpStatus.OK);
			else
				return new ResponseEntity<>(" Requested Server Not Found with id "+serverId,HttpStatus.NOT_FOUND);
		}
		// if exception is thrown/ wrong id
		catch(Exception e)
		{
			return new ResponseEntity<>("Failed to fetch server",HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	// fetch servers by server name.
	//returning Response of List of servers 
	@CrossOrigin(origins="http://localhost:5173")
	@GetMapping("/Servers/name/{serverName}")
	public  ResponseEntity<?> getServersByName(@PathVariable String serverName)
	{
		
		List<Servers>serverList;
			
		try {
			serverList= this.serverRepo.findByName(serverName);			// finding by name 
			System.out.println("servers found  "+ serverList);
			
			if(serverList.size() >0)
			return new ResponseEntity<List<Servers>>(serverList,HttpStatus.OK);
			else
				return new ResponseEntity<>(" Bad Requested Server Not Found with name "+serverName,HttpStatus.NOT_FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failed to fetch server",HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	// fetch all server from mongoDB.
	// returns the Response of list of all servers.
	@CrossOrigin(origins="http://localhost:5173")
	@GetMapping("/Servers")
	public  ResponseEntity<?> getServers()
	{
		List<Servers>servers=null;
		
		System.out.println("path hit");
		try {
		 servers= this.serverRepo.findAll(); // fetch all server
		 
		 if(servers.size() >0)
			 return new ResponseEntity<List<Servers>>(servers,HttpStatus.OK);
		 else
			 return new ResponseEntity<>("Fetch successfull but no Server Found",HttpStatus.NOT_FOUND);			 
		 
		}
		catch(Exception e){
			 return new ResponseEntity<>("Servers not found or Internal Porblem occur",HttpStatus.NOT_FOUND);
		}
	}
	
	
	//  add single server to the mongodb
	// takes server obj as input(request body)
	@CrossOrigin(origins="http://localhost:5173")
	@PostMapping("/Servers")
	public ResponseEntity<?>addServer(@RequestBody Servers server)
	{	System.out.println("server post hit");
		try {			
			System.out.println("\nserver names "+server.name+"\n server id "+server.id+"\n server framework "+server.framework);
			serverRepo.save(server);// save Server
			return new ResponseEntity<Servers>(server,HttpStatus.OK);
		}
		catch(Exception e){
			System.out.println(e);
			return new ResponseEntity<>("Failed to add server",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
//	update server with given id
//  takes server id &  obj as input(request body)
	@CrossOrigin(origins="http://localhost:5173")
	@PutMapping("/Servers/{serverId}")
	public ResponseEntity<?> updateServer(@PathVariable String serverId,@RequestBody Servers newServer)
	{
		
		try {
			// fetch Servet which is to be update
			Optional<Servers> server= this.serverRepo.findById(serverId);
			System.out.println("server found is "+ server);
			
			
			if(server.isPresent())
			{
				Servers serverToSave = server.get();
				
				// checking if not null and not empty  field then update.
				serverToSave.framework= newServer.framework !=null  ? newServer.framework != "" ? newServer.framework: serverToSave.framework : serverToSave.framework;
				serverToSave.language= newServer.language !=null ? newServer.language != "" ? newServer.language: serverToSave.language : serverToSave.language;
				serverToSave.name= newServer.name !=null ? newServer.name != "" ? newServer.name: serverToSave.name : serverToSave.name;
				
				serverRepo.save(serverToSave);//save update
				
				return new ResponseEntity<Servers>(serverToSave,HttpStatus.OK);
			}
			else
				return new ResponseEntity<>("Bad Requested Server with id  "+ serverId+ "  for Update  Not Found",HttpStatus.NOT_FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failed to Update ,Internal server error server",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// Delete server of given id
	// returns status of Deletion success or failed
	@CrossOrigin(origins="http://localhost:5173")
	@DeleteMapping("/Servers/{serverId}")
	public ResponseEntity<?> deleteServer(@PathVariable String serverId)
	{
		
		try {
			
			serverRepo.deleteById(serverId);//delete 
			return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failed to Delete, Server not Found",HttpStatus.NOT_FOUND);
		}
		
	}
	
}
