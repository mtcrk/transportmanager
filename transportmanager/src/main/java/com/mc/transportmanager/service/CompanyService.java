package com.mc.transportmanager.service;

import org.springframework.stereotype.Service;

import com.mc.transportmanager.entity.Company;
import com.mc.transportmanager.repository.CompanyRepository;

@Service
public class CompanyService extends GenericService<Company>  {
	public CompanyService(CompanyRepository companyRepository) {
		super(companyRepository);
	}
}
