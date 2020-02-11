package petSitting.frontBoot;

import static org.junit.Assert.assertNotNull;

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

<<<<<<< HEAD
	@Test
	void contextLoads() {
		
	}
=======
	@Autowired
	private AnnonceRepository annonceRepository;
	@Autowired
	private ReponseRepository reponseRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ProprioService proprioService;
	
    //@Test
    public void testSelectAllWithStatut0() {
    	List<Annonce> list = annonceRepository.selectAnnonceByProprio(10);
        System.out.println(list);
    }
    
>>>>>>> master

}
