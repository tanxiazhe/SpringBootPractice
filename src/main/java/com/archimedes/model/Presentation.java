package com.archimedes.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

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
	private List<Tag> tag ;
	
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
	private List<BaseUser> audiences ;

}
