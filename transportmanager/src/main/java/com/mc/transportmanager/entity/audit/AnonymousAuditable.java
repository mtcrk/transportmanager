package com.mc.transportmanager.entity.audit;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AnonymousAuditable {
	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(updatable = false)
    protected Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column
    protected Date lastModifiedDate;
}
