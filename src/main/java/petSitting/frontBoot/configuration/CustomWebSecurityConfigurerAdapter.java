package petSitting.frontBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	DataSource dataSource;
	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	//AUCUNE AUTHORISATION (POUR TESTER D'AUTRES TRUCS)
		http.csrf().disable();
		http.authorizeRequests().anyRequest().permitAll();
		
	//AUTHENTIFICATION PAR LOGIN/PWD	
//		http.csrf().disable();
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	
	//FERMETURE DES AUTHORISATIONS
		
//	//authorisations de l'admin
//		http.authorizeRequests().antMatchers("/auth/admin/**").hasAnyRole("ADMIN").
//			and().formLogin().loginPage("/login").
//	//les url suivants obligent à être authentifié
//			and().authorizeRequests().antMatchers("/auth/**").authenticated().
//			and().formLogin().loginPage("/login").permitAll().
//			and().logout().logoutSuccessUrl("/");
//	//OU peuvent accéder partout
//		 	and().authorizeRequests().antMatchers("/**").permitAll();	
	}
	
	@Override //methode qui permet de dire comment on s'authentifie
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// POUR FAIRE DU WEB : OPTIONS DE SECURITE
		
	//METHODE 1 : authentification en mémoire -------------------------------------------------------------------------
		
//		auth.inMemoryAuthentication().withUser("singleton").password("{noop}pwd").roles("MAIRE");  
		
	//METHODE 2 : passer par une requête sql (jdbc) -------------------------------------------------------------------
		
//		auth.jdbcAuthentication()
//		.dataSource(dataSource) //datasource : définit la base de donnée à ut 
//		.usersByUsernameQuery("select username, password, enable from login where username=?") //users : récupère les infos de l'utilisateur
//		.authoritiesByUsernameQuery("select username, role from roles where username=?") ; //authoriries : roles de l'utilisateur (souvent plusieurs)
		
	//METHODE 3 : passer par un service géré par Spring ---------------------------------------------------------------
		
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		//avec l'id, doit remonter toutes les infos utilisées pour l'identifier
		//envoie les infos au gestionnaire d'authentification
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
}
