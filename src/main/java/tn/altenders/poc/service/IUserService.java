package tn.altenders.poc.service;

import java.util.List;

import tn.altenders.poc.entities.User;
import tn.altenders.poc.exception.EntitieNotFoundException;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public User getUser(Long id) throws EntitieNotFoundException;

	public User addUser(User user);
	
	public User updateUser(User user);
	
}
