package com.mc.transportmanager.api.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.transportmanager.entity.Transport;
import com.mc.transportmanager.service.TransportService;
import com.mc.transportmanager.utils.PageRequest;
import com.mc.transportmanager.utils.PageResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/transports")
public class TransportController {

	@Autowired
	private TransportService transportService;

	@GetMapping()
	public ResponseEntity<PageResponse<Transport>> get(PageRequest pageRequest) {
		return ResponseEntity.ok(transportService.findAll(pageRequest.get()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transport> get(@PathParam("id") long id) {
		Transport transport = transportService.findById(id);
		if (transport != null) {
			return ResponseEntity.ok(transport);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Transport> insert(@RequestBody Transport transport) {
		return ResponseEntity.ok(transportService.save(transport));
	}

	@PutMapping()
	public ResponseEntity<Transport> update(@RequestBody Transport transport) {
		if (transportService.existsById(transport.getId())) {
			return ResponseEntity.ok(transportService.save(transport));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Transport> delete(@PathParam("id") long id) {
		Transport transport = transportService.findById(id);
		if (transport != null) {
			transportService.delete(transport);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
