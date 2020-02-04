package petSitting.frontBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.model.Reponse;
import petSitting.frontBoot.repositories.ReponseRepository;

@Service
public class ReponseService {
	
	@Autowired
	private ReponseRepository reponseRepository;
	
	public Reponse save(Reponse s) {
		
		Reponse reponseEnBase = null;
		if(s.getKey()!=null) {
			Optional<Reponse> opt = reponseRepository.findById(s.getKey());
			reponseEnBase = opt.get();
			reponseEnBase.setMessage((s.getMessage()!=null)?s.getMessage():reponseEnBase.getMessage());
			reponseEnBase.setKey((s.getKey()!=null)?s.getKey():reponseEnBase.getKey());

			reponseRepository.save(reponseEnBase);
			return reponseEnBase;
		}
		else {
			reponseRepository.save(s);
			return s;
		}

	}
	
	
	
}
