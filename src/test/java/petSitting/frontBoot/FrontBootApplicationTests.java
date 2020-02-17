package petSitting.frontBoot;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.CompteRepository;
import petSitting.frontBoot.repositories.ReponseRepository;
import petSitting.frontBoot.services.ProprioService;

@SpringBootTest
class FrontBootApplicationTests {

	@Test
	void contextLoads() {
		
	}

	@Autowired
	private AnnonceRepository annonceRepository;
	@Autowired
	private ReponseRepository reponseRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ProprioService proprioService;
	
  
    


}
