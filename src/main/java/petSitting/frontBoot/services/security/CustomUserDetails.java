package petSitting.frontBoot.services.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.model.Sitter;

public class CustomUserDetails implements UserDetails {



	private Compte compte;

	public CustomUserDetails(Compte compte) {
		this.compte = compte;
	}

	@Override
	//permet gérer les roles d'utilisateur
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities =new HashSet<>();
		if(compte instanceof Sitter) {
			authorities.add(new SimpleGrantedAuthority("sitter"));
		}
		else if (compte instanceof Proprio) {
			authorities.add(new SimpleGrantedAuthority("proprio"));
		}
//		else if (compte instanceof Admin) {
//			authorities.add(new SimpleGrantedAuthority("admin"));
//		}

		return authorities;
	}

	@Override
	public String getPassword() {
		return compte.getMdpC();
	}

	@Override
	public String getUsername() {
		return compte.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (compte.getStatut() ==1 ) {
			return true;
		}
		return false;
	}

}
