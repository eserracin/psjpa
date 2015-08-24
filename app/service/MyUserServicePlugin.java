package service;


import javax.inject.Inject;

import models.Usuario;
import play.Application;

import com.feth.play.module.pa.service.UserServicePlugin;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;

public class MyUserServicePlugin extends UserServicePlugin {

	@Inject
	public MyUserServicePlugin(final Application app) {
		super(app);
	}

	@Override
	public Object getLocalIdentity(AuthUserIdentity arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthUser link(AuthUser arg0, AuthUser arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthUser merge(AuthUser arg0, AuthUser arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save(AuthUser arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
