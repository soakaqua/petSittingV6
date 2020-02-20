package petSitting.frontBoot.services;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
	
	@Autowired
	private CompteRepository compteRepository;
	
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
			annonceEnBase.setProprio((p!=null)?p:annonceEnBase.getProprio());
			annonceEnBase.setAnnonce_service((c.getAnnonce_service()!=null)?c.getAnnonce_service():annonceEnBase.getAnnonce_service());
			annonceRepository.save(annonceEnBase);
			return annonceEnBase;
		}
		else {
			c.setProprio(p);
			annonceRepository.save(c);
			return c;
		}
		
	}
		
//	@Column(name="key")
//	@OneToMany(mappedBy="key.annonce")
//	private Set<Annonce_Service> annonce_service;
	
	
	//Moyenne proprio
	public Double moyenneProprio(Integer numC) {
		List<Annonce> lstA = new ArrayList<Annonce>();
		lstA = annonceRepository.selectAnnonceByProprio(numC);
		Integer cpt = 0;
		Double somme = 0.0 ;
		Double moyenne = 0.0 ;
		for(int i = 0  ; i < lstA.size() ; i++) {
			if(lstA.get(i).getNoteP() != null) {
				cpt++;
				somme = somme + lstA.get(i).getNoteP();
			}
		}
		moyenne = somme / cpt;
		return moyenne;
	}
	
	//Moyenne Sitter
	public Double moyenneSitter(Integer numC) {
		List<Annonce> lstA = new ArrayList<Annonce>();
		lstA = annonceRepository.selectAnnonceBySitter(numC);
		Integer cpt = 0;
		Double somme = 0.0 ;
		Double moyenne = 0.0 ;
		for(int i = 0  ; i < lstA.size() ; i++) {
			if(lstA.get(i).getNoteS() != null) {
				cpt++;
				somme = somme + lstA.get(i).getNoteS();
			}
		}
		moyenne = somme / cpt;
		return moyenne;
	}
	
	
}
