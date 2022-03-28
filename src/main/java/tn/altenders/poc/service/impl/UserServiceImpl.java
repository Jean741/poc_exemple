package tn.altenders.poc.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.altenders.poc.entities.User;
import tn.altenders.poc.exception.EntitieNotFoundException;
import tn.altenders.poc.repository.UserRepository;
import tn.altenders.poc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long id) throws EntitieNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			logger.error("User with id {} not found ", id);
			throw new EntitieNotFoundException(String.format("User with id %d not found", id));
		}
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
