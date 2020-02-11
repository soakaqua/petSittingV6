package petSitting.frontBoot.services.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.repositories.CompteRepository;

//@Service
//public class CustomUserDetailsService implements UserDetailsService{
//
//	@Autowired
//	private CompteRepository compteRepository;
//
////	@Override
////	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		Optional<Compte> optC = compteRepository.findByMail();
////		Optional<String> opt = compteRepository.selectTypeCompte(optC.get().getNumC());
////		if(opt.isPresent())	 {
////			return new CustomUserDetails(opt.get());
////		}
////		throw new UsernameNotFoundException("login incorrect");
////	}

//}
