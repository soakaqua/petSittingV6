package petSitting.frontBoot.repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import petSitting.frontBoot.model.Annonce_Service;
import petSitting.frontBoot.model.Annonce_ServicePK;

public interface Annonce_ServiceRepository extends JpaRepository<Annonce_Service, Annonce_ServicePK>  {
	
	@Transactional
	@Modifying
	public void supprAnnonceServiceByNumA(Integer numA);
	
}
