package petSitting.frontBoot.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Annonce_Service;
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
			
	public List<Annonce> afficherAnnoncesPubliees(Integer numC) {
		List<Annonce> list = annonceRepository.selectAnnonceByProprio(4);
		System.out.println(list);
		return list;
	}
		
	public void publierContenuAnnonce(String titre, String message, int numC) { //probleme avec services
		Annonce a=new Annonce();
		a.setTitre(titre);
		a.setMessage(message);
		a.setNumC(numC);
		annonceRepository.save(a);
	}
	
	public void publierServiceAnnonce(Annonce a, Set<Annonce_Service> annonce_service) { //probleme avec services
		a.setListService(annonce_service);
		//insert numero annonce_service 
		
		//insertion des services dans la table annonce_service
		
	}

	public void modifierContenuAnnonce(int numA, String titre, String message) { 
		Annonce a=new Annonce();
		a.setNumA(a.getNumA());
		a.setTitre(titre);
		a.setMessage(message);
		a.setNoteP(a.getNoteP());
		a.setNoteS(a.getNoteS());
		a.setStatut(a.getStatut());
		a.setNumC(a.getNumC());
		a.setListService(a.getListService());
		annonceRepository.save(a);
	} 

	public void modifierServicesAnnonce(Annonce a, Set<Annonce_Service> annonce_service) { //probleme avec les services
		a.setListService(annonce_service);
		annonceRepository.save(a);
	} 

	public void supprReponsesRefusees(Integer numA, Integer numC) {
		System.out.println(reponseRepository);
		List<Reponse> reponses = reponseRepository.selectReponsesRefusees(numA, numC);
		for (int i=0; i<reponses.size(); i++)  
			{reponseRepository.deleteById(reponses.get(i).getKey()); }
	}

	public void validerSitter(Integer numA, Integer numC) {
		Optional<Annonce> opt=annonceRepository.findById(numA);
		Annonce annonceEnBase=new Annonce();
		if(opt.isPresent()) {
			annonceEnBase = opt.get();			
			annonceEnBase.setStatut(1);
			annonceRepository.save(annonceEnBase);
			proprioService.supprReponsesRefusees(numA, numC);
		}
		else {System.out.println("Erreur, annonce non presente en base");}
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
