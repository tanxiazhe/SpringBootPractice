package com.archimedes.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Presentation  extends BaseModel{
	@ApiModelProperty
	private String title;
	
	@ApiModelProperty
	private String content;
	
	@ApiModelProperty
	private String location;
	
	@JsonManagedReference(value="presentation-tag")
	@ApiModelProperty
	@OneToMany( mappedBy = "presentation" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Tag> tag  = new ArrayList<Tag>();
	
	@ApiModelProperty
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private BaseUser speaker;
	
	@ApiModelProperty(dataType = "java.sql.Timestamp")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp startDate;
	
	@ApiModelProperty(dataType = "java.sql.Timestamp")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp endDate;
	
	@JsonBackReference(value="conference-presentation")
	@ApiModelProperty
	@ManyToOne( fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn (name="conference_id",referencedColumnName="id",nullable=false,unique=true)
	private Conference conference;

	@ManyToMany( mappedBy = "presentations" )
	private List<BaseUser> audiences =new ArrayList<BaseUser>();

}
