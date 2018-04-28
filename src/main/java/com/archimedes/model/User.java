package com.archimedes.model;


import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity(name="NomalUser")
@Setter
@Getter
public class User extends BaseUser {

}
