package tn.altenders.poc.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.altenders.poc.entities.User;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.service.IUserService;
import tn.altenders.poc.service.controller.client.UserClient;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController implements UserClient {

	IUserService userService;
	
	@Autowired
	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public List<User> getClients() {
		return userService.getAllUsers();
	}

	@Override
	public User getClientById(Long id) throws EntitieNotFoundException {
		return userService.getUser(id);
	}

	@Override
	public User addClient(User user) {
		return userService.addUser(user);
	}
	

}
