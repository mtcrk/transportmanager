package com.mc.transportmanager.api.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.transportmanager.entity.Message;
import com.mc.transportmanager.service.MessageService;
import com.mc.transportmanager.utils.PageRequest;
import com.mc.transportmanager.utils.PageResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping()
	public ResponseEntity<PageResponse<Message>> get(PageRequest pageRequest) {
		return ResponseEntity.ok(messageService.findAll(pageRequest.get()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> get(@PathParam("id") long id) {
		Message message = messageService.findById(id);
		if (message != null) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Message> insert(@RequestBody Message message) {
		return ResponseEntity.ok(messageService.save(message));
	}

	@PutMapping()
	public ResponseEntity<Message> update(@RequestBody Message message) {
		if (messageService.existsById(message.getId())) {
			return ResponseEntity.ok(messageService.save(message));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Message> delete(@PathParam("id") long id) {
		Message message = messageService.findById(id);
		if (message != null) {
			messageService.delete(message);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
