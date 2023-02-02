package com.mc.transportmanager.service;

import org.springframework.stereotype.Service;

import com.mc.transportmanager.entity.Truck;
import com.mc.transportmanager.repository.TruckRepository;

@Service
public class TruckService extends GenericService<Truck> {
	public TruckService(TruckRepository truckRepository) {
		super(truckRepository);
	}
}
