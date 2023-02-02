package com.mc.transportmanager.entity;

import java.util.Date;

import org.hibernate.envers.Audited;

import com.mc.transportmanager.entity.audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Audited
@Entity
@Table(name = "Transport")
public class Transport extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(name = "employer")
	private User employer;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private double price;

	@Column
	private boolean active;

	@Column
	private boolean deleted;

	@Column
	private Date appliedDate;
}
