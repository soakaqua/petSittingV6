<<<<<<< HEAD
//package petSitting.frontBoot.services;
//
//import java.util.Iterator;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import petSitting.frontBoot.model.Annonce;
//import petSitting.frontBoot.model.Annonce_Service;
//import petSitting.frontBoot.model.Annonce_ServicePK;
//import petSitting.frontBoot.repositories.AnnonceRepository;
//import petSitting.frontBoot.repositories.Annonce_ServiceRepository;
//
//@Service
//public class AnnonceService2 {
//	
//	@Autowired
//	private AnnonceRepository annonceRepository;
//	
//	
//	public Annonce save(Annonce c) {
//		
//		//int numA, String titre, String message, Double noteP, Double noteS, int statut, int numC, Set<Annonce_Service>  annonce_service
//		
//		Annonce annonceEnBase = null;
//		if(c.getNumA()!=null) {
//			Optional<Annonce> opt = annonceRepository.findById(c.getNumA());
//			annonceEnBase = opt.get();
//			annonceEnBase.setTitre((c.getTitre()!=null)?c.getTitre():annonceEnBase.getTitre());
//			annonceEnBase.setMessage((c.getMessage()!=null)?c.getMessage():annonceEnBase.getMessage());
//			annonceEnBase.setNoteP((c.getNoteP()!=null)?c.getNoteP():annonceEnBase.getNoteP());
//			annonceEnBase.setNoteS((c.getNoteS()!=null)?c.getNoteS():annonceEnBase.getNoteS());
//		//	annonceEnBase.setNumC((c.getNumA()!=null)?c.getNumC():annonceEnBase.getNumC());
////			annonceEnBase.setAnnonce_service((c.getNumC()!=null)?c.getAnnonce_service():annonceEnBase.getAnnonce_service());
//			annonceRepository.save(annonceEnBase);
//			return annonceEnBase;
//		}
//		else {
//			annonceRepository.save(c);
//			return c;
//		}
=======
package petSitting.frontBoot.services;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Annonce_Service;
import petSitting.frontBoot.model.Annonce_ServicePK;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.Annonce_ServiceRepository;

@Service
public class AnnonceService2 {
	
	@Autowired
	private AnnonceRepository annonceRepository;
	
	
	public Annonce save(Annonce c) {
		
		//int numA, String titre, String message, Double noteP, Double noteS, int statut, int numC, Set<Annonce_Service>  annonce_service
		
		Annonce annonceEnBase = null;
		if(c.getNumA()!=null) {
			Optional<Annonce> opt = annonceRepository.findById(c.getNumA());
			annonceEnBase = opt.get();
			annonceEnBase.setTitre((c.getTitre()!=null)?c.getTitre():annonceEnBase.getTitre());
			annonceEnBase.setMessage((c.getMessage()!=null)?c.getMessage():annonceEnBase.getMessage());
			annonceEnBase.setNoteP((c.getNoteP()!=null)?c.getNoteP():annonceEnBase.getNoteP());
			annonceEnBase.setNoteS((c.getNoteS()!=null)?c.getNoteS():annonceEnBase.getNoteS());
			annonceEnBase.setProprio((c.getProprio()!=null)?c.getProprio():annonceEnBase.getProprio());
//			annonceEnBase.setAnnonce_service((c.getNumC()!=null)?c.getAnnonce_service():annonceEnBase.getAnnonce_service());
			annonceRepository.save(annonceEnBase);
			return annonceEnBase;
		}
		else {
			annonceRepository.save(c);
			return c;
		}
		
	}
		//-----------------------------METHODES--------------------------------------
		
//		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		
//	public List<Annonce> afficherAnnoncesPubliees(Integer numC) {
//		List<Annonce> list = annonceRepository.selectAnnonceByProprio(4);
//		System.out.println(list);
//		return list;
//	}
>>>>>>> master
//		
//	}
//		//-----------------------------METHODES--------------------------------------
//		
////		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
//		
////	public List<Annonce> afficherAnnoncesPubliees(Integer numC) {
////		List<Annonce> list = annonceRepository.selectAnnonceByProprio(4);
////		System.out.println(list);
////		return list;
////	}
////		
////	public static void publierContenuAnnonce(String titre, String message, int numC) { //probleme avec services
////		Annonce a=new Annonce();
////		a.setTitre(titre);
////		a.setMessage(message);
////		a.setNumC(numC);
////		annonceRepository.save(a);
////	}
//	
////
////
////	public static void modifierContenuAnnonce(int numA, String titre, String message) { 
////		Annonce a=new Annonce();
////		a.setNumA(a.getNumA());
////		a.setTitre(titre);
////		a.setMessage(message);
////		a.setNoteP(a.getNoteP());
////		a.setNoteS(a.getNoteS());
////		a.setStatut(a.getStatut());
////		a.setNumC(a.getNumC());
////		a.setListService(a.getListService());
////		annonceRepository.save(a);
////	} 
////
////	public static void modifierServicesAnnonce(Annonce a, Set<Annonce_Service> annonce_service) { //probleme avec les services
////		a.setListService(annonce_service);
////		annonceRepository.save(a);
////	} 
//
////	public void supprReponsesRefusees(Annonce a) {
////		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
////		int bonNumA=a.getNumA();
////		List<Reponse> reponses = null;
////		Query query = ctx.createQuery("from Reponse r where r.numA!=bonNumA");
////		reponses = query.getResultList();
////		for (int i=0; i<reponses.size(); i++)  
////		{annonceRepository.delete(reponses.get(i)); }
////		ctx.close();
////	}
//
////	public void validerSitter(Annonce a) {
////		a.setStatut(1);
////		annonceRepository.save(a);
////		supprReponsesRefusees(a);
////	}
//
////	public int noterS(Double noteS, Annonce a, Sitter s) {
////		//daoAnnonce.selectSittersByReponseValidee(a);
////		List<Integer>liste=annonceRepository.selectNoteSitter(s);
////		int somme=0;
////		for (int i=0; i<liste.size(); i++)  
////		{ somme+=liste.get(i);}
////		int moyenne=somme/(liste.size());
////		//			s.setNoteS(moyenne);
////		return moyenne;
////	}
//
//	
//// ----------------------------------------------------------------------
//// ------------------------- Partie GAEL --------------------------------
//// ----------------------------------------------------------------------
//	@Autowired
//	private Annonce_ServiceRepository annonceServiceRepository;
//	
//	
//	public void publierServiceAnnonce(Annonce a, Set<Annonce_Service> annonce_service) { //probleme avec services
//		a.setListService(annonce_service);
//		
//		//save a 
////		a= save(a);
//		
//		//insertion des services dans la table annonce_service
//	      Iterator<Annonce_Service> it = annonce_service.iterator();
//	      Annonce_Service aS = new Annonce_Service();
//	      while(it.hasNext()){
//	    	  aS = it.next();
//	    	  annonceServiceRepository.save(aS);
////	    	  annonceServiceRepository.save(it.next());
//	      }	
//		}
//
//
//	
//public Annonce_Service save(Annonce a, petSitting.frontBoot.model.Service s) {
//		
//		Annonce_ServicePK aSPK = new Annonce_ServicePK(a, s);
//		Annonce_Service aS = new Annonce_Service();
//		aS.setKey(aSPK);
//		System.out.println(aS);
//		System.out.println(aS.getVersion());
//		System.out.println(aS.getKey());
//		
//		annonceServiceRepository.save(aS);
//
//		
//		return aS;
//
//	}
<<<<<<< HEAD
//	
//}
=======

	
// ----------------------------------------------------------------------
// ------------------------- Partie GAEL --------------------------------
// ----------------------------------------------------------------------
	@Autowired
	private Annonce_ServiceRepository annonceServiceRepository;
	
	
	public void publierServiceAnnonce(Annonce a, Set<Annonce_Service> annonce_service) { //probleme avec services
		a.setAnnonce_service(annonce_service);
		
		//save a 
//		a= save(a);
		
		//insertion des services dans la table annonce_service
	      Iterator<Annonce_Service> it = annonce_service.iterator();
	      Annonce_Service aS = new Annonce_Service();
	      while(it.hasNext()){
	    	  aS = it.next();
	    	  annonceServiceRepository.save(aS);
//	    	  annonceServiceRepository.save(it.next());
	      }	
		}


	
public Annonce_Service save(Annonce a, petSitting.frontBoot.model.Service s) {
		
		Annonce_ServicePK aSPK = new Annonce_ServicePK(a, s);
		Annonce_Service aS = new Annonce_Service();
		aS.setKey(aSPK);
		System.out.println(aS);
		System.out.println(aS.getVersion());
		System.out.println(aS.getKey());
		
		annonceServiceRepository.save(aS);

		
		return aS;

	}
	
}
>>>>>>> master
