package com.mc.transportmanager.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.transportmanager.entity.User;
import com.mc.transportmanager.service.UserService;
import com.mc.transportmanager.utils.PageRequest;
import com.mc.transportmanager.utils.PageResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public ResponseEntity<PageResponse<User>> get(PageRequest pageRequest) {
		return ResponseEntity.ok(userService.findAll(pageRequest.get()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathParam("id") long id) {
		User user = userService.findById(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<User> insert(@RequestBody User user) {
		return ResponseEntity.ok(userService.save(user));
	}

	@PutMapping()
	public ResponseEntity<User> update(@RequestBody User user) {
		if (userService.existsById(user.getId())) {
			return ResponseEntity.ok(userService.save(user));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathParam("id") long id) {
		User user = userService.findById(id);
		if (user != null) {
			userService.delete(user);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
