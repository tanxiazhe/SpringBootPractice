package com.archimedes.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Setter
@Getter
public class Conference extends BaseModel {
	@ApiModelProperty
	private String name;
	
	@JsonManagedReference(value="conference-presentation")
	@ApiModelProperty
	@OneToMany(mappedBy= "conference",  cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Presentation> presentations = new ArrayList<Presentation>();

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(dataType = "java.sql.Timestamp")
	private Timestamp startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(dataType = "java.sql.Timestamp")
	private Timestamp endDate;



	
	
}
