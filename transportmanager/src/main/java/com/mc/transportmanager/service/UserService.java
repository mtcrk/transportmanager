package com.mc.transportmanager.service;

import org.springframework.stereotype.Service;

import com.mc.transportmanager.entity.User;
import com.mc.transportmanager.repository.UserRepository;

@Service
public class UserService extends GenericService<User> {
	public UserService(UserRepository userRepository) {
		super(userRepository);
	}
}
