package com.mc.transportmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.mc.transportmanager.repository.GenericRepository;
import com.mc.transportmanager.utils.PageResponse;

public class GenericService<T> {
	@Autowired
	private GenericRepository<T> repository;

	public GenericService(GenericRepository<T> repository) {
		this.repository = repository;
	}

	public T save(T entity) {
		return repository.save(entity);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

	public T findById(long id) {
		return repository.findById(id).orElse(null);
	}

	public boolean existsById(long id) {
		return repository.existsById(id);
	}

	public PageResponse<T> findAll(PageRequest pageRequest) {
		Page<T> data = repository.findAll(pageRequest);
		return new PageResponse<>(data.getContent(), data.getTotalElements());
	}
}
