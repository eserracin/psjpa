package common;

import java.util.Arrays;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Roles;
import models.RolesRepository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.PlayAuthenticate.Resolver;
import controllers.routes;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.mvc.Call;

public class MyGlobal extends GlobalSettings {
	
    /**
     * Declare the application context to be used - a Java annotation based application context requiring no XML.
     */
    final private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    
    /**
     * The name of the persistence unit we will be using.
     */
    static final String DEFAULT_PERSISTENCE_UNIT = "default";
    

    @Override
    public void onStart(Application application) {
    	Logger.info("***ESE: Iniciado Aplicacion *****");
    	super.onStart(application);
    	
    	PlayAuthenticate.setResolver(new Resolver() {
			
			@Override
			public Call login() {
				// TODO Auto-generated method stub
				return routes.Application.login();
			}
			
			@Override
			public Call auth(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Call askMerge() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Call askLink() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Call afterLogout() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Call afterAuth() {
				// TODO Auto-generated method stub
				return null;
			}
		});
    	
        ctx.register(SpringDataJpaConfiguration.class);
        ctx.scan("controllers", "models");
        ctx.refresh();
        
        // This will construct the beans and call any construction lifecycle methods e.g. @PostConstruct
        ctx.start();
        
        
        
    }

    @Override
    public void onStop(Application application) {
    	Logger.info("***ESE: Finalizando Aplicacion *****");
    	ctx.close();
        super.onStop(application);
    }
    
    /**
     * This configuration establishes Spring Data concerns including those of JPA.
     */
    @Configuration
    @EnableJpaRepositories("models")
    public static class SpringDataJpaConfiguration {

        @Bean
        public EntityManagerFactory entityManagerFactory() {
            return Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT);
        }

        @Bean
        public HibernateExceptionTranslator hibernateExceptionTranslator() {
            return new HibernateExceptionTranslator();
        }

        @Bean
        public JpaTransactionManager transactionManager() {
            return new JpaTransactionManager();
        }
    }
    
}