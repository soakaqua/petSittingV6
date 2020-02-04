package petSitting.frontBoot.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petSitting.frontBoot.repositories.ServiceRepository;

@Service
public class ServiceService {


	
	@Autowired
	private static ServiceRepository serviceRepository;
	
	
	public petSitting.frontBoot.model.Service save(petSitting.frontBoot.model.Service s) {


		petSitting.frontBoot.model.Service serviceEnBase = null;
		if (s.getNumSer() != null) {
			Optional<petSitting.frontBoot.model.Service> opt = serviceRepository.findById(s.getNumSer());
			serviceEnBase = opt.get();
			serviceEnBase.setNomSer((s.getNomSer() != null) ? s.getNomSer() : serviceEnBase.getNomSer());
			serviceEnBase.setPrix((s.getPrix() != 0) ? s.getPrix() : serviceEnBase.getPrix());
			serviceRepository.save(serviceEnBase);
			return serviceEnBase;
		}

		else {
			serviceRepository.save(s);
			return s;

		}

	}
}
 	
