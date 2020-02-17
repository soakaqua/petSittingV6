package petSitting.frontBoot.services.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Sitter;
import petSitting.frontBoot.repositories.CompteRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CompteRepository compteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Compte> listC = compteRepository.selectCompteByMail(username);
		System.out.println(listC.get(0) instanceof Sitter);
		return new CustomUserDetails(listC.get(0));

//		Optional<Compte> opt = compteRepository.selectCompteByMail(username);
//		if(opt.isPresent())	 {
//			if (opt.get() instanceof Sitter)
//			return new CustomUserDetails(opt.get());
//		}

		// throw new UsernameNotFoundException("login incorrect");
	}

}
