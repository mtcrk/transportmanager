package com.mc.transportmanager.entity;

import org.hibernate.envers.Audited;

import com.mc.transportmanager.entity.audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Audited
@Entity
@Table(name = "Truck")
public class Truck extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String licensePlate;

	@ManyToOne
	@JoinColumn(name = "company")
	private Company company;

	@OneToOne
	@JoinColumn(name = "driver")
	private User driver;

	@Column
	private boolean active;

	@Column
	private boolean deleted;
}
