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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Audited
@Entity
@Table(name = "Users")
public class User extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String email;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private int score;

	@Column
	private Date lastLoginDate;

	@Column
	private boolean banned;

	@Column
	private Date banDate;

	@Column
	private boolean active;

	@Column
	private boolean deleted;

	@ManyToOne
	@JoinColumn(name = "company")
	private Company company;
}
