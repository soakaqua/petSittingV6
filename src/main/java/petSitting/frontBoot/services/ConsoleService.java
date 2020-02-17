package petSitting.frontBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Sitter;
import petSitting.frontBoot.repositories.CompteRepository;
//implements et service : déléguer gestion console à spring. => point d'entrée dans programme ici.
@Service
public class ConsoleService implements CommandLineRunner{


	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	CompteService compteService;

	@Autowired
	CompteRepository compteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world par springBoot");
		System.out.println(passwordEncoder.encode("1"));

//		Sitter s = new Sitter();
//		s.setMail("1@1");
//		s.setMdpC("1");
//		compteService.save(s);
		
		 System.out.println(compteRepository.findById(100).get() instanceof Sitter);
	}

	
	
}
