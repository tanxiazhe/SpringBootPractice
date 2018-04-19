package com.archimedes.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "BUTYPE", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("BASEUSER")

public class BaseUser extends BaseModel{

	@ApiModelProperty
	private String firstName;
	
	@ApiModelProperty
	private String lastName;
	
	@ApiModelProperty
	private String phone;

	@ApiModelProperty
    @OneToMany(mappedBy="baseUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Tag> tag;
//used when type is audience
	@ManyToMany
    @JoinTable(name="audience_presentation",joinColumns=@JoinColumn(name="audience_id"),
            inverseJoinColumns=@JoinColumn(name="presentation_id"))
    private List<Presentation> presentations = new ArrayList<>();

	@ApiModelProperty
	private String type;
}
