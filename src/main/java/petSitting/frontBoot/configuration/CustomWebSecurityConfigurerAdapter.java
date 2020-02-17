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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	//AUCUNE AUTHORISATION (POUR TESTER D'AUTRES TRUCS)
//		http.csrf().disable();
//		http.authorizeRequests().anyRequest().permitAll();
		
//		
//	//authorisations de connection
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/auth/proprio/**").hasAnyRole("proprio").
		and().authorizeRequests().antMatchers("/auth/sitter/**").hasAnyRole("sitter").
		and().authorizeRequests().antMatchers("/auth/**").authenticated().
		and().formLogin().loginPage("/connexion").permitAll().defaultSuccessUrl("/auth/menu").
		and().formLogin().loginPage("/**").permitAll();
	}

	
	@Override //methode qui permet de dire comment on s'authentifie
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
