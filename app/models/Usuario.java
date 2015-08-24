package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.feth.play.module.pa.providers.password.UsernamePasswordAuthUser;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;
import com.feth.play.module.pa.user.EmailIdentity;

import play.data.validation.*;
import play.data.format.*;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Constraints.Email
	public String email;
	
	public String name;
	
	public String firstname;
	
	public String lastname;
	
	public byte activo;
	
	@Formats.DateTime(pattern = "dd-MM-yyyy HH:mm:ss")
	public Date ultimoAcceso;
	
	public byte emailValido;
	
	
	public static Usuario findByAuthUserIdentity(final AuthUserIdentity identity) {
		if (identity == null) {
			return null;
		}

		if (identity instanceof UsernamePasswordAuthUser) {
			return findByUsernamePasswordIdentity((UsernamePasswordAuthUser) identity);
		} else {
			//return getAuthUserFind(identity).findUnique();
			return null;
		}
	}
	
	
	public static Usuario findByUsernamePasswordIdentity(final UsernamePasswordAuthUser identity) {
		return null;
		//return getUsernamePasswordAuthUserFind(identity).findUnique();
	}
	
	public static Usuario crear(final AuthUser authUser){
		final Usuario usuario = new Usuario();
		
		usuario.activo = 1;
		usuario.ultimoAcceso = new Date();
		
		if (authUser instanceof EmailIdentity){
			final EmailIdentity emailIdentity = (EmailIdentity)authUser;
			
			usuario.email = emailIdentity.getEmail();
			usuario.emailValido = 0;
		}
		
		usuario.
		
		return null;
	}
	
	/*
	private static ExpressionList<Usuario> getAuthUserFind(
			final AuthUserIdentity identity) {
		return find.where().eq("active", true)
				.eq("linkedAccounts.providerUserId", identity.getId())
				.eq("linkedAccounts.providerKey", identity.getProvider());
	}
	*/

}
