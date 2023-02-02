package com.mc.transportmanager.api.truck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.transportmanager.entity.Truck;
import com.mc.transportmanager.service.TruckService;
import com.mc.transportmanager.utils.PageRequest;
import com.mc.transportmanager.utils.PageResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/trucks")
public class TruckController {

	@Autowired
	private TruckService truckService;

	@GetMapping()
	public ResponseEntity<PageResponse<Truck>> get(PageRequest pageRequest) {
		return ResponseEntity.ok(truckService.findAll(pageRequest.get()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Truck> get(@PathParam("id") long id) {
		Truck truck = truckService.findById(id);
		if (truck != null) {
			return ResponseEntity.ok(truck);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Truck> insert(@RequestBody Truck truck) {
		return ResponseEntity.ok(truckService.save(truck));
	}

	@PutMapping()
	public ResponseEntity<Truck> update(@RequestBody Truck truck) {
		if (truckService.existsById(truck.getId())) {
			return ResponseEntity.ok(truckService.save(truck));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Truck> delete(@PathParam("id") long id) {
		Truck truck = truckService.findById(id);
		if (truck != null) {
			truckService.delete(truck);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
