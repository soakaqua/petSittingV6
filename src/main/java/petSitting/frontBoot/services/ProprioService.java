package petSitting.frontBoot.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Annonce_Service;
import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.model.Reponse;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.ReponseRepository;

@Service
public class ProprioService {
	
	@Autowired
	private AnnonceRepository annonceRepository;
	
	@Autowired
	private ReponseRepository reponseRepository;
	
	@Autowired
	private ProprioService proprioService;

		//-----------------------------METHODES--------------------------------------
			
	public List<Annonce> afficherAnnoncesPubliees(Proprio proprio) {
		Integer numC = proprio.getNumC();
		List<Annonce> list = annonceRepository.selectAnnonceByProprio(numC);
		System.out.println(list);
		return list;
	}
		
	public void publierContenuAnnonce(String titre, String message, Proprio proprio) { //probleme avec services
		Annonce a=new Annonce();
		a.setTitre(titre);
		a.setMessage(message);
		a.setProprio(proprio);
		annonceRepository.save(a);
	}
	
	public void publierServiceAnnonce(Annonce a, Set<Annonce_Service> annonce_service) { //probleme avec services
		a.setAnnonce_service(annonce_service);
		//insert numero annonce_service 
		
		//insertion des services dans la table annonce_service
		
	}

	public void modifierContenuAnnonce(int numA, String titre, String message, Proprio proprio) { 
		Annonce a=new Annonce();
		a.setNumA(a.getNumA());
		a.setTitre(titre);
		a.setMessage(message);
		a.setNoteP(a.getNoteP());
		a.setNoteS(a.getNoteS());
		a.setStatut(a.getStatut());
		a.setProprio(a.getProprio());
		a.setAnnonce_service(a.getAnnonce_service());
		annonceRepository.save(a);
	} 

	public void modifierServicesAnnonce(Annonce a, Set<Annonce_Service> annonce_service) { //probleme avec les services
		a.setAnnonce_service(annonce_service);
		annonceRepository.save(a);
	} 

	public void supprReponsesRefusees(Annonce a, Proprio proprio) {
		Integer numC = proprio.getNumC();
		Integer numA = a.getNumA();
		System.out.println(reponseRepository);
		List<Reponse> reponses = reponseRepository.selectReponsesRefusees(numA, numC);
		for (int i=0; i<reponses.size(); i++)  
			{reponseRepository.deleteById(reponses.get(i).getKey()); }
	}

	public void validerSitter(Annonce a, Proprio proprio) {
		Integer numC = proprio.getNumC();
		Integer numA = a.getNumA();		
		a.setStatut(1);
		annonceRepository.save(a);
		proprioService.supprReponsesRefusees(a, proprio);
	}
//
//	public int noterS(Double noteS, Annonce a, Sitter s) {
//		//daoAnnonce.selectSittersByReponseValidee(a);
//		List<Integer>liste=annonceRepository.selectNoteSitter(s);
//		int somme=0;
//		for (int i=0; i<liste.size(); i++)  
//		{ somme+=liste.get(i);}
//		int moyenne=somme/(liste.size());
//		//			s.setNoteS(moyenne);
//		return moyenne;
//	}


	
	
}
