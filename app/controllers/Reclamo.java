package controllers;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.ReclamoEncRepository;
import play.mvc.Controller;

@Named
@Singleton
public class Reclamo extends Controller{
	private final ReclamoEncRepository reclamoRep;
	
	@Inject
	public Reclamo(ReclamoEncRepository reclamoRep){
		this.reclamoRep = reclamoRep;
	}
}
