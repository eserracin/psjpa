package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import be.objectify.deadbolt.core.models.Role;

@Entity
public class Roles implements Role{
	
	@Id
	public Long id;
	
	public String nombreRol;
	
	@Override
	public String getName() {
		return nombreRol;
	}

}
