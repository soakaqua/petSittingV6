package petSitting.frontBoot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Reponse;
import petSitting.frontBoot.model.ReponsePK;
import petSitting.frontBoot.model.Sitter;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.ReponseRepository;

@Service
public class SitterService {

	@Autowired
	private AnnonceRepository annonceRepository;

	@Autowired
	private ReponseRepository reponseRepository;

	public List<Annonce> afficherAnnoncesEnCours() {
		List<Annonce> annonces = annonceRepository.selectAllWithStatut0();
		System.out.println(annonces);
		return annonces;
	}
	

	

	public void postulerAnnonce(Sitter s, Annonce a, String message) {
		ReponsePK key = new ReponsePK((Sitter) s, a);
		Reponse rep = new Reponse(key, message);
		System.out.println(s.getNumC());
		reponseRepository.save(rep);
	}

	public List<Annonce> selectAnnonceBySitter(Integer numC) {

		List<Annonce> annonces = annonceRepository.selectAnnonceBySitter(numC);
		return annonces;

	}
	
	
	public List<Reponse> afficherReponseBySitterAndAnnonce(Integer numC){
		
		List<Annonce> annonces = selectAnnonceBySitter(numC);
		List<Reponse> reponses = new ArrayList<Reponse>();

		List<Reponse> reptemp = new ArrayList<Reponse>();

		for(int i = 0 ; i<annonces.size(); i++) {
			reptemp = reponseRepository.selectReponseByNumCNumA(annonces.get(i).getNumA(), numC);
			reponses.add( reptemp.get(0));
		}
		
		return reponses;
	}

	public void noterP(Double noteP, Annonce a) {
		
		a.setNoteP(noteP);
		annonceRepository.save(a);

	}





//	public Double getNoteMoyenne(Proprio p) {
//		List<Annonce> annonces = annonceRepository.afficherAnnoncesTerminees(p.getNumC());
//		Double moy = 0.0;
//		for (Annonce annonce : annonces) {
//			moy += annonce.getNoteP();
//		}
//		return moy / annonces.size();
//	}
//
// public List<Annonce> afficherAnnoncesTerminees(Integer numC); //faut ajouter cette fonction dans annonceRepository pour que je puisse l 'appeler
	
	
}

//   public void noterP(Double noteP, Annonce a) {
//       EntityManager em=JpaContext.getInstance().createEntityManager();
//       DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance();  attention : supprimer ligne dans dao.
//       Annonce annonce=null;
//       int numC = a.getNumC();
//       Query query=em.createQuery("select a from Annonce a where a.numC=:numC and a.statut=1");
//       query.setParameter("numC", numC);
//      annonce=(Annonce) query.getSingleResult();
//       annonce.setNoteP(noteP);
//       daoAnnonce.update(annonce);
//       em.close();
//   }
//
//   public Double getNoteMoyenne(Proprio p) {
//       EntityManager em=JpaContext.getInstance().createEntityManager();
//       int numC=p.getNumC();
//       Query query=em.createQuery("select AVG(p.noteP) from Proprio p where p.numC=:numC");
//       query.setParameter("numC", numC);
//       Double moyenne=(Double) query.getSingleResult();
//       em.close();
//       return moyenne;
//
//
//   }
