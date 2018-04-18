package com.archimedes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conference {
	@Id
	Long id;
	
	String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
