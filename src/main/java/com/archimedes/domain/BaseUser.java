package com.archimedes.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;



//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "BUTYPE", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("BASEUSER")
@Entity
@Setter
@Getter
public class BaseUser extends BaseModel{

	@ApiModelProperty
	private String firstName;
	
	@ApiModelProperty
	private String lastName;
	
	@ApiModelProperty
	private String phone;

	@JsonManagedReference(value="baseUser-tag")
	@ApiModelProperty
    @OneToMany(mappedBy="baseUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Tag> tag = new ArrayList<Tag>();
	
//used when type is audience
	@ManyToMany
    @JoinTable(name="audience_presentation",joinColumns=@JoinColumn(name="audience_id"),
            inverseJoinColumns=@JoinColumn(name="presentation_id"))
    private List<Presentation> presentations = new ArrayList<Presentation>();

	@ApiModelProperty
	private String type;
	
	@ApiModelProperty
	private String password;
}
