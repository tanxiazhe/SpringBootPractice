package com.archimedes.model;


import javax.persistence.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User extends BaseUser {
	@ApiModelProperty
	String userName;

}