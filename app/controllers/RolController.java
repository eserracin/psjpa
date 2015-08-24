package controllers;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.RolesRepository;
import play.Logger;
import play.mvc.Controller;

@Named
@Singleton
public class RolController extends Controller{

	private final RolesRepository rolesRep;
	
	@Inject
	public RolController(RolesRepository rolesRep){
		this.rolesRep = rolesRep;
	}

}
