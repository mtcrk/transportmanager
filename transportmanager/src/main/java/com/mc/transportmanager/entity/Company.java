package com.mc.transportmanager.entity;

import org.hibernate.envers.Audited;

import com.mc.transportmanager.entity.audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Audited
@Entity
@Table(name = "Company")
public class Company extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column
	private boolean active;

	@Column
	private boolean deleted;
}
