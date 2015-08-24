package controllers;

import play.data.Form;
import play.mvc.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import views.html.*;


/**
 * The main set of web services.
 */
@Named
@Singleton
public class Application extends Controller {
	
	public static final String USER_ROLE = "Admin";

	@Restrict(@Group(Application.USER_ROLE))
	public Result index() {
    	return ok(index.render("Bienvenido"));
    }
    
    public Result login(){
    	return ok(login.render("Acceso al Sistema"));
    }
    
    public Result signup(){
    	return ok(signup.render("Registro de Usuario"));
    }
    
}
