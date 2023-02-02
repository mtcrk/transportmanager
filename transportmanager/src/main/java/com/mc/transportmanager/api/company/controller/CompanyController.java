package com.mc.transportmanager.api.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.transportmanager.entity.Company;
import com.mc.transportmanager.service.CompanyService;
import com.mc.transportmanager.utils.PageRequest;
import com.mc.transportmanager.utils.PageResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping()
	public ResponseEntity<PageResponse<Company>> get(PageRequest pageRequest) {
		return ResponseEntity.ok(companyService.findAll(pageRequest.get()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> get(@PathParam("id") long id) {
		Company company = companyService.findById(id);
		if (company != null) {
			return ResponseEntity.ok(company);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping()
	public ResponseEntity<Company> insert(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.save(company));
	}

	@PutMapping()
	public ResponseEntity<Company> update(@RequestBody Company company) {
		if (companyService.existsById(company.getId())) {
			return ResponseEntity.ok(companyService.save(company));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Company> delete(@PathParam("id") long id) {
		Company company = companyService.findById(id);
		if (company != null) {
			companyService.delete(company);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
