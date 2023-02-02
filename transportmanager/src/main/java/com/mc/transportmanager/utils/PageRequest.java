package com.mc.transportmanager.utils;

import org.springframework.data.domain.Sort.Direction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageRequest {
	private int page;
	private int size;
	private String sortField;
	private String sortOrder;

	public org.springframework.data.domain.PageRequest get() {
		if (size == 0) {
			size = 10;
		}
		if (sortField == null) {
			sortField = "id";
		}
		if (sortOrder == null) {
			sortOrder = "DESC";
		}
		return org.springframework.data.domain.PageRequest.of(page, size, Direction.fromString(sortOrder), sortField);
	}
}
