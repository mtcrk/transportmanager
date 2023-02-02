package com.mc.transportmanager.service;

import org.springframework.stereotype.Service;

import com.mc.transportmanager.entity.Transport;
import com.mc.transportmanager.repository.TransportRepository;

@Service
public class TransportService extends GenericService<Transport> {
	public TransportService(TransportRepository transportRepository) {
		super(transportRepository);
	}
}
