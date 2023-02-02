package com.mc.transportmanager.entity;

import org.hibernate.envers.Audited;

import com.mc.transportmanager.entity.audit.AnonymousAuditable;

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
@Table(name = "Company")
public class Message extends AnonymousAuditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "fromUser")
	private User fromUser;

	@ManyToOne
	@JoinColumn(name = "toUser")
	private User toUser;

	@ManyToOne
	@JoinColumn(name = "transport")
	private Transport transport;

	@Column
	private String messageContent;
}
