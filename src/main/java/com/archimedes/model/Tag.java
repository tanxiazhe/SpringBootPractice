package com.archimedes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Setter
@Getter
public class Tag  extends BaseModel{
	
	private String name;
	
	@JsonBackReference
	@ManyToOne( fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn (name="presentation_id",referencedColumnName="id",nullable=false,unique=true)
	private Presentation presentation;
	
	
	@JsonBackReference
	@ManyToOne( fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn (name="baseUser_id",referencedColumnName="id",nullable=false,unique=true)
	private BaseUser baseUser;
	

}