package tn.altenders.poc.service.controller.client;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.altenders.poc.entities.User;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface UserClient {
	
	 @GetMapping
	 List<User> getClients();
	   
	 @GetMapping("id/{id}")
	 User getClientById(@PathVariable(required = true) Long id) throws EntitieNotFoundException;
	 
	 @PostMapping
	 User addClient(@RequestBody(required = true) User user);

}
