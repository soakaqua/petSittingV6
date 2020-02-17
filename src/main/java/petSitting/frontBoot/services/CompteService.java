package petSitting.frontBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.repositories.CompteRepository;

@Service
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepository;
	
	public Compte save(Compte c) {
		
		Compte compteEnBase = null;
		if(c.getNumC()!=null) {
			Optional<Compte> opt = compteRepository.findById(c.getNumC());
			compteEnBase = (Compte) opt.get();
			compteEnBase.setCp((c.getCp()!=null)?c.getCp():compteEnBase.getCp());
			compteEnBase.setMail((c.getMail()!=null)?c.getMail():compteEnBase.getMail());
			compteEnBase.setMdpC((c.getMdpC()!=null)?c.getMdpC():compteEnBase.getMdpC());
			compteEnBase.setNom((c.getNom()!=null)?c.getNom():compteEnBase.getNom());
			compteEnBase.setPrenom((c.getPrenom()!=null)?c.getPrenom():compteEnBase.getPrenom());
			compteRepository.save(compteEnBase);
			return compteEnBase;
		}
		else {
			compteRepository.save(c);
			return c;

		}

	}
	
//	public Compte connection(String mail, String mdp) {
//		List<Compte> lstc = new ArrayList<Compte>();
//		lstc= compteRepository.checkID(mail, mdp);
//		Compte c = lstc.get(0);
//
//		return c;
//		
//	}
	
	
}
