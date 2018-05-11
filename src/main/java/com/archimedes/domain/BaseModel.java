package com.archimedes.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
public abstract class BaseModel {

	@JsonIgnore
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(dataType = "java.sql.Timestamp")
    @Basic(optional = false)
    @Column(insertable = true, updatable = false)
    private Timestamp createdAt;

	@JsonIgnore
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(dataType = "java.sql.Timestamp")
    @Column(insertable = false, updatable = true)
    private Timestamp updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public void setVersion(Long version) {
		this.version = version;
	}

	public Long getVersion() {
        return version;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    private void setCreatedAt(Timestamp now) {
        this.createdAt = now;
    }

    private void setUpdatedAt(Timestamp now) {
        this.updatedAt = now;
    }

    @PrePersist
    void onCreate() {
        this.setCreatedAt(now());
    }

    @PreUpdate
    void onPersist() {
        this.setUpdatedAt(now());
    }

    protected Timestamp now() {
        return new Timestamp(new Date().getTime());
    }

    public void setId(Long id) {
        // only used for tests
        this.id = id;
    }
}