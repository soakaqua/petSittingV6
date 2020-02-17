package petSitting.frontBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.CompteRepository;

@Service
public class AnnonceService {
	
	@Autowired
	private AnnonceRepository annonceRepository;
	
//	@Autowired
//	private CompteRepository compteRepository;
//	
//	@Autowired
//	private ReponseRepository reponseRepository;
	
	public Annonce save(Annonce c, Proprio p) {
	
		
		Annonce annonceEnBase = new Annonce();
		if(c.getNumA()!=null) {
			Optional<Annonce> opt = annonceRepository.findById(c.getNumA());
			annonceEnBase = opt.get();
			annonceEnBase.setTitre((c.getTitre()!=null)?c.getTitre():annonceEnBase.getTitre());
			annonceEnBase.setMessage((c.getMessage()!=null)?c.getMessage():annonceEnBase.getMessage());
			annonceEnBase.setNoteP((c.getNoteP()!=null)?c.getNoteP():annonceEnBase.getNoteP());
			annonceEnBase.setNoteS((c.getNoteS()!=null)?c.getNoteS():annonceEnBase.getNoteS());
			annonceEnBase.setStatut((c.getStatut()!=null)?c.getStatut():annonceEnBase.getStatut());
			//annonceEnBase.setProprio((c.getProprio()!=null)?c.getProprio():annonceEnBase.getProprio());
			annonceRepository.save(annonceEnBase);
			return annonceEnBase;
		}
		else {
			annonceRepository.save(c);
			return c;
		}
		
	}
		
	
	
}
