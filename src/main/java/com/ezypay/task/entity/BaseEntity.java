package com.ezypay.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
       value = {"createdAt", "updatedAt"},
       allowGetters = true
)
public abstract class BaseEntity<T> implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
 @SequenceGenerator(name="seq_gen", sequenceName = "seq_", allocationSize=1, initialValue = 2000)
 protected  Long id;
 protected Boolean active;
 @Column(name = "created_by")
 protected String createdBy;

 @Temporal(TemporalType.TIMESTAMP)
 @Column(name = "created_at", nullable = false, updatable = false)
 @CreatedDate
 private Date createdAt;

 @Temporal(TemporalType.TIMESTAMP)
 @Column(name = "updated_at", nullable = false)
 @LastModifiedDate
 private Date updatedAt;


}
